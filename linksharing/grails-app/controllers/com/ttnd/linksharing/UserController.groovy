package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.CO.TopicSearchCo
import com.ttnd.linksharing.CO.UpdatePasswordCo
import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.CO.UserSearchCo
import com.ttnd.linksharing.DTO.EmailDTO
import com.ttnd.linksharing.VO.UserVO
import org.apache.tools.ant.types.resources.Resources

class UserController {
    int x = 0;

    def assetResourceLocator
    def mailService
    def topicService
    def subscriptionService
    def resourceService
    def emailService

    def index() {
        User u = session.user
        List<Subscription> subscriptions = Subscription.findAllByUser(u)
        println "------------------------------${subscriptions}-----------------------"
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(session.user, [sort: 'dateCreated', order: 'desc', max: 10])
        render(view: 'dashboard', model: ['listOfTopics': session.user.subscribedTopics,
                                          readingItems  : readingItems, subscriptions: subscriptions])

    }

    def register(UserCo co) {
        println "===========================+${co.properties}"
        if (!session.user) {
            log.error("user is not registered...")
            flash.message = "please register !"

            User user = new User(firstName: co.firstName, lastName: co.lastName, email: co.email, password: co.password,
                    userName: co.userName, confirmPassword: co.confirmPassword)

            if (!params.pic.empty)
                user.photo = co.pic

            if (user.save(flush: true)) {
//                flash.message = "user saved successfully"
//                redirect(action: 'index', controller: 'login')
                render(view: "register")
            } else {
                render(view: "/login/home", model: [user: user])
            }
        } else
            render("already registered")

    }

    def toggleActive(Long id) {
        if (session.user?.admin) {
            User user = User.findById(id)
            if (user.active)
                user.active = false
            else
                user.active = true

            if (user.save(flush: true))
                flash.message = "Toggled succesfully"
            else
                flash.error = "toggled unsuccesfully"
        }
        redirect(controller: 'user', action: 'list')
    }


    def search() {

    }

    def post(Long postId) {
        Resource resource = Resource.get(postId);
        if (resource.canViewByResource(postId))
            render(view: "post", model: [post: resource])


    }

    def image(Long id) {
        User user = User.findById(id)
        byte[] image
        if (user.photo) {
            image = user.photo
        } else {
            image = assetResourceLocator.findAssetForURI('userImage.jpeg').byteArray
        }
        OutputStream out = response.getOutputStream()
        out.write(image)
        out.flush()
        out.close()


    }


    def list(UserSearchCo userSearchCO) {
        List<UserVO> userVOList = []
        if (session.user?.admin) {
            User.search(userSearchCO).list([sort: userSearchCO.sort, order: userSearchCO.order]).each { user ->
                userVOList.add(new UserVO(id: user.id, userName: user.userName, email: user.email, firstName: user.firstName,
                        lastName: user.lastName, active: user.active))
            }
            render(view: 'list', model: [users: userVOList])


        } else {
            redirect(controller: 'user', action: 'index')
        }
    }

//    def canDeleteResource(Long postId)
//    {
//        Resource resource= Resource.get(postId)
//        if(resource.createdBy==session.user||(session.user?.admin==true)) {
//            resource.delete()
//
//        }
//    }


    def mail() {
        if (mailService.sendMail {
            to "shalika.singhal@tothenew.com"
//           from "shalika.singhal@tothenew.com"
            subject "Hello sha"
            body 'How are you?'
        })
            render "sucessss"
        else
            render "failure"
    }


    def profile(ResourceSearchCo co) {

        co.max = co.max ?: 5
        co.offset = co.offset ?: 0
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: co.id, visiblity: co.visiblity, max: co.max, offset: co.offset)
        User user = User.findById(co.id)
        Integer totalCount = Resource.countByCreatedBy(user)
        List<Topic> topic = topicService.search(topicSearchCo)

        List<Topic> subscriptionTopic = subscriptionService.search(topicSearchCo)
        Integer totalCount1 = Subscription.countByUser(user)

        List<Resource> resourceList = resourceService.search(co)
//        totalCount += resourceList.size()
//        println("=========${resourceList.size()}=================")
        if (!request.xhr) {
            render(view: "/user/profile", model: [topics: topic, subscriptions: subscriptionTopic, resources: resourceList, co: co, totalCount: totalCount
            ,totalCount1: totalCount1])

        } else
            render(template: "/user/resourceAjax", model: [resources: resourceList, co: co, totalCount: totalCount])


    }

    def profile2(TopicSearchCo co) {
         println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh")

        co.max = co.max ?: 5
        co.offset = co.offset ?: 0
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: co.id, visiblity: co.visiblity, max: co.max, offset: co.offset)
        User user = User.findById(co.id)
        Integer totalCount = Resource.countByCreatedBy(user)
        List<Topic> topic = topicService.search(topicSearchCo)

        List<Topic> subscriptionTopic = subscriptionService.search(topicSearchCo)
        Integer totalCount1 = Subscription.countByUser(user)

        List<Resource> resourceList = resourceService.search(co)
//        totalCount += resourceList.size()
//        println("=========${resourceList.size()}================="

        render(template: "/user/profileSubscription", model: [subscriptions: subscriptionTopic, co: co, totalCount1: totalCount1])


    }


    def forgotPassword(String email) {
        User user = User.findByEmail(email)

        if (user && user.active) {
            String newPassword = Utill.getRandomPassword()
            user.password = newPassword
            EmailDTO emailDTO = new EmailDTO(to: [email], subject: "Your Link sharing New Password",
                    view: '/email/_password', model: [newPassword: newPassword])

            emailService.sendMail(emailDTO)
            if (User.updatePassword(newPassword, email)) {
                println("-------------inside user forgot password ===========")
                flash.message = " hello ${user.userName} you will get your new password via mail"
            } else {
                flash.error = "Please try again"
            }
        } else {
            flash.error = "You are not authorized user"
        }
        redirect(controller: "login", action: "index")
    }


    def privateProfile(Long id) {
        User user = User.findById(id)
        List<Topic> topicList = Topic.findAllByCreatedBy(user)
        render(view: 'privateProfile', model: [topicList: topicList, id: id])
    }

//    def changePassword(String password1, String confirmPassword) {
//        if (password1 == confirmPassword) {
//            println("+++++++++++++++${password1} ${confirmPassword}+++++++++++++++++++++ ")
//
//            if (User.executeUpdate("update User set password='${confirmPassword}' where id='${session.user.id}'")) {
//                render(view: 'changePassword')
//            } else {
//                render "unsuccesfulllllll"
//            }
//        } else render "password dosnt match confirm password"
//    }

    def updatePassword(UpdatePasswordCo updatePasswordCo) {
        println("===============hello update===========")
        if (User.executeUpdate("update User set password='${updatePasswordCo.password}' where id='${updatePasswordCo.id}'")) {
            render(view: 'updatePassword')
        } else {
            render "unsuccesfulllllll"
        }

    }


    def updateProfile(UserCo userCo) {
        println("====================${userCo.properties}+++++++++++++++++")
        if (User.executeUpdate("update User set firstName='${userCo.firstName}' ,lastName='${userCo.lastName}'," +
                "userName='${userCo.userName}', photo='${userCo.pic}' where id='${session.user.id}' ")) {
            render "saved sucessfully"

        } else
            render "unsucesfullll"


    }


}
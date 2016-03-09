package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.ResourceRating
import com.ttnd.linksharing.VO.TopicVo
import com.ttnd.linksharing.Topic
import com.ttnd.linksharing.Subscription

class UserController {

    def assetResourceLocator
    def mailService

    def index() {
        User u = session.user
        List<Subscription> subscriptions = Subscription.findAllByUser(u)
        println "------------------------------${subscriptions}-----------------------"
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(session.user, [sort: 'dateCreated', order: 'desc', max: 3])
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
            if (user.save(flush: true)) {
                flash.message = "user saved successfully"
                redirect(action: 'index', controller: 'login')
            } else {
                flash.error = "user cant eb saved"
                render(template: "createForm", model: [user: user])
//                render (view: 'index')
//                flash.message = "validations failed"
//                render flash.message
                // render "$flash.message  $user.properties"
            }
        } else
            render("already registered")

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
//        render asset.image([src: '/image/userImage.jpeg', height: '64', width: '62'])


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
            to "surbhi.dhawan@tothenew.com"
//           from "shalika.singhal@tothenew.com"
            subject "Hello sakshi"
            body 'How are you?'
        })
            render "sucessss"
        else
            render "failure"
    }


}
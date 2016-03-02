package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.ResourceRating
import com.ttnd.linksharing.VO.TopicVo
import com.ttnd.linksharing.Topic

class UserController {

    def index() {
//
        List<TopicVo> topicVos = Topic.trendingTopics()
        render(view: 'dashboard', model: ['listOfTopics': session.user.subscribedTopics, trendingTopics: topicVos])
//        render(view: 'dashboard')

    }

    def register(UserCo co) {
        println "===========================+${co.properties}"
        if (!session.user) {
            log.error("user is not registered...")
            flash.message = "please register !"
            User user = new User(firstName: co.firstName, lastName: co.lastName, email: co.email, password: co.password,
                    userName: co.userName, confirmPassword: co.confirmPassword)
            if (user.save(flush: true)) {
//                flash.message = "${user.firstName} registered successfully"
//                render flash.message

                redirect(action: 'index', controller: 'login')


            } else {
                //render(view: 'createForm', model: [user: user])
                //render (view: 'index')
                flash.message = "validations failed"
                render "$flash.message  $user.properties"

            }
            //  render(view: 'createForm')
        } else
            render("already registered")
        //  render(view: 'createForm')

    }

//    def createForm() {
//        //render(view: 'createForm')
//       // render "hiiiiiiiiiiiii"
//        [a:1]
//    }


}
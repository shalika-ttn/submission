package com.ttnd.linksharing

import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.ResourceRating

class UserController {

    def index() {

        render "User Dashboard "
        render "${session.user.userName}"

    }

//    def register(UserCo co) {
//
//        if (!session.user) {
//            log.error("user is registered...")
//            flash.message = "please register first!"
//            User user = new User(firstName: co.firstname, lastName: co.lastname, email: co.email, password: co.password)
//            if (user.validate()) {
//                flash.message = "${user.firstName} registered successfully"
//                render flash.message
//
//            } else {
//                render(view: 'createForm', model: [user: user])
//                //flash.message = "validations failed"
//                //render "$flash.message  $user.properties"
//
//            }
//        } else
//            render("already registered")
//
//    }


    def createForm() {
        render(view: 'createForm')
    }

    def topPosts() {
        if (!session.user) {
            List result = ResourceRating.showTopPost()

            List<Resource> resources = Resource.getAll(result)
            render "$resources"
        }
        render ""
    }
}
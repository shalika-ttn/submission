package com.ttnd.linksharing

class UserController {

    def index() {

        render "User Dashboard"

    }

    def register() {
        if (!session.user) {
            flash.message = "User is not set"
            render flash.message
        } else {
            render "Success"
        }


    }

}

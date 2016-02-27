package com.ttnd.linksharing


class LoginController {

    def index() {
        if (session.user) {
            forward(controller: 'User', action: 'index')
        } else {
           render(view:'Home',model:[resources:'${resources}'] )
        }
    }


    def login(String userName, String password) {
        User user = User.findByUserNameAndPassword(userName, password)
        if (user) {
            if (user.active) {
                session.user = user
                redirect(controller: 'user', action: 'index')
            } else
                flash.message = "Your accoutn is not active"

        } else {
            flash.message = "User not found"
            render flash.message
        }
    }

    def logout() {
        session.invalidate()
        redirect(controller: 'Login', action: 'index')

        render "Logged out"
    }
}

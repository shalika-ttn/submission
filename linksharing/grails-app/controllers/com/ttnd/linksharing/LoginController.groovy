package com.ttnd.linksharing


class LoginController {

    def index() {
        if (session.user) {
            forward(controller: 'User', action: 'index')
        } else
            render "failure"
    }


    def login(String username, String password) {
        User user = User.findByUserNameAndPassword(username, password)

        if (user?.active) {
            session.user = user
            redirect(action: 'index')
        } else "$user?user is not active:user does not exist"

    }

    def logout() {
        session.invalidate()
        redirect(controller: 'Login', action: 'index')

        render "Logged out"
    }
}

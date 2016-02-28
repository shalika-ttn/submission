package com.ttnd.linksharing
import com.ttnd.linksharing.Resource
import com.ttnd.linksharing.ResourceRating

class LoginController {

    def index() {
        if (session.user) {
            forward(controller: 'User', action: 'index')
        } else {

           render(view:'Home',model:[resources:'resources'] )
        }
    }

    def topPost() {
        if (!session.user) {
            List result = ResourceRating.showTopPost()

            List<Resource> resources = Resource.getAll(result)
            //render "$resources"
           // render (view:'topPost',model: [resources:resources] )
            redirect(action:'index',controller:'login')
        }
        else  render "hioiiii "
    }
  def  recentPost()
  {
      if (!session.user) {
          List result = ResourceRating.showRecentPost()

          List<Resource> resources = Resource.getAll(result)
          //render "$resources"
           render (view:'recentPost',model: [resources:resources] )
          //redirect(action:'index',controller:'login')
      }
      else  render "hioiiii "


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

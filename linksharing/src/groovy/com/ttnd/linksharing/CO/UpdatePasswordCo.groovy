package com.ttnd.linksharing.CO

import com.ttnd.linksharing.User

class UpdatePasswordCo {


    String oldPassword
    String password
    String id

     static  constraints =
             {
              importFrom User
                 oldPassword(nullable:false,validator:{obj,val->
                     if(val!=obj.password)
                                 return false

                 })



             }
    User getUser(Long id) {
        User user = User.findByid(id)
    }
}

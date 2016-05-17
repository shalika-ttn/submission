package com.ttnd.linksharing.CO

import grails.validation.Validateable

@Validateable
class UserCo {
    String firstName
    String lastName
    String email
    byte[] pic;
    String username
    String password
    String confirmPassword
    Boolean active



}

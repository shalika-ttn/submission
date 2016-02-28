package com.ttnd.linksharing

class User {

    String firstName
    String lastName
    String userName
    String password
    String email
    Byte[] photo
    Boolean admin
    Boolean active =true
    Date DateCreated
    Date lastUpdated
    String confirmPassword
    long id
    static transients = ['name', 'confirmPassword']

    static mapping = {
        photo(type: 'blob')
        sort id: 'desc'

    }

    static constraints = {


        email(unique: true, email: true, blank: false, nullable: false)

        password(nullable: false, blank: false, minSize: 5)
        photo(nullable: true)
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        active(nullable: true)
        admin(nullable: true)


        confirmPassword bindable: true, nullable: true, blank: true, validator: { val, obj ->
            //println "obj:${obj}******${val}"
            if (obj.password != val) {
                return false
            }
        }

    }


    String getName() {
        "$firstName $lastName"

    }


//    String toString() {
//        "welcome $firstName "
//    }
    static hasMany = [topics         : Topic, subscriptions: Subscription, resources: Resource, readingItems: ReadingItem,
                      resourceRatings: ResourceRating]
}

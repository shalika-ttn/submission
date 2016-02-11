package com.ttnd.linksharing

class User {

    String firstName
    String lastName
    String userName
    String password
    String email
 Byte[] photo
    Boolean admin
    Boolean active
    Date DateCreated
    Date lastUpdated
    static transients=['name']

    static  mapping = {
   photo(type:'blob')
    }

    static constraints = {


        email(unique: true, email: true, blank: false, nullable: false)

        password(nullable: false, blank: false, minSize: 5)

        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        active(nullable: true)
        admin(nullable: true)

    }



    String getName() {
        [firstName, lastName].findAll { it }.join(' ')

    }

    static hasMany = [topics:Topic,subscriptions:Subscription,resources:Resource,readingItems:ReadingItem,
     resourceRatings:ResourceRating]
}

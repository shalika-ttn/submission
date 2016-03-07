package com.ttnd.linksharing

import com.ttnd.linksharing.Resource

class User {

    String firstName
    String lastName
    String userName
    String password
    String email
    Byte[] photo
    Boolean admin
    Boolean active = true
    Date dateCreated
    Date lastUpdated
    String confirmPassword
    long id
    static transients = ['name', 'confirmPassword', 'subscribedTopics']
    static hasMany = [topics         : Topic, subscriptions: Subscription, resources: Resource, readingItems: ReadingItem,
                      resourceRatings: ResourceRating]

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
        userName(nullable:false,blank: false,unique: true )


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

    List<Topic> getsubscribedTopics() {
        List<Topic> result = Subscription.createCriteria().list() {


            projections {
                property('topic')
            }


            eq('user.id', this.id)
        }

        result

    }

    Boolean canDeleteResource(Long resourceId) {
        Resource resource = Resource.findById(resourceId)

        if ((resource.createdBy == this) || this?.admin)
            true
        else
            false

    }

    Boolean isSubscribed(Long topicId) {
        Integer subscriptionsCount = Subscription.createCriteria().count() {

            eq('user', this)
            eq('topic', topicId)

        }

        if (subscriptionsCount)
            true
        else
            false

    }




    String toString() {
        "$firstName "
    }

}

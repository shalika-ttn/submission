package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visiblity


class Topic {


    String name
    User createdBy
    Date dateCreated
    Date lastUpdated

    Visiblity visiblity

    static constraints = {

        name(nullable: false, blank: false, unique: 'createdBy')

        createdBy(nullable: false)


    }
 static  mapping = {
     sort "name"
 }
    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(topic: this, user: this.createdBy, seriousness: Seriousness.VERY_SERIOUS).save()
            //this.createdBy.addToSubscriptions(subscription)
        log.info(" subscription saved  ")
        } //this.addToSubscription(subscription)

    }
    String toString()
    {
        "This is topic $name"
    }
    static hasMany = [resources: Resource, subscription: Subscription]


}

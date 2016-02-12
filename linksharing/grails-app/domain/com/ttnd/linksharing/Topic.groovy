package com.ttnd.linksharing

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
    static hasMany = [resources: Resource, subscription: Subscription]
}

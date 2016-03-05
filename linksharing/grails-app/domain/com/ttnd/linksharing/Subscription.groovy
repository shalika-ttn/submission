package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness

class Subscription {

    Date dateCreated
    Date lastUpdated
    Seriousness seriousness =Seriousness.SERIOUS
    static constraints = {
        user(nullable: false)
        topic(nullable: false, unique: 'user')


    }
    static belongsTo = [user: User, topic: Topic]

    def afterInsert()
    {

    }
}

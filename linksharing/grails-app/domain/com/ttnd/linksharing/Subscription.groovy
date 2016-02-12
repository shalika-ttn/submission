package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness

class Subscription {

    Topic topic
    User user

    Date DateCreated
    Date lastUpdated
    Seriousness seriousness
    static constraints = {
        user(nullable: false)
        topic(nullable: false, unique: 'user')


    }
    static belongsTo = [user: User, topic: Topic]
}

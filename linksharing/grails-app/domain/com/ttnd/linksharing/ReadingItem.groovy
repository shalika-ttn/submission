package com.ttnd.linksharing

class ReadingItem {

    Resource resource
    User user
    Boolean isRead
    Date DateCreated
    Date lastUpdated

    static constraints = {
        resource(unique: 'user',nullable: false)
        user (nullable: false)
    }
    static belongsTo = [user:User,resource:Resource]
}

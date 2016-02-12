package com.ttnd.linksharing

import javax.validation.groups.Default

class ReadingItem {

    Boolean isRead
    Date DateCreated
    Date lastUpdated

    static constraints = {
        resource(unique: 'user', nullable: false)
        user(nullable: false)

    }
    static belongsTo = [user: User, resource: Resource]
}

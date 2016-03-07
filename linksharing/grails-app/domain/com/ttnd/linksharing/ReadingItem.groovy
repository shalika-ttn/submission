package com.ttnd.linksharing

import javax.validation.groups.Default

class ReadingItem {

    Boolean isRead
    Date dateCreated
    Date lastUpdated
    static belongsTo = [user: User, resource: Resource]
    static constraints = {
        resource(unique: 'user', nullable: false)
        user(nullable: false)

    }


}

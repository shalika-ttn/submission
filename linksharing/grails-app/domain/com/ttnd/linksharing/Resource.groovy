package com.ttnd.linksharing

abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date DateCreated
    Date lastUpdated

    static  mapping = {
         description(type: 'text')
    }

    static constraints = {
    }
    static belongsTo = [topic:Topic]
    static hasMany = [resourcesRatings:ResourceRating,readingItems:ReadingItem]
}

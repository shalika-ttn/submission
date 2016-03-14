package com.ttnd.linksharing


import grails.converters.JSON

class ReadingItemsController {

    def index() { render "welcome to readingitem" }

    def changeIsRead(Long id, Boolean isRead) {

        println("================inside chnge is read+++++++++++++++++++++++++++")
        Map result = [:]
        if (ReadingItem.executeUpdate("update ReadingItem set isRead=${isRead} where id=${id}")) {
            result.message = "successfully changed isRead"
        } else {
            result.error = "cant changed isRead property"
        }
        render result as JSON
    }


}

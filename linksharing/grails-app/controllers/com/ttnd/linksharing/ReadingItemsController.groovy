package com.ttnd.linksharing

import com.ttnd.linksharing.ReadingItem
import grails.converters.JSON

class ReadingItemsController {

    def index() { render "welcome to readingitem" }

    def changeIsRead(Long id, Boolean isRead) {

        if (ReadingItem.executeUpdate("update ReadingItem set isRead=${isRead} where id=${id}")) {
            render ([message:"successfully changed isRead"]as JSON)
        } else {
            render ([error:"updation unsuccessful!"]as JSON)
        }

    }


}

package com.ttnd.linksharing

import com.ttnd.linksharing.ReadingItem

class ReadingItemsController {

    def index() { render "welcome to readingitem" }

    def changeIsRead(Long id, Boolean isRead) {

        if (ReadingItem.executeUpdate("update ReadingItem set isRead=${isRead} where id=${id}")) {
            render 'successfully changed isRead'
        } else flash.message = "updation unsuccessful!"

    }


}

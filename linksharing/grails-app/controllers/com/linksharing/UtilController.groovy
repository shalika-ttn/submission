package com.linksharing

class UtilController {

    def index() {

        log.fatal(" testing log fatal ")

        log.error("testing error log")

        log.trace("testing trace")
        log.info("testing info")

        render "hello this page  is displaying Logs "

        render(grailsApplication.config.grails.shalika)
    }
}

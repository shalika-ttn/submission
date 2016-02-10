package com.linksharing

class UtilController {

    def index() {

        log.fatal(" testing log fatal ")

        log.error("testing error log")

        log.trace("testing trace")

        render "helllo logs"
    }
}

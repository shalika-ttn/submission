package com.ttnd.linksharing.CO

import com.ttnd.linksharing.Enum.Visiblity
import grails.validation.Validateable

@Validateable
class ResourceSearchCo extends SearchCo {

    Long topicId
    Visiblity visiblity
}

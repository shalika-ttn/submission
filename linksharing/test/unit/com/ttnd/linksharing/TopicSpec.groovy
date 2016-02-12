package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    //@Unroll("Executing #sno")
    void "topic validations"() {
        expect:
         Topic topic =new Topic(name:tname,user:user1,visiblity: visiblity)

        when:
        Boolean result = topic.validate()

        then:
        result == valid

        where:
        tname|user1|visiblity|valid
        "grails"|new User()|Visiblity.PUBLIC |true



    }


}

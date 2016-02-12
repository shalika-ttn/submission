package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }



    void "test document resource"() {
        given:
        DocumentResource doc =new DocumentResource(file:f1)

        when:
        Boolean result=doc.validate()
        then:
        result==valid
        where:
        f1|valid
        "file.grails/config.groovy"|true



    }
}

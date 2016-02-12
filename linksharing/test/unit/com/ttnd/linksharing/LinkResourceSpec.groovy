package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test link"() {
        given:
        LinkResource link = new LinkResource(url: url1, description: "hello", createdBy: new User(), topic: new Topic())

        when:
        Boolean result = link.validate()
        then:
        result == valid
        where:
        url1                 | valid
        "abc"                | false
        "ftp://foo.bar.com/" | true


    }
}

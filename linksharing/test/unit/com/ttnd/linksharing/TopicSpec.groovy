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
        User user1 = new User(firstName: fname, lastName: lname, email: email, password: password, userName: uname,
                admin: admin, active: active);
        and:
        Topic topic =new Topic(name:tname,user:user1)

        when:
        Boolean result = topic.validate()

        then:
        result == valid

        where:
        sno | fname     | lname     | email       | password  | admin | uname | active | valid|tname
        //1   | "shalika" | "singhal" | "abc@gmail.com" | "test123" | false  | "shal" | true   | true| "grails"
        2   | "test123" | "hello" | "puneet@gmail.com"  | "test12398" | false|"hii"|false|true|"groovy"
    }


}

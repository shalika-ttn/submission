package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {

    }

    def cleanup() {
    }

    @Unroll("Executing #sno")
    void "test user validations"() {
        expect:
        User user = new User(firstName: fname, lastName: lname, email: email, password: password, userName: uname,
                admin: admin, active: active);

        when:
        Boolean result = user.validate()

        then:
        result == valid

        where:
        sno | fname     | lname     | email              | password   | admin | uname  | active | valid
        1   | ""        | "hello"   | "a@b.com"          | "test123"  | false | " "    | true   | false
        2   | "shalika" | "singhal" | "shalika"          | "test123"  | false | "sha"  | false  | false
        5   | "saloni"  | "sharma"  | "saloni@gmail.com" | "te1238"   | true  | "sal"  | true   | true
        4   | "testsha" | "hello"   | "test@gmail.com"   | "test1238" | true  | "test" | true   | false
        3   | "testsha" | "hello"   | "test@gmail.com"   | "test1238" | true  | "test" | true   | false
    }

    def "get user full name"() {

        expect:
        new User(firstName: firstName, lastName: lastName).name == name

        where:
        firstName | lastName | name
        "shalika" | "singhal"   | "shalika singhal"
        ""        | "singhal"   | "singhal"
        null      | "singhal"   | "singhal"
        "saloni"  | ""       | "saloni"
        "saloni"  | null     | "saloni"
        null      | null     | ""
    }


}
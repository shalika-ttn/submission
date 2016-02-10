package com.im.test

import groovy.xml.StreamingDOMBuilder
import org.codehaus.groovy.runtime.StringBufferWriter
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll


class UserSpec extends Specification {


    def "FirstName and LastName of User"() {

        given: "We have user object"
        User user = new User(firstName: "surbhi", lastName: "Dhawan")

        expect:
        user.getFullName() == "surbhi Dhawan"

    }

    def "Display user name"() {

        given: "display name"
        User user1 = new User(firstName: "shalika", lastName: "Singhal")

        and:
        user1.gender = "Female"

        when:
        user1.displayName()

        then:
        user1.displayName() == "Msshalika Singhal"
    }

    def "Is valid password"() {

        given:
        User user2 = new User(firstName: "shalika", lastName: "singhal")

        when:
        boolean result = user2.isValidPassword("axschgvafsf")

        then:
        result == true

    }

    def "encrypt pasword mocking"() {

        given:
        User user = new User()

        and:
        def mockedEncrypterService = Mock(PasswordEncrypterService)
        user.passwordEncrypterService = mockedEncrypterService

        and: "creating a mock"
        mockedEncrypterService.encrypt(_) >> { result }

        when:
        String result1 = user.encyryptPassword(password)

        then:
        result1 == result

        where:
        password     | result
        "test"       | null
        "afsvfvdesw" | "ok"


    }

    @Unroll
    def "get income group spec"() {

        given:
        User user = new User(incomePerMonth: i)


        when:
        String result3 = user.getIncomeGroup()

        then:
        result3 == expectedresult

        where:
        i     | expectedresult
        2000  | "MiddleClass"
        8000  | "Lower MiddleClass"
        12000 | "Higher MiddleClass"
    }


    def "purchase product"() {

    }

    def "reset password"() {
        setup:
        User user = new User(password: currpass)
        user.metaClass.encyryptPassword = { String str ->
            return encrypt_pass
        }
        and:
        def mockedemailservice = Mock(EmailService)
        user.emailService = mockedemailservice
        mockedemailservice.sendCancellationEmail(user, _) >> {}

        when:
        user.resetPasswordAndSendEmail()

        then:
        user.password == encrypt_pass

        where:
        encrypt_pass | currpass
        "password"   | "shalikaa"

    }


    def "purchase product"() {
        given:
        User user = new User()
        and: "a lsit of products"
        List<Product> purchasedProducts = []
        and:
        Product p = new Product(name: "bottle")
        when:
        user.purchase(p)
        then:
       user.purchasedProducts.contains(p) == true

    }

    def "cancel product"(){
        given:
        User user = new User()
        and:
        Product p = new Product(name: "bottle")
        and: "a lsit of products"
        List<Product> purchasedProducts = ["bottle"]
        when:
        user.cancelPurchase(p)
        then:
        user.purchasedProducts.contains(p) == false
    }

  def "sorted interseted"()
  {
      setup:
      User user = new User()
      and:
      user.metaClass.getInterestedInCategories = {
      }

  }

}
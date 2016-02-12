package com.im.test

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TransactionSpec extends Specification {

   /* @Shared transaction = new Transaction()

    void "Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
        setup:
        Product product = new Product(price: 100)
        User user = new User(balance: 200)

        when:
        transaction.sell(product, user)

        then:
        user.balance ==  100.toBigDecimal()
    }


    void "Improvement #1 Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: 200)

        when:
        transaction.sell(product, user)

        then:
        user.balance ==  100.toBigDecimal()
    }


    void "Improved #2 Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: 200)

        expect:
        !user.isPrivellegedCustomer
        product.discountType == DiscountType.NONE

        when:
        transaction.sell(product, user)

        then:
        user.balance ==  100.toBigDecimal()
    }


    void "An exception is thrown if user's balance is not enough"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: 50)

        when:
        transaction.sell(product, user)

        then:
        def e =thrown(SaleException)
        e.message == "Not enough account balance"
    }

    void "Improvement #1 An exception is thrown if user's balance is not enough"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: balance)

        when:
        transaction.sell(product, user)

        then:
        def e =thrown(SaleException)
        e.message == "Not enough account balance"

        where:
        balance << [50, 0]
    }

    @Unroll("An exception is thrown when #description")
    void "Improvement #2 An exception is thrown if user's balance is not enough"(){
        given:
        Product product = new Product(price: 100)

        and:
        User user = new User(balance: balance)

        when:
        transaction.sell(product, user)

        then:
        def e =thrown(SaleException)
        e.message == "Not enough account balance"

        where:
        balance << [50, 0]

        description = balance==50?'less than product cost': 'user has no balance'
    }*/

    def " test sell"()
    {
        given:
        User user= new User(balance:bal )

       and:
       Product product=new Product(price:price )
       Transaction transaction= new Transaction()

        when:
        user.purchase(product)
        transaction.sell(product,user)

        then:
        //def e =thrown(SaleException)
        //e.message != "Not enough account balance"
        user.balance==(bal-price).toBigDecimal()
        where:
        bal|price
        100|50


    }
    def "cancle sale"()
    {
        given:
        User user= new User(balance:bal )

        and:
        Product product=new Product(price:price )
        Transaction transaction= new Transaction()
        and:
        def mockedEmailSerice=Mock(EmailService)
        transaction.emailService=mockedEmailSerice
       when:
       transaction.cancelSale(product,user)
        then:
        mockedEmailSerice.sendCancellationEmail(user,_ as String)
        where:
        bal|price
        200|100

    }

      def "calculate discount"()
      {
          given:
          User user= new User(balance:100,isPrivellegedCustomer:true )
          and:
          Product product=new Product(name:"handbag",price:price,discountType:"PRIVELLEGE_ONLY" )
          Transaction transaction= new Transaction()

          when:
          def discount=transaction.calculateDiscount(product,user)

          then:
          discount==expectedDiscount

          where:
          price|expectedDiscount
          50|15

      }

  def "getAllPopularProducts"()
  {

      given:
      Product product=new Product(name:"handbag",isPopular: true)
      Transaction transaction= new Transaction()
      List l =["handbag","purse","bottle"]
      and:
     // def mockedProduct=Mock(Product)
      //product=mockedProduct
      Mock(Product).getCurrentProducts={ return  l}

      when:

      def l3= transaction.getAllPopularProducts()
      then:
      l3.contains("handbag")==true


  }
}

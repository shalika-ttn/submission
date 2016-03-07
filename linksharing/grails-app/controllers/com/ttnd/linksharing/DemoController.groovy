package com.ttnd.linksharing

import com.ttnd.linksharing.MyCustomBean
import grails.util.Holders
import org.springframework.beans.factory.annotation.Autowired

class DemoController {

    def helloService
//    def demoService
 def myBean
//    @Autowired
//    MyCustomBean myBean
   // def myBeanUsingConstructor

    def index() {
//        render demoService.add(10, 20)
        render ""
        render("${myBean.properties} ::::::: ${myBean.class}")
        render ""
        render ""
//        render("${myBeanUsingConstructor.properties}")
//     render $custombeam1

           render helloService.saveUser()
        def c = Holders.applicationContext.getBean('myBean')
        render("${c.properties} ::::::: ${c.class} ${c}")
    }

}

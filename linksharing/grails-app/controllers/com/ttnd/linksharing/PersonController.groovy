package com.ttnd.linksharing


import com.ttnd.linksharing.CO.personCo

class PersonController {

    def index() {
         render "hello"
    }

    def binding()
    {
         render params.name
        render params.age
        render params.ssn
    }

     def binding2()
     {
         Person person=new Person(params)
//         if( person.save(flush: true))
//         {
//             render "saved ${person.properties} "
//         }
//         else render "${person.properties}"

         println person.hasErrors()
         if(person.hasErrors())
         {
             println "The value ${person.errors.getFieldError('age')}"
             if(person.errors.hasFieldErrors("age"))
             {
                 println person.errors.getFieldError("age").rejectedValue
             }
         }
         else  render"succesfulll"


     }
    def binding3()
    {
         Person person=Person.get(1)
        render"---------before ${person.properties}  "

        person.properties=params
        render"---------after ${person.properties} "
    }

    def conversion()
    {
        int age=params.int("age")
        String name=params.name
        float ssn=params.float("ssn")
//        Date dob=params.date("dob","dd-MM-yyyy")
        Date dob=params.date("dob","dd-MMM-yyyy")
        render   name
        render age
        render ssn
        render "<br>"
        render dob
        render "<br>"
        render "${params.getProperties()}"

    }

    def usingCo(personCo personco)
    {
        render personco.properties
        render "<br>"
         render personco.errors
        render "<br>"
        render personco.validate()
        render "<br>"
        if (personco.hasErrors())
        {
            render  personCo.errors.getFieldError("frndname").rejectedValue
        }


    }




}

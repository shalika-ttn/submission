package com.ttnd.linksharing

class Person {

    Integer ssn
    String name
    Integer age
    String location

    static constraints =
            {
              location nullable: true
     }
}

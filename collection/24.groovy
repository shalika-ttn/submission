/* Conside a class named "Employee" which has the following properties: 1) Name 2) Age 3) DepartmentName 4) EmployeeNumber 5) Salary
  Let's say that there's a list of 50 employees available. Perform the following operations on the list of employees:
   a) Group the employees on the basis of the bracket in which their salary falls. The ranges are 0-5000, 5001 and 10000, and so on.
    b) Get a count of the number of employees in each department c) Get the list of employees whose age is between 18 and 35 d) Group the employees according to the alphabet
  with which their first name starts and display the number of employees in each group whose age is greater than 20 e) Group the employees according to their department*/
  
  class Employee
  {
     String Name
     int age
     String dname
     int empnum
     int salary
  }
  List l=[new Employee([Name:"saloni",age:16,dname:"IT",empnum:27,salary:16000]),
          new Employee([Name:"surbhi",age:22,dname:"CS",empnum:40,salary:5000]),
          new Employee([Name:"shalika",age:23,dname:"IT",empnum:39,salary:4000]),
          new Employee([Name:"anshubhi",age:44,dname:"CS",empnum:15,salary:5001]),
          new Employee([Name:"vidhi",age:23,dname:"CIVIL",empnum:32,salary:10000])]
          
          
     Map m= l.groupBy{ if((it.salary>=0)&&(it.salary<=5000))
                       "0-5000"
                     else if(it.salary==5001)
                       "5001" 
                     else if(it.salary==10000)
                          "10000" 
                      else if(it.salary>10000)
                         "10000 onwards"  }          
    
 print "a part "
 m.each{i,v-> print i + " " + v.Name + " " }
  println " "
  
  print "b part "
 
 Map m2=l.groupBy{ it.dname}
 m2.each{i,v->print i + " "+ v.size() + " "}
                       
 print "\n" +"c part "
  Map m3=l.groupBy{ if((it.age>=18)&&(it.age<=35))
                    "18-35"
                    else
                    "<18 &>35 "
                    }
 m3.each{i,v-> print i + " " + v.Name + " " }
 
   println "\n" +"d part "
    Map m4=l.groupBy{ it.name.charAt(0) 
                       "${it.name.charAt(0)}"
                     }
    def n=0
 m4.each{i,v->  v.each{ if(it.age>=20)
                            n++ }
                            println "name starting with " + i + " having age >20 " + n + " "
                            n=0
                            
             }
             
 print " part e "
    Map m5=l.groupBy{ it.dname}
 m5.each{i,v->print i + " "+ v.Name + " "}
      
                       
                       
                    
  
  
  
  
  
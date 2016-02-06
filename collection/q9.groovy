/*Consider a class Employee with following details * Name * Age * Salary 
Create a list consisting of 10 Employee objects. 6(a). 
Get a list of employees who earn less than 5000 6(b). 
Get the name of the youngest employee and oldest employee 6(c). 
Get the employee with maximum salary 6(d). 
Get the list of names of all the employees */

class Employee
{
 String name
 int age
 int salary
}

def list1=[new Employee([name:"shalika",age:23,salary:16000]),
            new Employee([name:"surbhi",age:22,salary:25000]),
            new Employee([name:"saloni",age:23,salary:17000]),
            new Employee([name:"john",age:27,salary:4000]),
            new Employee([name:"sakshi",age:23,salary:18000]),
            new Employee([name:"rahul",age:25,salary:50000]),
            new Employee([name:"mishika",age:22,salary:19000]),
            new Employee([name:"isha",age:24,salary:35000]),
            new Employee([name:"shubhi",age:27,salary:76000]),
            new Employee([name:"srk",age:26,salary:3000])]
 
 println list1.findAll{ it.salary<5000 }*.name        
  println list1.min{ it.age }*.name                     
  println list1.max{ it.age }*.name
  println list1.max{ it.salary }*.name
  
   println list1.findAll{ it }*.name        
  
 
              
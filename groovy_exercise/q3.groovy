class Employee extends Person
{
 int empid;
 String company;
 int salary;
 
  String getCompany() {
        return company;
    }

    void setCompany(String company) {
        this.company= company;
    }
 int getEmpId() {
        return empid;a
    }

    void setEmpId(int empid) {
        this.empid =empid;
    }

 int getSalary() {
        return salary;
    }

    void setSalary(int salary) {
        this.salary=salary;
    }
 
 String toString()
{
 "$name is a man aged $age who lives at $address He works for $company with employee id $empid and draws $salary lots  of money !!!!"
 
}
}
def emp1=new Employee([name:"sachin",gender:"male",empid:39,salary:15000,age:24,address:"Delhi"])

emp1.@company="To the New Digital"
 
println emp1



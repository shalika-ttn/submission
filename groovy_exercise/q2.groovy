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
 
}
def emp1=new Employee([name:"shalika",gender:"female",empid:39,salary:15000])

println "${emp1.name}"
println "${emp1.gender}"
println  emp1.@empid
println "${emp1.salary}"
emp1.@company="To the New Digital"
println "${emp1.company}"



package employee.arraylist;

import java.util.Objects;

public class Employee {

    String empID, fullName;
    String email;
    double salary;
    String birthday;

    public Employee() {
        empID = "emp000";
        this.fullName = "No name";
        this.email = "Email@gmail.com";
        this.salary = 00;
        this.birthday = "0-0-0000";
    }

    public Employee(String empID, String fullName, String email, double salary, String birthday) {
        this.empID = empID;
        this.fullName = fullName;
        this.email = email;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean checkSalary() {
        return salary > 0;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.empID, other.empID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", fullName=" + fullName + ", email=" + email + ", salary=" + salary + ", birthday=" + birthday + '}';
    }

}

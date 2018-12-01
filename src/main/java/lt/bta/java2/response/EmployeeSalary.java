package lt.bta.java2.response;

import lt.bta.java2.model.Employee;

public class EmployeeSalary {

    Employee employee;

    int salary;

    public EmployeeSalary(int empNo, String firstName, String lastName, int salary) {
        this.employee = new Employee();
        this.employee.setEmpNo(empNo);
        this.employee.setFirstName(firstName);
        this.employee.setLastName(lastName);
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

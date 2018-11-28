package lt.bta.java2.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "salaries")
@IdClass(SalaryPK.class)
public class Salary {
    private int empNo;
    private int salary;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Employee employee;

    @Id
    @Column(name = "emp_no", insertable = false, updatable = false)
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Id
    @Column(name = "from_date", insertable = false, updatable = false)
    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "to_date")
    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary1 = (Salary) o;
        return empNo == salary1.empNo &&
                salary == salary1.salary &&
                Objects.equals(fromDate, salary1.fromDate) &&
                Objects.equals(toDate, salary1.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, salary, fromDate, toDate);
    }

    @ManyToOne
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

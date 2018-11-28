package lt.bta.java2.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dept_emp")
@IdClass(DeptEmpPK.class)
public class DeptEmp {

    private int empNo;
    private String deptNo;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Employee employee;
    private Department department;

    @Id
    @Column(name = "emp_no", insertable = false, updatable = false)
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Id
    @Column(name = "dept_no", insertable = false, updatable = false)
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Basic
    @Column(name = "from_date")
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
        DeptEmp deptEmp = (DeptEmp) o;
        return empNo == deptEmp.empNo &&
                Objects.equals(deptNo, deptEmp.deptNo) &&
                Objects.equals(fromDate, deptEmp.fromDate) &&
                Objects.equals(toDate, deptEmp.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo, fromDate, toDate);
    }

    @ManyToOne
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

package lt.bta.java2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {
    private int empNo;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;
    private Collection<DeptEmp> deptEmps;
    private Collection<DeptManager> deptManagers;
    private Collection<Salary> salaries;
    private Collection<Title> titles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Basic
    @Column(name = "birth_date")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "hire_date")
    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empNo == employee.empNo &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(hireDate, employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, birthDate, firstName, lastName, gender, hireDate);
    }

    @OneToMany(mappedBy = "employee")
    public Collection<DeptEmp> getDeptEmps() {
        return deptEmps;
    }

    public void setDeptEmps(Collection<DeptEmp> deptEmps) {
        this.deptEmps = deptEmps;
    }

    @OneToMany(mappedBy = "employee")
    public Collection<DeptManager> getDeptManagers() {
        return deptManagers;
    }

    public void setDeptManagers(Collection<DeptManager> deptManagers) {
        this.deptManagers = deptManagers;
    }

    @OneToMany(mappedBy = "employee")
    public Collection<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Collection<Salary> salaries) {
        this.salaries = salaries;
    }

    @OneToMany(mappedBy = "employee")
    public Collection<Title> getTitles() {
        return titles;
    }

    public void setTitles(Collection<Title> titles) {
        this.titles = titles;
    }
}

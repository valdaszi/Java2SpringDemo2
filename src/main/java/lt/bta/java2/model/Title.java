package lt.bta.java2.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "titles", schema = "employees", catalog = "")
@IdClass(TitlePK.class)
public class Title {
    private int empNo;
    private String title;
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

    @Id
    @Column(name = "title", insertable = false, updatable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        Title title1 = (Title) o;
        return empNo == title1.empNo &&
                Objects.equals(title, title1.title) &&
                Objects.equals(fromDate, title1.fromDate) &&
                Objects.equals(toDate, title1.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, title, fromDate, toDate);
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

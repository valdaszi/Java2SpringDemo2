package lt.bta.java2.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TitlePK implements Serializable {
    private int empNo;
    private String title;
    private LocalDate fromDate;

    @Column(name = "emp_no", insertable = false, updatable = false)
    @Id
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Column(name = "title", insertable = false, updatable = false)
    @Id
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "from_date", insertable = false, updatable = false)
    @Id
    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitlePK titlePK = (TitlePK) o;
        return empNo == titlePK.empNo &&
                Objects.equals(title, titlePK.title) &&
                Objects.equals(fromDate, titlePK.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, title, fromDate);
    }
}

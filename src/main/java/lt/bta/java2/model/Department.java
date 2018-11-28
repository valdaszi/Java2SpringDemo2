package lt.bta.java2.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class Department {
    private String deptNo;
    private String deptName;
    private Collection<DeptEmp> deptEmps;
    private Collection<DeptManager> deptManagers;

    @Id
    @Column(name = "dept_no")
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Basic
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(deptNo, that.deptNo) &&
                Objects.equals(deptName, that.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNo, deptName);
    }

    @OneToMany(mappedBy = "department")
    public Collection<DeptEmp> getDeptEmps() {
        return deptEmps;
    }

    public void setDeptEmps(Collection<DeptEmp> deptEmps) {
        this.deptEmps = deptEmps;
    }

    @OneToMany(mappedBy = "department")
    public Collection<DeptManager> getDeptManagers() {
        return deptManagers;
    }

    public void setDeptManagers(Collection<DeptManager> deptManagers) {
        this.deptManagers = deptManagers;
    }
}

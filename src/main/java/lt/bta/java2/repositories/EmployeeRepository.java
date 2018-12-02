package lt.bta.java2.repositories;

import lt.bta.java2.model.Employee;
import lt.bta.java2.response.EmployeeSalary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    List<Employee> findByHireDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hireDate);

    @Query("SELECT new lt.bta.java2.response.EmployeeSalary(e.empNo, e.firstName, e.lastName, s.salary)" +
            " FROM Employee e" +
            " JOIN Salary s ON s.empNo = e.empNo" +
            " WHERE s.fromDate <= :date AND :date <= s.toDate")
    List<EmployeeSalary> employeeSalaryForDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @Query("SELECT new lt.bta.java2.response.EmployeeSalary(e.empNo, e.firstName, e.lastName, s.salary)" +
            " FROM Employee e" +
            " JOIN Salary s ON s.empNo = e.empNo" +
            " WHERE s.fromDate <= :date AND :date <= s.toDate")
    Page<EmployeeSalary> employeeSalaryForDatePage(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                               Pageable pageable);

    List<Employee> fetchLikeLastName(@Param("lastName") String lastName);

}

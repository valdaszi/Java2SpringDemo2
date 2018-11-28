package lt.bta.java2.repositories;

import lt.bta.java2.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    List<Employee> findByHireDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hireDate);

}

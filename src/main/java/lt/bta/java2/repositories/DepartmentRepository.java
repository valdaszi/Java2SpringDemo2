package lt.bta.java2.repositories;

import lt.bta.java2.model.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, String> {
}

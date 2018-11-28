package lt.bta.java2.service;

import lt.bta.java2.model.Employee;
import lt.bta.java2.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee read(@PathVariable int id) {
        return employeeRepository.findById(id).orElseThrow(null);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee employee) {
        employee.setEmpNo(id);
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeRepository.findById(id).ifPresent(part -> employeeRepository.delete(part));
    }

    @GetMapping("/list")
    public Page<Employee> list(@RequestParam int page, @RequestParam int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/hire/{hireDate}")
    public ResponseEntity<List<Employee>> getBySku(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hireDate) {
        return ResponseEntity.ok(employeeRepository.findByHireDate(hireDate));
    }

}

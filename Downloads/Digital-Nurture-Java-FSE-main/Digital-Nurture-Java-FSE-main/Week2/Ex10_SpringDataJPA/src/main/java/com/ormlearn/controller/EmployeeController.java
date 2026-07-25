package com.ormlearn.controller;

import com.ormlearn.model.Department;
import com.ormlearn.model.Employee;
import com.ormlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // --- Department endpoints ---

    @PostMapping("/departments")
    public ResponseEntity<Department> addDepartment(@RequestBody Department dept) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addDepartment(dept));
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return employeeService.getAllDepartments();
    }

    // --- Employee endpoints ---

    // Exercise 4: CRUD
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(emp));
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, emp));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Exercise 5: Query methods
    @GetMapping("/employees/department/{deptName}")
    public List<Employee> getByDepartment(@PathVariable String deptName) {
        return employeeService.getEmployeesByDepartment(deptName);
    }

    @GetMapping("/employees/search/email")
    public List<Employee> getByEmailDomain(@RequestParam String domain) {
        return employeeService.getEmployeesByEmailDomain(domain);
    }

    // Exercise 6: Pagination & Sorting
    @GetMapping("/employees/paginated")
    public Page<Employee> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return employeeService.getEmployeesSortedAndPaginated(page, size, sortBy);
    }

    @GetMapping("/employees/department/{deptName}/paginated")
    public Page<Employee> getByDeptPaginated(
            @PathVariable String deptName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return employeeService.getEmployeesByDeptPaginated(deptName, page, size);
    }
}

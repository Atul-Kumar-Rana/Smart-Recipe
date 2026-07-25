package com.ormlearn.service;

import com.ormlearn.model.Department;
import com.ormlearn.model.Employee;
import com.ormlearn.repository.DepartmentRepository;
import com.ormlearn.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Exercise 4: Create employee
    @Transactional
    public Employee addEmployee(Employee employee) {
        LOGGER.debug("Adding employee: {}", employee);
        return employeeRepository.save(employee);
    }

    // Exercise 4: Get all employees
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Exercise 4: Get employee by ID
    @Transactional
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Exercise 4: Update employee
    @Transactional
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
        emp.setName(updatedEmployee.getName());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setDepartment(updatedEmployee.getDepartment());
        return employeeRepository.save(emp);
    }

    // Exercise 4: Delete employee
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        LOGGER.debug("Deleted employee with id: {}", id);
    }

    // Exercise 5: Custom query - find by department name
    @Transactional
    public List<Employee> getEmployeesByDepartment(String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    // Exercise 5: Custom @Query - find by email domain
    @Transactional
    public List<Employee> getEmployeesByEmailDomain(String domain) {
        return employeeRepository.findByEmailDomain(domain);
    }

    // Exercise 6: Paginated list of all employees
    @Transactional
    public Page<Employee> getEmployeesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }

    // Exercise 6: Paginated + sorted employees
    @Transactional
    public Page<Employee> getEmployeesSortedAndPaginated(int page, int size, String sortField) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortField).ascending());
        return employeeRepository.findAll(pageable);
    }

    // Exercise 6: Paginated employees by department
    @Transactional
    public Page<Employee> getEmployeesByDeptPaginated(String deptName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        return employeeRepository.findByDepartmentName(deptName, pageable);
    }

    // Exercise 3: Department CRUD
    @Transactional
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}

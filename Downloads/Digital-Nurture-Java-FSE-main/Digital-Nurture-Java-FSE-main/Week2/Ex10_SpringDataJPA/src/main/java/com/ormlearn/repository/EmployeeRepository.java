package com.ormlearn.repository;

import com.ormlearn.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Exercise 5: Derived query methods
    List<Employee> findByName(String name);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByDepartmentName(String departmentName);

    // Exercise 5: @Query annotation - JPQL
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain%")
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    // Exercise 5: Native SQL query
    @Query(value = "SELECT * FROM employee WHERE name = :name", nativeQuery = true)
    List<Employee> findByNameNative(@Param("name") String name);

    // Exercise 5: Named query (defined on Employee entity)
    List<Employee> findByDepartmentName_(@Param("deptName") String deptName);

    // Exercise 6: Pagination support
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
}

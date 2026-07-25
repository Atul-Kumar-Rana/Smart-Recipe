package com.ormlearn.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
@NamedQuery(
    name = "Employee.findByDepartmentName",
    query = "SELECT e FROM Employee e WHERE e.department.name = :deptName"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    // Many employees belong to one department
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    // Auditing fields (Exercise 7)
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    public Employee() {}

    public Employee(String name, String email, Department department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public LocalDateTime getLastModifiedDate() { return lastModifiedDate; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

package com.ormlearn;

import com.ormlearn.model.Country;
import com.ormlearn.model.Department;
import com.ormlearn.model.Employee;
import com.ormlearn.service.CountryService;
import com.ormlearn.service.EmployeeService;
import com.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing  // Exercise 7: enable auditing (@CreatedDate, @LastModifiedDate)
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService  = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);

        // Hands-on 1: Get all countries
        testGetAllCountries();

        // Hands-on 6: Find country by code
        testFindCountryByCode();

        // Hands-on 7: Add new country
        testAddCountry();

        // Hands-on 8: Update country
        testUpdateCountry();

        // Hands-on 9: Delete country
        testDeleteCountry();

        // Exercise 3 & 4: Departments and Employees
        testEmployeeOperations();
    }

    // Hands-on 1
    private static void testGetAllCountries() {
        LOGGER.info("=== testGetAllCountries Start ===");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries={}", countries.size());
        LOGGER.info("=== testGetAllCountries End ===");
    }

    // Hands-on 6
    private static void testFindCountryByCode() {
        LOGGER.info("=== testFindCountryByCode Start ===");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Found country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        LOGGER.info("=== testFindCountryByCode End ===");
    }

    // Hands-on 7
    private static void testAddCountry() {
        LOGGER.info("=== testAddCountry Start ===");
        Country newCountry = new Country("ZZ", "Test Country");
        countryService.addCountry(newCountry);
        try {
            Country fetched = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added and fetched: {}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("=== testAddCountry End ===");
    }

    // Hands-on 8
    private static void testUpdateCountry() {
        LOGGER.info("=== testUpdateCountry Start ===");
        try {
            countryService.updateCountry("ZZ", "Updated Test Country");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated country: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("=== testUpdateCountry End ===");
    }

    // Hands-on 9
    private static void testDeleteCountry() {
        LOGGER.info("=== testDeleteCountry Start ===");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Confirmed deleted - country not found: {}", e.getMessage());
        }
        LOGGER.info("=== testDeleteCountry End ===");
    }

    // Exercise 3 & 4: Employee + Department
    private static void testEmployeeOperations() {
        LOGGER.info("=== testEmployeeOperations Start ===");

        Department dept = employeeService.addDepartment(new Department("Engineering"));
        LOGGER.debug("Department created: {}", dept);

        Employee emp1 = employeeService.addEmployee(new Employee("Alice", "alice@company.com", dept));
        Employee emp2 = employeeService.addEmployee(new Employee("Bob", "bob@company.com", dept));
        LOGGER.debug("Employees added: {}, {}", emp1, emp2);

        List<Employee> all = employeeService.getAllEmployees();
        LOGGER.debug("All employees count: {}", all.size());

        List<Employee> byDept = employeeService.getEmployeesByDepartment("Engineering");
        LOGGER.debug("Employees in Engineering: {}", byDept.size());

        LOGGER.info("=== testEmployeeOperations End ===");
    }
}

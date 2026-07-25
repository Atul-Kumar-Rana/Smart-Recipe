public class Product {
    private int employeeNumber;
    private String employeeName;
    private String department;

    public Product(int employeeNumber, String employeeName, String department) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.department = department;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }
}

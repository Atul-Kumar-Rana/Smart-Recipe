public class SearchTest {
    public static void main(String[] args) {
        Product[] employees = {
                new Product(5001, "Alice Cooper", "Sales"),
                new Product(6002, "Robert Miller", "Operations"),
                new Product(7003, "Jessica Anderson", "IT"),
                new Product(8004, "Christopher Lee", "Logistics"),
                new Product(9005, "Patricia Martinez", "Administration")
        };
        System.out.println("========== SEQUENTIAL SEARCH RESULTS ==========");
        Product result1 = LinearSearch.linearSearch(employees, 7003);
        if (result1 != null) {
            System.out.println("✓ Employee Details -> Name: " + result1.getEmployeeName() + " | Working in: "
                    + result1.getDepartment());
        } else {
            System.out.println("✗ No matching employee records found.");
        }
        Product result2 = LinearSearch.linearSearch(employees, 5555);
        if (result2 != null) {
            System.out.println("✓ Employee Details -> Name: " + result2.getEmployeeName());
        } else {
            System.out.println("✗ Record ID 5555 does not exist in the system.");
        }
        System.out.println("\n========== OPTIMIZED SEARCH RESULTS ==========");
        Product result3 = BinarySearch.binarySearch(employees, 8004);
        if (result3 != null) {
            System.out.println("✓ Employee Details -> Name: " + result3.getEmployeeName() + " | Working in: "
                    + result3.getDepartment());
        } else {
            System.out.println("✗ No matching employee records found.");
        }
        Product result4 = BinarySearch.binarySearch(employees, 5555);
        if (result4 != null) {
            System.out.println("✓ Employee Details -> Name: " + result4.getEmployeeName());
        } else {
            System.out.println("✗ Record ID 5555 does not exist in the system.");
        }
    }
}

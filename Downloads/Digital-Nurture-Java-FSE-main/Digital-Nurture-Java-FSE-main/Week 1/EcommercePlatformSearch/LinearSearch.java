public class LinearSearch {
    public static Product linearSearch(Product[] employees, int targetNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeNumber() == targetNumber) {
                return employees[i];
            }
        }
        return null;
    }
}

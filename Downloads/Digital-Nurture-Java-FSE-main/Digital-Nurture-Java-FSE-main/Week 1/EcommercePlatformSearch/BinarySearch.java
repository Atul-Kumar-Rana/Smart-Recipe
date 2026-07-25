import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static Product binarySearch(Product[] employees, int targetNumber) {
        Arrays.sort(employees, Comparator.comparingInt(Product::getEmployeeNumber));
        int low = 0;
        int high = employees.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (employees[mid].getEmployeeNumber() == targetNumber) {
                return employees[mid];
            } else if (employees[mid].getEmployeeNumber() < targetNumber) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

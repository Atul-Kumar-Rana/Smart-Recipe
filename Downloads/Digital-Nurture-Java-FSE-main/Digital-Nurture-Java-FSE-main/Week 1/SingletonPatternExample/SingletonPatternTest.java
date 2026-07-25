public class SingletonPatternTest {
    public static void main(String[] args) {
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance();
        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance();
        dbConnection1.query("SELECT * FROM users WHERE id = 1");
        dbConnection2.query("SELECT * FROM products WHERE category = 'Electronics'");
        if (dbConnection1 == dbConnection2) {
            System.out.println("Both database connection instances are the same.");
        } else {
            System.out.println("Database connection instances are different.");
        }
    }
}

// File: DBConnection.java
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "your_password");
        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
            return null;
        }
    }
}

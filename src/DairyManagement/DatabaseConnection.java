package DairyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection conn;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animal_management", "root", "sandip123");
            //System.out.println("Mysql connection successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Mysql connection failed");
        }
    }

    // यह कनेक्शन को रिटर्न करेगा
    public Connection getConnection() {
        return conn;
    }
}

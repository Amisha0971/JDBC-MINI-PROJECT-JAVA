package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	private static final String URL = "jdbc:mysql://localhost:3306/menu_management";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
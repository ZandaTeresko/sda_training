package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sda?serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

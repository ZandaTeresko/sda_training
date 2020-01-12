package jdbc;

import java.sql.SQLException;
import java.sql.Statement;


public class InitDB {

    public static void createTable(){
        Statement stmt = null;
        try {
            stmt = DBUtil.getConnection().createStatement();
            stmt.executeUpdate("CREATE TABLE users (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(50) NOT NULL," +
                    "email VARCHAR(100) NOT NULL," +
                    "city VARCHAR(20)," +
                    "PRIMARY KEY (id)" +
                    ")");
            System.out.println("Table created! ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

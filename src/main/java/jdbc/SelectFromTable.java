package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectFromTable {


    public static void selectUserByName(String name) throws SQLException {

        Statement statement = DBUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, email, city FROM users" +
                " WHERE users.name = '" + name + "'");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name2 = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("id: " + id + " Name: " + name + "Email: " + email);
        }
    }

    public static void selectUserByNameSQLInj(String name) throws SQLException {
        //"1 OR 1=1"
        Statement statement = DBUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, email, city FROM users" +
                " WHERE name = " + name + "");

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name2 = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("id: " + id + " Name: " + name2 + "Email: " + email);
        }
    }
}

package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatements {

    private Connection connection = null;

    public PreparedStatements(){
        connection = DBUtil.getConnection();
    }

    public void getUserByName(String name){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT " +
                            "id, name, email, city " +
                            "FROM users " +
                            "WHERE name = ?");
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                System.out.println("id: " + id +
                        " name: " + username +
                        " email: " + email +
                        " city: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserEmail(String email, int id){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users SET email = ? WHERE id = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, id);
            int ret = preparedStatement.executeUpdate();
            System.out.println(ret == 1 ? "OK" : "ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteOperation(int id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            int ret = preparedStatement.executeUpdate();
            System.out.println(ret == 1 ? "OK" : "ERROR");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertOperation(String name, String email, String city){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT users(name, email, city) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, city);
            int ret = preparedStatement.executeUpdate();
            System.out.println(ret == 1 ? "OK" : "ERROR");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertOperation_AutocommitDisabled(String name, String email, String city){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT users(name, email, city) VALUES (?, ?, ?)");

            connection.setAutoCommit(false);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, city);

            int ret = preparedStatement.executeUpdate();

            if(name.equals("Daiga"))connection.rollback();
            else connection.commit();

            System.out.println(ret == 1 ? "OK" : "ERROR");
            //set back to auto
            connection.setAutoCommit(true);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public List<String> getBooksByUserId(int id){
        List<String> results = new ArrayList<String>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT name FROM books WHERE user = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(resultSet.getString("name"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return results;
    }

    public void addDateColumnToBooksTable(){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "ALTER TABLE books ADD COLUMN date DATE NOT NULL");
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void dropDateColumn(){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "ALTER TABLE books DROP COLUMN date");
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateBookDate(int id, Date date){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE books SET date = ? WHERE id = ?");
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, id);
            int ret = preparedStatement.executeUpdate();
            System.out.println(ret == 1 ? "OK" : "ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

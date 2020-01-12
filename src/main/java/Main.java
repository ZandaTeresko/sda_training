import hibernate.BookService;
import hibernate.UserService;
import hibernate.entities.Book;
import hibernate.entities.User;
import hibernate.utility.DBConfig;
import jdbc.PreparedStatements;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        //jdbc.InitDB.createTable();
        //jdbc.FillTable.fillUsers();
        //jdbc.SelectFromTable.selectUserByNameSQLInj("1 OR 1=1");

        //PreparedStatements preparedStatements = new PreparedStatements();
        //preparedStatements.updateUserEmail("edgars2@email.lv",2);
        //preparedStatements.deleteOperation(1);

        //Transactions
        /*
        for(int i = 0; i< 100000; i++){
            preparedStatements.insertOperation("name" + i, i + "@email.lv", "Riga");
        }
        */

        //preparedStatements.insertOperation_AutocommitDisabled("Evija", "evija@email.lv", "Liepaja");


        //new table - books
        //getUserBooks(userID)
        /*
        List<String> books = preparedStatements.getBooksByUserId(2);
        for(String book : books){
            System.out.println(book);
        }
        */

        //add new column
        //preparedStatements.addDateColumnToBooksTable();

        //delete column
        //preparedStatements.dropDateColumn();

        //update existing book date
        //use java.sql.Date
        //Date date = Date.valueOf("2008-10-22");
        //preparedStatements.updateBookDate(2, date);


        /* --------------------------------------------------------------------------------------------------- */

        /*
        HIBERNATE
         */

        //create a new user instance
        //User user = new User("Normunds", "normunds@email.lv", "Riga");
        UserService userService = new UserService();

        //CREATES A NEW USER
        //userService.createUser(user);
        //System.out.println("User " + user.getName() + " is created");

        //GETS USER FROM DB
        //User user2 = userService.getUser(2);
        //System.out.println("Id: " + user2.getId());
        //System.out.println("Name: " + user2.getName());

        //MODIFIES THE EXTRACTED USER
        //user2.setName("Alex");

        //UPDATES (SAVES) THE MODIFIED USER IN DATABASE
        //userService.updateUser(user2);
        //System.out.println("User "+ user2.getName()
        // + " is updated");

        //PRINTS ALL USERS
        /*
        List<User> users = userService.getUsers();
        for(User user : users){
            System.out.println(user.toString());
        }
        */

        //GET USER BY ID
        //User user = userService.getUser(1);
        //userService.deleteUser(user);


        //ASSOCIATIONS (ONE TO MANY - MANY TO ONE)
        BookService bookService = new BookService();
        User user = userService.getUser(2);

        //User user2 = new User("Viesturs", "viesturs@email.lv", "Riga");
        //bookService.createBook(user2, "gramata2");
        //System.out.println("Book created");

        List<Book> books = user.getBooks();
        //System.out.println(books.get(0).getName());

        //PRINT ALL BOOKS FOR THE SPECIFIED USER
        for(Book book : books){
            System.out.println(book.getName());
        }

        //CLEANUP / CLOSE CONNECTION
        DBConfig.closeConnection();

    }

}

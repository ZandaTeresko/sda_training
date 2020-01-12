import hibernate.BookService;
import hibernate.UserService;
import hibernate.entities.Book;
import hibernate.entities.User;
import hibernate.utility.DBConfig;
import jdbc.PreparedStatements;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;


public class MainHibernate {
    public static void main(String[] args) {
        User user = new User("Normunds", "normunds@email.lv", "Riga");
        UserService userService = new UserService();

        userService.createUser(user);
        System.out.println("User " + user.getName() + " is created");

        User user2 = new User("Antiņš", "antins@email.lv", "Riga");
        System.out.println("User " + user2.getName() + " is created");

        User user3 = userService.getUser(44);
        System.out.println("ID: " + user3.getId());
        System.out.println("Name: " + user3.getName());

        userService.deleteUser(user3);

        System.out.println("User " + user3.getName() + " " + user3.getId() + " is deleted" );

        userService.getUser(44);
        System.out.println("User " + user3.getName() + " still here");



    }
}

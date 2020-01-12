import hibernate.BookService;
import hibernate.NovadiService;
import hibernate.UserService;
import hibernate.entities.Book;
import hibernate.entities.Novadi;
import hibernate.entities.User;
import hibernate.utility.DBConfig;
import jdbc.PreparedStatements;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;

public class MainNovadi {
    public static void main(String[] args) {
        Novadi novadi = new Novadi(3, "Lielvārde");
        NovadiService novadiService = new NovadiService();

        novadiService.createNovadi(novadi);
        System.out.println("Novads " + novadi.toString());

    }

}

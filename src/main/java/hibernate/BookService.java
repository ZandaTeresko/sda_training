package hibernate;

import hibernate.entities.Book;
import hibernate.entities.User;
import hibernate.utility.DBConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    public void addBooksToUser(User user, List<Book> books){
        Session session = DBConfig
                .getSessionFactory()
                .openSession();

        user.setBooks(books);
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void addBookToUser(User user, Book book){
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        addBooksToUser(user, books);
    }

    public void createBook(User user, String name){
        Book book = new Book(user, name);

        Session session = DBConfig
                .getSessionFactory()
                .openSession();

        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
    }

}

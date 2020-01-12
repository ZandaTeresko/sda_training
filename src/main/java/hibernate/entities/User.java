package hibernate.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
//@NamedQueries( {
//    @NamedQuery(name = User.QUERY_USER_BY_NAME,
//            query = "SELECT user FROM User AS user.name = :name"),
//
//})
public class User {

//    public final static String QUERY_USER_BY_NAME = "getUserByName";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

    public User(){}

    public User(String name, String email, String city){
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", books=" + books +
                '}';
    }
}

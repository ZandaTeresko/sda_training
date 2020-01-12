package hibernate;

import hibernate.entities.User;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {

//    private Session session;

//    public UserService() {
//        session = DBConfig.getSessionFactory()
//                          .openSession();
//    }

//    public User getUserByName(String name) {
//        Query<User> query = session.createNamedQuery(User.QUERY_USER_BY_NAME, User.class);
//        query.setParameter("name", name);
//        query.getResultList().get(0);
//
//    }
//returns all users with given name
//    public User getUsersByName(String name) {
//        Query<User> query = session.
//                createNamedQuery(User.QUERY_USER_BY_NAME, User.class);
//        query.setParameter("name", name);
//        query.getResultList();
//        return null;
//    }

    public void createUser(User user){
        Transaction transaction = null;
        try{
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateUser(User user){
        Transaction transaction = null;
        try{
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void deleteUser(User user){
        Transaction transaction = null;
        try{
            Session session = DBConfig
                    .getSessionFactory()
                    .openSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public User getUser(int id){
        Transaction transaction = null;
        User user = null;
        try{
            Session session = DBConfig.getSessionFactory().openSession();
            //user = session.find(User.class, id);
            user = session.get(User.class, id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    public List<User> getUsers(){
        List<User> users = null;
        try{
            Session session = DBConfig.getSessionFactory().openSession();
            users = session.createQuery("from User", User.class).list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return users;
    }

}

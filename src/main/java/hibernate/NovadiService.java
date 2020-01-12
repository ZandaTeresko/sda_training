package hibernate;

import hibernate.entities.Novadi;
import hibernate.entities.User;
import hibernate.utility.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NovadiService {




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

        public void createNovadi(Novadi novadi){
            Transaction transaction = null;
            try{
                Session session = DBConfig.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                session.save(novadi);
                transaction.commit();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        public void updateNovadi(Novadi novadi){
            Transaction transaction = null;
            try{
                Session session = DBConfig.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                session.update(novadi);
                transaction.commit();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        public void deleteNovadi(Novadi novadi){
            Transaction transaction = null;
            try{
                Session session = DBConfig
                        .getSessionFactory()
                        .openSession();
                transaction = session.beginTransaction();
                session.delete(novadi);
                transaction.commit();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }



    }



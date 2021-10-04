package HibernateDao;

import DAO.user.User;
import Entity.UsersHB;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class UserDao {
    public static UsersHB getUserbyUsername(String username){
        UsersHB user = new UsersHB();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx =session.beginTransaction();

            //code here
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<UsersHB> cr = cb.createQuery(UsersHB.class);
            Root<UsersHB> root = cr.from(UsersHB.class);
            cr.select(root);
            cr.where(cb.equal(root.get("username"), username));
            Query<UsersHB> query = session.createQuery(cr);
            user = query.getSingleResult();

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return user;
    }

    public UsersHB getUserByFullName(String full_name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        UsersHB user;

        try {
            tx =session.beginTransaction();

            //code here
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<UsersHB> cr = cb.createQuery(UsersHB.class);
            Root<UsersHB> root = cr.from(UsersHB.class);
            cr.select(root);
            cr.where(cb.equal(root.get("fullName"), full_name));
            Query<UsersHB> query = session.createQuery(cr);
            user = query.getSingleResult();

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return user;
    }

    public List<UsersHB> getAllUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<UsersHB> userList;

        try {
            tx =session.beginTransaction();

            //code here
            userList = session.createQuery("from UsersHB").list();
            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return userList;
    }

    public void setUserStatus(int id, Byte b){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx =session.beginTransaction();
            UsersHB user = session.get(UsersHB.class, id);
            user.setIsActive(b);
            //code here

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public UsersHB getUserById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        UsersHB user;

        try {
            tx =session.beginTransaction();
            user = session.get(UsersHB.class, id);
            //code here

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return user;
    }

}

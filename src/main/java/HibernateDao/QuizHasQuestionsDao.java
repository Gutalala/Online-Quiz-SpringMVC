package HibernateDao;

import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QuizHasQuestionsDao {
    public static void setUserChoice(int choice){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx =session.beginTransaction();

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
}

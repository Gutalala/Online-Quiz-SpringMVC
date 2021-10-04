package HibernateDao;

import Entity.AnsweroptionsHB;
import Entity.QuestionsHB;
import Entity.UsersHB;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AnswerOptionsDao {
    public List<AnsweroptionsHB> getAnswersByQuestion(QuestionsHB question){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<AnsweroptionsHB> answerList = new ArrayList<>();

        try {
            tx =session.beginTransaction();

            //code here
            answerList = question.getAnsweroptionsHB();

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return answerList;
    }

    public AnsweroptionsHB getAnswerById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        AnsweroptionsHB selectedAnswer;

        try {
            tx =session.beginTransaction();

            //code here
            selectedAnswer = session.get(AnsweroptionsHB.class, id);

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return selectedAnswer;
    }

    public AnsweroptionsHB getCorrectAnswer(QuestionsHB question){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        AnsweroptionsHB correctAnswer = new AnsweroptionsHB();

        try {
            tx =session.beginTransaction();

            //code here
            for(AnsweroptionsHB options : question.getAnsweroptionsHB()){
                if (options.getIsCorrect() == 1){
                    correctAnswer = options;
                }
            }

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return correctAnswer;
    }

}

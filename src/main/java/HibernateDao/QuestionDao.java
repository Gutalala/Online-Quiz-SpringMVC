package HibernateDao;

import Entity.QuestionsHB;
import Entity.QuizHB;
import Entity.QuizHasQuestionsHB;
import Entity.UsersHB;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionDao {
    public List<QuestionsHB> getAllQuestion(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<QuestionsHB> questionsList;

        try {
            tx =session.beginTransaction();

            questionsList = session.createQuery("from QuestionsHB ").list();

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return questionsList;
    }

    public List<QuestionsHB> getQuestionByQuiz(QuizHB quiz){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<QuestionsHB> questionsList = new ArrayList<>();

        try {
            tx =session.beginTransaction();

            int count = 0;

            //code here
            List<QuizHasQuestionsHB> qhqList = quiz.getQuizHasQuestionsHB();

            for (QuizHasQuestionsHB quizHasQuestions : qhqList) {
                questionsList.add(count, quizHasQuestions.getQuestionsHB());
                count++;
            }

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return questionsList;
    }

    public QuestionsHB getQuestionbyId(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        QuestionsHB question;

        try {
            tx =session.beginTransaction();

            //code here
            question = session.get(QuestionsHB.class, id);

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return question;
    }

    public void setQuestionStatus(int id, Byte b){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx =session.beginTransaction();
            QuestionsHB questionsHB = session.get(QuestionsHB.class, id);
            questionsHB.setIsActive(b);
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

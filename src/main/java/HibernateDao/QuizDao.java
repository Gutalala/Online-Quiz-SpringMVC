package HibernateDao;

import Entity.QuizHB;
import Entity.UsersHB;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuizDao {
    public void addQuiz(String category, String start_time, String end_time, int score, int user_id) throws ParseException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        QuizHB quiz = new QuizHB();
        Timestamp startTime;
        Timestamp endTime;

        try {

            tx =session.beginTransaction();

            UsersHB usersHB = session.get(UsersHB.class, user_id);

            //code here
            quiz.setCategory(category);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
            Date parsedStartDate = (Date) sdf.parse(start_time);
            Date parsedEndDate = (Date) sdf.parse(end_time);
            startTime = new java.sql.Timestamp(parsedStartDate.getTime());
            endTime = new java.sql.Timestamp(parsedEndDate.getTime());
            quiz.setStartTime(startTime);
            quiz.setEndTime(endTime);
            quiz.setScore(score);
            quiz.setUsersHB(usersHB);

            session.save(quiz);

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public List<QuizHB> listQuizzes(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<QuizHB> quizzes;

        try {
            tx =session.beginTransaction();

            //code here
            quizzes = session.createQuery("From QuizHB").list();
            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return quizzes;
    }

    public List<QuizHB> getQuizByUser(UsersHB user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<QuizHB> quizList;

        try {
            tx =session.beginTransaction();

            //code here
            quizList = user.getQuizHB();

            tx.commit();

        } catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return quizList;
    }

}

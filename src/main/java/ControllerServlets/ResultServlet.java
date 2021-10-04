package ControllerServlets;

import DAO.quiz.Question;
import DAO.quiz.Quiz;
import Entity.AnsweroptionsHB;
import Entity.QuestionsHB;
import Entity.QuizHB;
import Entity.UsersHB;
import HibernateDao.AnswerOptionsDao;
import HibernateDao.QuestionDao;
import HibernateDao.QuizDao;
import HibernateDao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ResultServlet", value = "/resultdetails")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String full_name = request.getParameter("full_name");
//
//        UserDao userDao = new UserDao();
//        QuestionDao questionDao = new QuestionDao();
//        QuizDao quizDao = new QuizDao();
//
//        UsersHB user = userDao.getUserByFullName(full_name);
//        QuizHB quiz = quizDao.getQuizByUser(user);
//        List<QuestionsHB> questionList = questionDao.getQuestionByQuiz(quiz);
//        AnswerOptionsDao answerOptions = new AnswerOptionsDao();
//        request.setAttribute("questionList", questionList);
//        request.setAttribute("answerOptionsDao", answerOptions);
//
//        request.getRequestDispatcher("/jsp/resultdetails.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

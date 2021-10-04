package ControllerServlets;

import DAO.quiz.Question;
import DAO.quiz.Quiz;
import Entity.UsersHB;
import HibernateDao.QuizDao;
import HibernateDao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {
    private String selectedQuiz;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean finish = false;
        byte isPass;
        int numberOfQuestions = Quiz.numberOfQuestions;

        request.setAttribute("NOQ",numberOfQuestions);

        HttpSession session = request.getSession();

        try {
            if (session.getAttribute("currentQuiz") == null) {
                session = request.getSession(false);
                selectedQuiz = (String) request.getSession().getAttribute("category");
                Quiz newQuiz = new Quiz(selectedQuiz);
                newQuiz.loadQuestion();
                session.setAttribute("currentQuiz", newQuiz);
                session.setAttribute("quizName", selectedQuiz);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
                Date date = new Date();
                String start_time = dateFormat.format(date);
                session.setAttribute("start_time", start_time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Quiz quiz = (Quiz) request.getSession().getAttribute("currentQuiz");


        if (quiz.currentQuestion == 0) {
            Question q = quiz.questionList.get(quiz.currentQuestion);
            session.setAttribute("quest", q);
        }

        String action = request.getParameter("action");

        String radio = request.getParameter("answer");
        int selectedRadio;
        if ("1".equals(radio)) {
            selectedRadio = 1;
            quiz.selections.put(quiz.currentQuestion, selectedRadio);
        } else if ("2".equals(radio)) {
            selectedRadio = 2;
            quiz.selections.put(quiz.currentQuestion, selectedRadio);
        } else if ("3".equals(radio)) {
            selectedRadio = 3;
            quiz.selections.put(quiz.currentQuestion, selectedRadio);
        } else if ("4".equals(radio)) {
            selectedRadio = 4;
            quiz.selections.put(quiz.currentQuestion, selectedRadio);
        }

        if ("Next".equals(action)) {
            quiz.currentQuestion++;
//            System.out.println(quiz.currentQuestion);
            Question q = quiz.questionList.get(quiz.currentQuestion);
            session.setAttribute("quest", q);
        } else if ("Previous".equals(action)) {
            quiz.currentQuestion--;
            Question q = quiz.questionList.get(quiz.currentQuestion);
            session.setAttribute("quest", q);
        } else if ("Submit Quiz".equals(action)) {
            finish = true;
            int result = quiz.calculateResult(quiz);
            request.setAttribute("result", result);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
            Date date = new Date();
            String end_time = dateFormat.format(date);
            session.setAttribute("ended", end_time);
            QuizDao quizDao = new QuizDao();
            UsersHB user = UserDao.getUserbyUsername((String) session.getAttribute("username"));

            try {
                quizDao.addQuiz(selectedQuiz, (String) session.getAttribute("start_time"), end_time, result, user.getId());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            request.getSession().setAttribute("currentQuiz", null);
            request.getSession().setAttribute("quest", null);
            request.getRequestDispatcher("/jsp/quizresult.jsp").forward(request, response);
        }
        session.setAttribute("selectionMap", quiz.selections);
        session.setAttribute("selected", quiz.selections.get(quiz.currentQuestion));

        if (finish != true) {
            request.getRequestDispatcher("/jsp/quiz.jsp").forward(request, response);
        }

    }

}

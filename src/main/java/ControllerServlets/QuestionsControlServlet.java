package ControllerServlets;

import Entity.QuestionsHB;
import Entity.UsersHB;
import HibernateDao.AnswerOptionsDao;
import HibernateDao.QuestionDao;
import HibernateDao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestionsControlServlet", value = "/question_list")
public class QuestionsControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        AnswerOptionsDao answerOptionsDao = new AnswerOptionsDao();
        List<QuestionsHB> questionList = questionDao.getAllQuestion();
        request.setAttribute("questionList", questionList);
        request.setAttribute("answeroptions",answerOptionsDao);

        String role = (String) request.getSession(false).getAttribute("role");

        if (role.equals("admin")) {
            request.getRequestDispatcher("/jsp/question_list.jsp").forward(request, response);
        }
        else
            response.sendRedirect("/home_admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        System.out.println(request.getParameter("status"));
        int id = Integer.parseInt(request.getParameterValues("status")[0]);


        QuestionsHB question = questionDao.getQuestionbyId(id);
        if (question.getIsActive() == 0)
            questionDao.setQuestionStatus(id, (byte) 1);
        else if (question.getIsActive() == 1)
            questionDao.setQuestionStatus(id, (byte) 0);

        List<QuestionsHB> questionList = questionDao.getAllQuestion();
        request.setAttribute("questionList", questionList);
        request.getRequestDispatcher("/jsp/question_list.jsp").forward(request, response);
    }
}

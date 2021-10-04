package ControllerServlets;

import Entity.QuizHB;
import HibernateDao.QuizDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/load_quiz_list")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuizDao quizDao = new QuizDao();
        List<QuizHB> quizzes = quizDao.listQuizzes();

        String role = (String) request.getSession(false).getAttribute("role");

        if (role.equals("admin")){
            request.setAttribute("quizzes", quizzes);
            request.getRequestDispatcher("jsp/home_admin.jsp").forward(request, response);
        }
        else
            response.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

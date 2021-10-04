package ControllerServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = {"/home", "/login", "/register", "/takeQuiz", "/logout", "/contact", "/home_admin"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applicationContextPath = request.getContextPath();

        if (request.getRequestURI().equals(applicationContextPath + "/home")) {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/home.jsp");
            dispatcher.forward(request, response);
        }
        else if (request.getRequestURI().equals(applicationContextPath + "/")) {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/login.jsp");
            dispatcher.forward(request, response);
        } else if (request.getRequestURI().equals(
                applicationContextPath + "/login")) {
            if (request.getSession().getAttribute("username") != null){
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/home.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/login.jsp");
                dispatcher.forward(request, response);
            }
        } else if (request.getRequestURI().equals(
                applicationContextPath + "/register")) {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/register.jsp");
            dispatcher.forward(request, response);
        }
        else if (request.getRequestURI().equals(
                applicationContextPath + "/takeQuiz")) {
            request.getSession().setAttribute("currentQuiz", null);

            String quiz = request.getParameter("category");
            request.getSession().setAttribute("category", quiz);

            System.out.println(request.getSession().getAttribute("username"));
            if (request.getSession().getAttribute("username") == null) {
                request.getRequestDispatcher("/login").forward(request,
                        response);

            } else {
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/quiz");
                dispatcher.forward(request, response);
            }
        }
        else if (request.getRequestURI().equals(
                applicationContextPath + "/logout")) {
            request.getSession().invalidate();
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/login.jsp");
            dispatcher.forward(request, response);
        }
        else if (request.getRequestURI().equals(
                applicationContextPath + "/contact")) {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/contact.jsp");
            dispatcher.forward(request, response);
        }
//        else if (request.getRequestURI().equals(
//                applicationContextPath + "/resultdetails")) {
//            RequestDispatcher dispatcher = request
//                    .getRequestDispatcher("jsp/resultdetails.jsp");
//            dispatcher.forward(request, response);
//        }
        else if (request.getRequestURI().equals(
                applicationContextPath + "/home_admin")) {
            if (request.getSession().getAttribute("username") != null){
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/load_quiz_list");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}

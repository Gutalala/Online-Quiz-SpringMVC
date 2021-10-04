package ControllerServlets;

import Entity.UsersHB;
import HibernateDao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersControlServlet", value = "/user_list")
public class UsersControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<UsersHB> userList = userDao.getAllUsers();
        request.setAttribute("userList", userList);

        String role = (String) request.getSession(false).getAttribute("role");

        if (role.equals("admin")) {
            request.getRequestDispatcher("/jsp/user_list.jsp").forward(request, response);
        }
        else
            response.sendRedirect("/home_admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        System.out.println(request.getParameter("status"));
        int id = Integer.parseInt(request.getParameterValues("status")[0]);


        UsersHB user = userDao.getUserById(id);
        if (user.getIsActive() == 0)
            userDao.setUserStatus(id, (byte) 1);
        else if (user.getIsActive() == 1)
            userDao.setUserStatus(id, (byte) 0);

        List<UsersHB> userList = userDao.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/jsp/user_list.jsp").forward(request, response);
    }
}

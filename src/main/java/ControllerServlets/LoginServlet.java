package ControllerServlets;

import Utility.ConnectionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/checkLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String query = "Select isActive, full_name, role, count(*) > 0 as match_found from Users Where username= ? and password= ?";

        request.setAttribute("username", username);

        try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);


            ResultSet rs = preparedStatement.executeQuery();
            boolean loginSuccess = false;
            if( rs.next() ) {
                loginSuccess = rs.getBoolean( "match_found" );
            }
            String role = rs.getString("role");
            Byte isActive = rs.getByte("isActive");

            if (loginSuccess && isActive == 1) {
                // invalidate old session if it exists
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }

                // generate new session
                HttpSession newSession = request.getSession();

                // session setting, expires in 30 minutes
                newSession.setMaxInactiveInterval(15 * 60);

                // store username in session
                newSession.setAttribute("username", username);
                newSession.setAttribute("full_name", rs.getString("full_name"));
                newSession.setAttribute("role", role);

                if (role.equals("tester"))
                    response.sendRedirect("/home");
                else if (role.equals("admin"))
                    response.sendRedirect("/home_admin");

            } else {
                request.getRequestDispatcher("/jsp/login_failed.jsp").forward(request, response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}


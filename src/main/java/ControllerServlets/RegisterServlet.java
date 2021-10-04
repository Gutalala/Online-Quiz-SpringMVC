package ControllerServlets;

import Utility.ConnectionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/checkRegister")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String full_name=request.getParameter("full_name");
        boolean error = false;

        // Check if the username exists in the database
        boolean exists = ConnectionUtil.checkUsername(username);

        String query = "insert into users(username, password, full_name) values (?, ?, ?)";

        try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(query))
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, full_name);
            preparedStatement.executeUpdate();
            error = false;

        } catch(SQLException sqe)
        {
            System.out.println("Error : While Inserting record in database");
            error = true;
        }

        if (!error && !exists) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/checkLogin");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/registerFail.jsp");
            dispatcher.forward(request, response);
        }
    }
}


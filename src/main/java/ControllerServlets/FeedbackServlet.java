package ControllerServlets;

import Utility.ConnectionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "FeedbackServlet", value = "/feedback")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "insert into feedback(content, date, rating) values (? , ?, ?)";

        try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            request.setAttribute("submitted", 0);
            String content = request.getParameter("content");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
            Date date = new Date();
            String submit_time = dateFormat.format(date);
            int rating = Integer.parseInt(request.getParameter("rating"));

            preparedStatement.setString(1, content);
            preparedStatement.setString(2, submit_time);
            preparedStatement.setInt(3, rating);

            request.setAttribute("submitted", 1);

            request.getRequestDispatcher("/jsp/feedback.jsp").forward(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

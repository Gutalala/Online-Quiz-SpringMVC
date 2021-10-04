package Utility;

import java.sql.*;

public class ConnectionUtil {

    // JDBC configuration
    static final String DB_URL = "jdbc:mysql://localhost:3306/onlinequiz?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASSWORD = "cunmiu94";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * Checks if the username exists in the database
     *
     * @param username
     * @return exists of type boolean
     */

    public static boolean checkUsername(String username) {

        boolean exists = false;
        Connection con = ConnectionUtil.getConnection();

        try (Statement st = con.createStatement()) {
            String sql = "Select * from  users where username='" + username + "'";
            st.executeUpdate(sql);
            exists = true;
        } catch (Exception e) {
            exists = false;
        }

        if (exists) {
            System.out.println("Username already exists !");
        } else {
            System.out.println("Username is available.");
        }
        return exists;
    }

}
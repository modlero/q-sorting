package com.company;

import java.sql.*;

public class Database {

    private static final String url = "jdbc:mysql://saject.ru:3307/cs?useUnicode=yes&characterEncoding=UTF-8";
    private static final String user = "cs006";
    private static final String password = "12";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void connect () {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getQuestions() {
        try {
            String query = "SELECT question FROM q-test";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }


    public static void delete (int question_id) {
        try {
            String query = "DELETE FROM answers WHERE question_id = " + question_id;
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            query = "DELETE FROM questions WHERE id = " + question_id;
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect () {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package com.line;

import java.sql.*;
import java.util.Map;

public class UserDao {
    public void add() throws ClassNotFoundException, SQLException {
        Map<String, String> evn = System.getenv();
        String dbHost = evn.get("DB_HOST");
        String dbName = evn.get("DB_NAME");
        String dbPassword = evn.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbName,dbPassword);

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id, name, password) VALUES(?,?,?)"
        );

        ps.setString(1, "1");
        ps.setString(2, "soonmin");
        ps.setString(3,"1234");

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public void select(String input) throws ClassNotFoundException, SQLException {
        Map<String, String> evn = System.getenv();
        String dbHost = evn.get("DB_HOST");
        String dbName = evn.get("DB_NAME");
        String dbPassword = evn.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbName,dbPassword);

        PreparedStatement ps = conn.prepareStatement(
                "SELECT id, name, password FROM users where id =?"
        );

        ps.setString(1, input);

        ResultSet rs =ps.executeQuery();
        rs.next();

        User user = new User(rs.getString("id"), rs.getString("name"),rs.getString("password"));

        rs.close();
        ps.close();
        conn.close();

        System.out.printf("id : %s\nname : %s\npassword : %s\n",user.getId(),user.getName(),user.getPassword());
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();
        //userDao.add();
        userDao.select("1");

    }
}

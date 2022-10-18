package com.line;

import java.sql.*;
import java.util.Map;

public abstract class UserDaoAbstract {

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public void add(User user) throws ClassNotFoundException, SQLException {
//        Map<String, String> evn = System.getenv();
//        String dbHost = evn.get("DB_HOST");
//        String dbName = evn.get("DB_NAME");
//        String dbPassword = evn.get("DB_PASSWORD");
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(dbHost,dbName,dbPassword);

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id, name, password) VALUES(?,?,?)"
        );

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User select(String input) throws ClassNotFoundException, SQLException {
//        Map<String, String> evn = System.getenv();
//        String dbHost = evn.get("DB_HOST");
//        String dbName = evn.get("DB_NAME");
//        String dbPassword = evn.get("DB_PASSWORD");
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(dbHost,dbName,dbPassword);

        Connection conn = getConnection();

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

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        UserDaoAbstract userDao = new UserDaoAbstract();
//        //userDao.add(new User("2","minsoon","4321"));
//        User selectedUser = userDao.select("2");
//        System.out.println(selectedUser.getName());

    }
}

package com.line;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AwsConnectionMaker implements ConnectionMaker{
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> evn = System.getenv();
        String dbHost = evn.get("DB_HOST");
        String dbName = evn.get("DB_NAME");
        String dbPassword = evn.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbName,dbPassword);

        return conn;
    }

}

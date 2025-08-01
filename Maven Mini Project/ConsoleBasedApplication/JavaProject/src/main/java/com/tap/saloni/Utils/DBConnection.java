package com.tap.saloni.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String URL = "jdbc:mysql://localhost:3306/TFLMentoringDB";
    private String USERNAME = "root";
    private String PASSWORD = "root@#$5";
    private Connection conn = null;

   public Connection getConnectionDb() throws Exception
    {
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }
    
}

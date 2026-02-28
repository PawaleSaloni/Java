package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/companydb";
        String user = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to the database");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }   
}

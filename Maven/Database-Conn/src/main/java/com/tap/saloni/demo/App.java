package com.tap.saloni.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:mysql://localhost:3306/assessmentdb";
        String USERNAME = "root";
        String PASSWORD = "root@#$5";
        Connection connection = null;

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connection established successfully...");

        System.out.println();
        System.out.println();
        System.out.println();

        Statement smt = connection.createStatement();
        ResultSet rs = smt.executeQuery("select * from questionbank");

        System.out.println("\n***********************");
        while (rs.next()) {
            System.out.println(" { " + "id: " + rs.getInt(1) + " , SubjectId: " + rs.getString(2) 
            + " , Question: "+ rs.getString(3) 
            + " , Option A: " + rs.getString(4) 
            + " , Option B: " + rs.getString(5)
            + " , Option C: " + rs.getString(6) 
            + " , Option D: " + rs.getString(7)
            + " , Answer Key: " + rs.getString(8)
            + " , Evaluation Criteria: " + rs.getInt(9)+" } ");
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Questions display successfully....");
        connection.close();
    }
}

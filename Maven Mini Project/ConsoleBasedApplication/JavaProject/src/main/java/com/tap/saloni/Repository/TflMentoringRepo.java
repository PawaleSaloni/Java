package com.tap.saloni.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.tap.saloni.Repository.Interface.ITflMentoringRepo;
import com.tap.saloni.Utils.DBConnection;


public class TflMentoringRepo implements ITflMentoringRepo {
    public void getAll() {
        try {
            DBConnection dbconn = new DBConnection();
            Connection conn = dbconn.getConnectionDb();
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("select * from topics");
            ResultSetMetaData rmd = rs.getMetaData();
            int columncount = rmd.getColumnCount();
            System.out.println("Topics");
            for (int i = 1; i <= columncount; i++) {
                System.out.print(rmd.getColumnName(i) + "\t");
            }
            System.out.println("\n*");
            while (rs.next()) {
                System.out.println("id: "+rs.getInt(1) + ", Title: " + rs.getString(2) + ", URL: " + rs.getString(3)+",Repository id: "+rs.getInt(4));
                System.out.println();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean insert(int id, String title, String Url, int repoid) {
        boolean status = false;
        try {
            DBConnection dbconn = new DBConnection();
            Connection conn = dbconn.getConnectionDb();
            PreparedStatement pstmt = conn.prepareStatement("insert into topics values(?,?,?,?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, Url);
            pstmt.setInt(4, repoid);
            pstmt.executeUpdate();
            status = true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }   
}
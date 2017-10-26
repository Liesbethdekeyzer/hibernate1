package com.example.hibernate;


import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        String passfalse = "hbdfdfdstudent";

        try {
            System.out.println("Connecting to databse " + jdbcUrl);
            Connection myCOnn = DriverManager.getConnection(jdbcUrl, user, passfalse   );
            System.out.println("Connecting successfull!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

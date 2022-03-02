package com.example.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {


    public static final String DB_NAME = "Emp.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Data Base\\" + DB_NAME;


    private static Connection connection = null;

    static{
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (Exception e) {
            System.out.println(" Rami Zain");
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }


}



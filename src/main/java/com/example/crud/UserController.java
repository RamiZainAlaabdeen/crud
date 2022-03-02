package com.example.crud;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;


public class UserController implements Initializable {


    @FXML
    private  TextField EmployeeId;

    @FXML
    private  TextField EmployeeName;

    @FXML
    private TextField Emaill;

    @FXML
    private  TextField Salaryy;

    @FXML
    private  TextField Bounuss;

    @FXML
    private Button Insertt;


    @FXML
    public void onButtonClicked(ActionEvent e) throws Exception{

        if(e.getSource().equals(Insertt)) {

            insertRecord();

            EmployeeId.clear();
            EmployeeName.clear();
            Emaill.clear();
            Salaryy.clear();
            Bounuss.clear();

            System.out.println("Employee Added");

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }


//    public Connection getConn(){
//
//        final String DB_NAME = "Emp.db";
//        final String CONNECTION_STRING = "jdbc:sqlite:C:\\Data Base\\" + DB_NAME;
//        Connection connection= null;
//        try {
//            connection = DriverManager.getConnection(CONNECTION_STRING);
//
//        } catch (Exception e) {
//            System.out.println(" Rami Zain");
//            e.printStackTrace();
//            //  return null;
//        }
//
//        return connection;
//    }


    private void insertRecord(){

        String id= EmployeeId.getText();
        String name= EmployeeName.getText();
        String email= Emaill.getText();
        String salary= Salaryy.getText();
        String bounus= Bounuss.getText();

        String query= " insert into employee_table values (" + id + ",'" +
                name + "','" + email + "'," + salary + "," + bounus + ") ";
        executeQuery(query);


    }


    private void executeQuery(String query){

        Connection conn= DBUtil.getConnection();
        Statement st;

        try {
            st= conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.example.crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private  TextField Employee_Id;


    @FXML
    private  TextField Employee_Name;

    @FXML
    private  TextField Email;

    @FXML
    private  TextField Salary;

    @FXML
    private  TextField Bounus;

    @FXML
    private Button Insert;

    @FXML
    private Button Ubdate;

    @FXML
    private Button Delete;



    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, Integer> idCol;
    @FXML
    private TableColumn<Employee, String> nameCol;
    @FXML
    private TableColumn<Employee, String> emailCol;
    @FXML
    private TableColumn<Employee, Double> salaryCol;
    @FXML
    private TableColumn<Employee, BigDecimal> bounusCol;




    @FXML
    public void onButtonClicked(ActionEvent e) throws Exception{
        if(e.getSource().equals(Insert)) {


            insertRecord();

            Employee_Id.clear();
            Employee_Name.clear();
            Email.clear();
            Salary.clear();
            Bounus.clear();


        }else if (e.getSource().equals(Ubdate)){

              updateRecord();
            Employee_Id.clear();
            Employee_Name.clear();
            Email.clear();
            Salary.clear();
            Bounus.clear();

        }else if (e.getSource().equals(Delete)){


            deleteRecord();


        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showEmp();
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
//          //  return null;
//        }
//
//        return connection;
//    }

    public ObservableList<Employee> getEmpList(){

        ObservableList<Employee> empList= FXCollections.observableArrayList();
        Connection conn= DBUtil.getConnection();
        String query= "SELECT * FROM employee_table";
        Statement st=null;
        ResultSet rs= null;

        try {
            st= conn.createStatement();
            rs= st.executeQuery(query);
            Employee employee;
            while (rs.next()){

                employee= new Employee(rs.getInt("employee_id"),rs.getString("employee_name")
                        ,rs.getString("email"),rs.getDouble("salary"),
                        rs.getBigDecimal("bonus"));

                empList.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return empList;

    }

    public void showEmp(){

        ObservableList<Employee> list= getEmpList();

        idCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employee_id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employee_name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));
        bounusCol.setCellValueFactory(new PropertyValueFactory<Employee, BigDecimal>("bonus"));

        tableView.setItems(list);


    }


    private void insertRecord(){

        String id= Employee_Id.getText();
        String name= Employee_Name.getText();
        String email= Email.getText();
        String salary= Salary.getText();
        String bounus= Bounus.getText();

        String query= " insert into employee_table values (" + id + ",'" +
                name + "','" + email + "'," + salary + "," + bounus + ") ";
        executeQuery(query);
        showEmp();



    }

    private void updateRecord(){

        String id= Employee_Id.getText();
        String name= Employee_Name.getText();
        String email= Email.getText();
        String salary= Salary.getText();
        String bounus= Bounus.getText();


        String query= " update employee_table Set employee_name = '" +
                name + "', email = '" + email + "' , salary = " + salary + " , bonus = " + bounus + " WHERE employee_id = " + id + "" ;

        executeQuery(query);
        showEmp();

    }

    private void deleteRecord(){

        String id= Employee_Id.getText();
        String name= Employee_Name.getText();
        String email= Email.getText();
        String salary= Salary.getText();
        String bounus= Bounus.getText();


        String query= " DELETE FROM employee_table WHERE employee_id = " + id + "" ;

        executeQuery(query);
        showEmp();

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

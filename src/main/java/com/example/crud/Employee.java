package com.example.crud;

import java.math.BigDecimal;


public class Employee {

    private int employee_id;
    private String employee_name;
    private String email;
    private Double salary;
    private BigDecimal bonus;


    public Employee(int employee_id, String employee_name, String email, Double salary, BigDecimal bonus) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.email = email;
        this.salary = salary;
        this.bonus = bonus;
    }



    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }




    @Override
    public String toString() {
        return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", email=" + email
                + ", salary=" + salary  + ", bonus=" + bonus + "]";
    }
}


package com.example.electricity_bill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Con_db {
    static java.sql.Connection con;
    public java.sql.Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eledb", "root", "12345");
        }
        catch (Exception e){

        }
        return con;
    }
}

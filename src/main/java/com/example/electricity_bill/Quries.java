package com.example.electricity_bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quries {

    public String register(String name, String address, String city, String state, String email, String phone) throws SQLException, ClassNotFoundException {
        System.out.println(name);

        Connection con=new Con_db().connect();
        String q="insert into c_data (name,address,city,State,email,mob) values (?,?,?,?,?,?)";
        String q1="select meterno from c_data where mob = ?";
        PreparedStatement pstmt=con.prepareStatement(q);
        PreparedStatement pstmt1=con.prepareStatement(q1);
        pstmt.setString(1,name);
        pstmt.setString(2,address);
        pstmt.setString(3,city);
        pstmt.setString(4,state);
        pstmt.setString(5,email);
        pstmt.setString(6,phone);
        pstmt1.setString(1,phone);
        System.out.println(pstmt);
        System.out.println(pstmt1);
        int i=pstmt.executeUpdate();
        if(i>0){
            ResultSet rs=pstmt1.executeQuery();
            String meterno="";
            while(rs.next()){
            meterno=rs.getString(1);}
            con.close();
            return "You are registered successfully\n your meter number is: "+meterno;}
        else{
            con.close();
            return "Something went to Wrong";}
    }
}

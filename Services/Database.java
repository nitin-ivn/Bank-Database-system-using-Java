package services;


import Model.RegisterDetails;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    final String url = "jdbc:mysql://127.0.0.1:3306/Bank";
    final String username = "root";
    final String password = "database";

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Long> getAccountNumbers(){
        ArrayList<Long> accountnum = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "SELECT Account_Number FROM User_Details";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                accountnum.add(rs.getLong("Account_Number"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return accountnum;
    }

    public void InsertRegisterDetails(RegisterDetails registerDetails){

    }
}

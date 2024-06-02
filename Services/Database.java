package services;


import Model.RegisterDetails;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    final String url = "jdbc:mysql://127.0.0.1:3306/Bank";
    final String username = "root";
    final String password = "database";
    Connection connection;

    public Database(){
        try {
            connection = DriverManager.getConnection(url,username,password);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Long> getAccountNumbers(){
        ArrayList<Long> accountnum = new ArrayList<>();
        try {

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

    public boolean getIfRegistered(long Accountnum){
        boolean reg = false;
        try {
            String query = "SELECT Registered FROM User_Details WHERE Account_Number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,Accountnum);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                reg = rs.getBoolean("Registered");
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return reg;
    }

    public void InsertRegisterDetails(RegisterDetails registerDetails){
            try{
                String query = "UPDATE User_Details SET User_FirstName = ?, USER_LastName = ?,User_PhoneNo = ?,User_email = ?,User_Balance = 1000,User_DOB = ?,Registered = 1 WHERE Account_Number = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,registerDetails.FirstName);
                statement.setString(2,registerDetails.LastName);
                statement.setLong(3,registerDetails.PhoneNumber);
                statement.setString(4,registerDetails.Email);

                java.sql.Date sqldate = new java.sql.Date(registerDetails.DOB.getTime());
                statement.setDate(5,sqldate);

                statement.setLong(6,registerDetails.AccountNumber);
                statement.executeQuery();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
    }

    public boolean ValidateLoginPassword(String password,long Accountnum){
        boolean validpassword = false;
        try {
            String query = "SELECT User_Password FROM User_Details WHERE Account_Number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,Accountnum);
            ResultSet rs = statement.executeQuery();
            String pass = "";
            if(rs.next()) {
                pass = rs.getString("User_Password");
            }
            validpassword = password.equals(pass);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return validpassword;
    }
}

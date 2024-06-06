package services;


import Model.Address;
import Model.RegisterDetails;
import Model.UserDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Database {
    static String Url = "jdbc:mysql://127.0.0.1:3306/Bank";
    static String Username = "root";
    static String Password = "database";
    final String url = "jdbc:mysql://127.0.0.1:3306/Bank";
    final String username = "root";
    final String password = "database";
    public static UserDetails userDetails = new UserDetails();
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
                String query = "UPDATE User_Details SET User_FirstName = ?, USER_LastName = ?,User_PhoneNo = ?,User_email = ?,User_Password = ?,User_Balance = 1000,User_DOB = ?,Registered = 1 WHERE Account_Number = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,registerDetails.FirstName);
                statement.setString(2,registerDetails.LastName);
                statement.setLong(3,registerDetails.PhoneNumber);
                statement.setString(4,registerDetails.Email);
                statement.setString(5,registerDetails.Password);

                java.sql.Date sqldate = new java.sql.Date(registerDetails.DOB.getTime());
                statement.setDate(6,sqldate);

                statement.setLong(7,registerDetails.AccountNumber);
                int rowsaffected = statement.executeUpdate();

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

    public static UserDetails GetUserDetails(){
        return userDetails;
    }

    public static UserDetails setUserDetails(long Accountnum){
        try {
            Connection connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "SELECT * FROM User_Details WHERE Account_Number = ?";
            PreparedStatement statement = connection1.prepareStatement(query);
            statement.setLong(1,Accountnum);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                userDetails.FirstName = rs.getString("User_FirstName");
                userDetails.LastName = rs.getString("User_LastName");
                userDetails.PhoneNo = rs.getLong("User_PhoneNo");
                userDetails.Email = rs.getString("User_email");
                userDetails.DOB = rs.getDate("User_DOB");
                userDetails.Balance = rs.getInt("User_Balance");
                userDetails.AccountNumber = Accountnum;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return userDetails;
    }

    public void InsertAddressDetails(Address address) {
        try {
            String query = "UPDATE Address SET House_Number=?,Colony=?,City=?,State=?,Pincode=?,Country = 'India' WHERE Account_Number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,address.HouseNo);
            statement.setString(2,address.Colony);
            statement.setString(3,address.City);
            statement.setString(4,address.State);
            statement.setInt(5,address.Pincode);
            statement.setLong(6,userDetails.AccountNumber);
            int n = statement.executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void SetUserPin(int ran){
        try {
            Connection connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "UPDATE User_Details SET PIN = ? WHERE Account_Number = ?";
            PreparedStatement statement = connection1.prepareStatement(query);
            statement.setInt(1,ran);
            statement.setLong(2,userDetails.AccountNumber);
            int n =  statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void setpin(){
        try {
            Connection connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "SELECT (PIN) FROM User_Details WHERE Account_Number = ?";
            PreparedStatement statement = connection1.prepareStatement(query);
            statement.setLong(1,userDetails.AccountNumber);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                userDetails.Pin = resultSet.getInt("PIN");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

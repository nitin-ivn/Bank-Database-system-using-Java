package services;


import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    static final String Url = "jdbc:mysql://127.0.0.1:3306/Bank";
    static final String Username = "root";
    static final String Password = "database";
    final String url = "jdbc:mysql://127.0.0.1:3306/Bank";
    final String username = "root";
    final String password = "database";
    public static UserDetails userDetails = new UserDetails();
    Connection connection;

    public Database() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Long> getAccountNumbers() {
        ArrayList<Long> accountnum = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT Account_Number FROM User_Details";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                accountnum.add(rs.getLong("Account_Number"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return accountnum;
    }

    public boolean getIfRegistered(long Accountnum) {
        boolean reg = false;
        try {
            String query = "SELECT Registered FROM User_Details WHERE Account_Number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, Accountnum);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                reg = rs.getBoolean("Registered");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reg;
    }

    public void InsertRegisterDetails(RegisterDetails registerDetails) {
        try {
            String query = "UPDATE User_Details SET User_FirstName = ?, USER_LastName = ?,User_PhoneNo = ?,User_email = ?,User_Password = ?,User_Balance = 1000,User_DOB = ?,Registered = 1 WHERE Account_Number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, registerDetails.FirstName);
            statement.setString(2, registerDetails.LastName);
            statement.setLong(3, registerDetails.PhoneNumber);
            statement.setString(4, registerDetails.Email);
            statement.setString(5, registerDetails.Password);

            java.sql.Date sqldate = new java.sql.Date(registerDetails.DOB.getTime());
            statement.setDate(6, sqldate);

            statement.setLong(7, registerDetails.AccountNumber);
            int rowsaffected = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean ValidateLoginPassword(String password, long Accountnum) {
        boolean validpassword = false;
        try {
            String query = "SELECT User_Password FROM User_Details WHERE Account_Number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, Accountnum);
            ResultSet rs = statement.executeQuery();
            String pass = "";
            if (rs.next()) {
                pass = rs.getString("User_Password");
            }
            validpassword = password.equals(pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validpassword;
    }

    public static UserDetails GetUserDetails() {
        return userDetails;
    }

    public static UserDetails setUserDetails(long Accountnum) {
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "SELECT * FROM User_Details WHERE Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setLong(1, Accountnum);
            rs = statement.executeQuery();
            while (rs.next()) {
                userDetails.FirstName = rs.getString("User_FirstName");
                userDetails.LastName = rs.getString("User_LastName");
                userDetails.PhoneNo = rs.getLong("User_PhoneNo");
                userDetails.Email = rs.getString("User_email");
                userDetails.DOB = rs.getDate("User_DOB");
                userDetails.Balance = rs.getInt("User_Balance");
                userDetails.AccountNumber = Accountnum;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return userDetails;
    }

    public void InsertAddressDetails(Address address) {
        try {
            String query = "UPDATE Address SET House_Number=?,Colony=?,City=?,State=?,Pincode=?,Country = 'India' WHERE Account_Number = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, address.HouseNo);
            statement.setString(2, address.Colony);
            statement.setString(3, address.City);
            statement.setString(4, address.State);
            statement.setInt(5, address.Pincode);
            statement.setLong(6, userDetails.AccountNumber);
            int n = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void SetUserPin(int ran) {
        Connection connection1 = null;
        PreparedStatement statement = null;
        try {
            connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "UPDATE User_Details SET PIN = ? WHERE Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setInt(1, ran);
            statement.setLong(2, userDetails.AccountNumber);
            int n = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void setpin() {
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "SELECT (PIN) FROM User_Details WHERE Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setLong(1, userDetails.AccountNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userDetails.Pin = resultSet.getInt("PIN");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void UpdateBalance (int balance,Long AccountNumber){
        Connection connection1 = null;
        PreparedStatement statement = null;
        try {
            connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "UPDATE User_Details SET User_Balance = ? WHERE Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setInt(1,balance);
            statement.setLong(2,AccountNumber);
            int n = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void setBalance() {
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "SELECT (User_Balance) FROM User_Details WHERE Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setLong(1, userDetails.AccountNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userDetails.Balance = resultSet.getInt("User_Balance");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static int getReceiverBalance(Long AccountNum) {
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int bal = 0;
        try {
            connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "SELECT (User_Balance) FROM User_Details WHERE Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setLong(1, AccountNum);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bal = resultSet.getInt("User_Balance");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return bal;
    }

    public static void insertTransactions(Transactions transactions){
        Connection connection1 = null;
        PreparedStatement statement = null;
        try{
            connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "INSERT INTO transactions_table (Senders_AccountNo,Recievers_AccountNo,date,time,amount,TransactionPerformed) VALUES(?,?,?,?,?,?)";
            statement = connection1.prepareStatement(query);
            statement.setLong(1,transactions.senders_AccountNo);
            statement.setLong(2,transactions.receivers_AccountNo);
            statement.setDate(3,transactions.date);
            statement.setTime(4,transactions.time);
            statement.setInt(5,transactions.amount);
            statement.setString(6,transactions.transactionperformed);
            int n = statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Transactions> getTransactionsByAccountNumber(long accountNumber) {
        Connection connection1 = null;
        PreparedStatement statement = null;
        List<Transactions> transactions = new ArrayList<>();
        try {
            connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "SELECT * FROM transactions_table WHERE Senders_AccountNo = ? OR Recievers_AccountNo = ?";
            statement = connection1.prepareStatement(query);
            statement.setLong(1, accountNumber);
            statement.setLong(2, accountNumber);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Transactions transaction = new Transactions();
                transaction.senders_AccountNo = rs.getLong("Senders_AccountNo");
                transaction.receivers_AccountNo = rs.getLong("Recievers_AccountNo");
                transaction.date = rs.getDate("date");
                transaction.time = rs.getTime("time");
                transaction.amount = rs.getInt("amount");
                transaction.transactionperformed = rs.getString("TransactionPerformed");
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return transactions;
    }

    public static void InsertLoanDetails(LoanDetails loanDetails){
        Connection connection1 = null;
        PreparedStatement statement = null;
        try {
            connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "INSERT INTO Loan_Details(Account_Number,TypeOfLoan,Amount,DurationInYears,MonthsRemaining,IntrestRate,EMIperMonth,LoanActive) VALUES (?,?,?,?,?,?,?,?)";
            statement = connection1.prepareStatement(query);
            statement.setLong(1,userDetails.AccountNumber);
            statement.setString(2,loanDetails.TypeofLoan);
            statement.setInt(3,loanDetails.loanAmount);
            statement.setInt(4,loanDetails.DurationInYears);
            statement.setInt(5,loanDetails.NumofMonthsRemaining);
            statement.setInt(6,loanDetails.IntrestRate);
            statement.setDouble(7,loanDetails.Emi);
            statement.setBoolean(8,loanDetails.loanActive);
            int rs = statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<LoanDetails> getLoanDetails(String TypeofLoan){
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<LoanDetails> loanDetails = new ArrayList<>();
        try {
            connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "SELECT * FROM Loan_Details WHERE TypeOfLoan = ? AND Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setString(1,TypeofLoan);
            statement.setLong(2,userDetails.AccountNumber);
            rs = statement.executeQuery();
            while(rs.next()){
                LoanDetails loanDetails1 = new LoanDetails();
                loanDetails1.loanID = rs.getInt("Loan_ID");
                loanDetails1.TypeofLoan = rs.getString("TypeOfLoan");
                loanDetails1.loanAmount = rs.getInt("Amount");
                loanDetails1.DurationInYears = rs.getInt("DurationInYears");
                loanDetails1.NumofMonthsRemaining = rs.getInt("MonthsRemaining");
                loanDetails1.IntrestRate = rs.getInt("IntrestRate");
                loanDetails1.Emi = rs.getDouble("EMIperMonth");
                loanDetails1.loanActive = rs.getBoolean("LoanActive");
                loanDetails1.AccountNumber = userDetails.AccountNumber;
                loanDetails.add(loanDetails1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return loanDetails;
    }

    public static boolean ValidLoanID(int loanID){
        ArrayList<Integer> loanid = new ArrayList<>();
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "SELECT Loan_ID FROM Loan_Details WHERE Account_Number = ?";
            statement = connection1.prepareStatement(query);
            statement.setLong(1,userDetails.AccountNumber);
            rs = statement.executeQuery();
            while (rs.next()){
                loanid.add(rs.getInt("Loan_ID"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return loanid.contains(loanID);
    }

    public static LoanDetails getLoanDetailsForPayment(int loanID){
        LoanDetails loanDetails = new LoanDetails();
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection1 = DriverManager.getConnection(Url,Username,Password);
            String query = "SELECT * FROM Loan_Details WHERE Loan_ID = ?";
            statement = connection1.prepareStatement(query);
            statement.setInt(1,loanID);
            rs = statement.executeQuery();
            while(rs.next()){
                loanDetails.loanID = loanID;
                loanDetails.AccountNumber = userDetails.AccountNumber;
                loanDetails.TypeofLoan = rs.getString("TypeOfLoan");
                loanDetails.loanAmount = rs.getInt("Amount");
                loanDetails.DurationInYears = rs.getInt("DurationInYears");
                loanDetails.NumofMonthsRemaining = rs.getInt("MonthsRemaining");
                loanDetails.Emi = rs.getDouble("EMIperMonth");
                loanDetails.loanActive = rs.getBoolean("LoanActive");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return loanDetails;
    }

    public static void UpdateLoanDetails(int numOfMonthsRemaining,boolean LoanActive,int Loan_ID){
        Connection connection1 = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection1 = DriverManager.getConnection(Url, Username, Password);
            String query = "UPDATE Loan_Details SET MonthsRemaining = ?,LoanActive = ? WHERE Loan_ID = ?";
            System.out.println(numOfMonthsRemaining);
            statement = connection1.prepareStatement(query);
            statement.setInt(1,numOfMonthsRemaining);
            statement.setBoolean(2,LoanActive);
            statement.setInt(3,Loan_ID);
            int n = statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }  finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

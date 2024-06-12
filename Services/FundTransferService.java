package services;

import Model.Transactions;
import Model.UserDetails;
import Views.Componenets.FundTransferPanel;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FundTransferService {
    UserDetails userDetails;
    FundTransferPanel fundTransferPanel;
    Database database = new Database();

    public FundTransferService(FundTransferPanel fundTransferPanel, UserDetails userDetails){
        this.fundTransferPanel = fundTransferPanel;
        this.userDetails = userDetails;
    }

    public boolean validateFundTransfer(){
        if(formfilled()){
            if(validateDetails() && ValidatePin()) {
                return true;
            }
        }
        return false;
    }

    public boolean formfilled(){
        String msg = "*Required Field is Empty";
        if(fundTransferPanel.AccountNumberText.getText().isEmpty()){
            fundTransferPanel.Accountlabel.setText(msg);
            return false;
        }
        if(fundTransferPanel.AmountText.getText().isEmpty()){
            fundTransferPanel.Accountlabel.setText("");
            fundTransferPanel.amountlabel.setText(msg);
            return false;
        }
        if(fundTransferPanel.PinText.getText().isEmpty()){
            fundTransferPanel.Accountlabel.setText("");
            fundTransferPanel.amountlabel.setText("");
            fundTransferPanel.pinlabel.setText(msg);
            return false;
        }
        fundTransferPanel.Accountlabel.setText("");
        fundTransferPanel.amountlabel.setText("");
        fundTransferPanel.pinlabel.setText("");
        return true;
    }

    private boolean validateDetails(){
        boolean CorrectAccountNum  = false;
        ArrayList<Long> AccountNum = database.getAccountNumbers();

        if(Long.parseLong(fundTransferPanel.AccountNumberText.getText()) == userDetails.AccountNumber){
            JOptionPane.showMessageDialog(fundTransferPanel,"Cannot Transfer to Yourself");
            return false;
        }

        for(Long acc : AccountNum){
            if(Long.parseLong(fundTransferPanel.AccountNumberText.getText()) == acc){
                CorrectAccountNum = true;
            }
        }
        if(CorrectAccountNum){
            return true;
        }else{
            JOptionPane.showMessageDialog(fundTransferPanel,"Please Enter Correct Account Number");
            return false;
        }
    }
    private boolean ValidatePin(){
        if(Integer.parseInt(fundTransferPanel.PinText.getText()) == userDetails.Pin){
            return true;
        }else{
            JOptionPane.showMessageDialog(fundTransferPanel,"Pin is either wrong or not set. (You can set it in profile by giving address details)");
        }
        return false;
    }

    public Transactions getTransaction(){
        Transactions transactions = new Transactions();
        transactions.senders_AccountNo = userDetails.AccountNumber;
        transactions.receivers_AccountNo = Long.valueOf(fundTransferPanel.AccountNumberText.getText());
        transactions.amount = Integer.parseInt(fundTransferPanel.AmountText.getText());
        transactions.balance = userDetails.Balance;

        LocalDate currentDate = LocalDate.now();
        transactions.date = Date.valueOf(currentDate);

        LocalTime currentTime = LocalTime.now();
        transactions.time = Time.valueOf(currentTime);
        transactions.transactionperformed = "Fund Transferred";
        return transactions;
    }

    public long getAccNum(){
        return Long.parseLong(fundTransferPanel.AccountNumberText.getText());
    }

    public int getAmount(){
        return Integer.parseInt(fundTransferPanel.AmountText.getText());
    }
}

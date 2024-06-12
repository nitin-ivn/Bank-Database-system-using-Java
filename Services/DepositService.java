package services;

import Model.Transactions;
import Model.UserDetails;
import Views.Componenets.DepositPanel;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class DepositService {

    DepositPanel depositPanel;
    UserDetails userDetails;

    public DepositService(DepositPanel depositPanel,UserDetails userDetails){
        this.depositPanel = depositPanel;
        this.userDetails = userDetails;
    }

    public boolean validateDeposit(){
        if(validateDetails()) {
                return true;
        }
        return false;
    }

    private boolean validateDetails(){
        String msg = "*Required Field is Empty";
        if(depositPanel.AmountText.getText().isEmpty()){
            depositPanel.amountlabel.setText(msg);
            return false;
        }
        depositPanel.amountlabel.setText("");
        return true;
    }

    public int AddBalance(){
        return Integer.parseInt(depositPanel.AmountText.getText());
    }

    public Transactions getTransaction(){
        Transactions transactions = new Transactions();
        transactions.senders_AccountNo = userDetails.AccountNumber;
        transactions.receivers_AccountNo = userDetails.AccountNumber;
        transactions.amount = Integer.parseInt(depositPanel.AmountText.getText());
        transactions.balance = userDetails.Balance;

        LocalDate currentDate = LocalDate.now();
        transactions.date = Date.valueOf(currentDate);

        LocalTime currentTime = LocalTime.now();
        transactions.time = Time.valueOf(currentTime);
        transactions.transactionperformed = "Deposit";
        return transactions;
    }

}

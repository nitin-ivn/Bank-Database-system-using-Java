package services;

import Model.LoanDetails;
import Model.UserDetails;
import Views.Componenets.LoansPanel;

import javax.swing.*;
import java.util.Objects;

public class PaymentService {
    LoanDetails loanDetails;
    UserDetails userDetails;
    LoansPanel loansPanel;

    public PaymentService(LoansPanel loansPanel,UserDetails userDetails){
        this.userDetails = userDetails;
        this.loansPanel = loansPanel;
    }

    public boolean validateNext(){
        if(formFilled()){
            if(validatePin() && validateLoanID()) {
                loanDetails = Database.getLoanDetailsForPayment(Integer.parseInt(loansPanel.LoanIdText.getText()));
                loansPanel.LoanIdText.setFocusable(false);
                return true;
            }
        }
        return false;
    }

    private boolean formFilled(){
        String msg = "*Required Field is Empty";
        if(loansPanel.LoanIdText.getText().isEmpty()){
            loansPanel.loanidlabel.setText(msg);
            return false;
        }
        if(loansPanel.NoOfMonths.getSelectedIndex() == -1){
            loansPanel.loanidlabel.setText("");
            loansPanel.nofMonlabel.setText(msg);
            return false;
        }
        if(loansPanel.pinText.getText().isEmpty()){
            loansPanel.loanidlabel.setText("");
            loansPanel.nofMonlabel.setText("");
            loansPanel.pinlabel.setText(msg);
            return false;
        }
        loansPanel.loanidlabel.setText("");
        loansPanel.nofMonlabel.setText("");
        loansPanel.pinlabel.setText("");
        return true;
    }

    private boolean validatePin(){
        if(Integer.parseInt(loansPanel.pinText.getText())== userDetails.Pin){
            return true;
        }else{
            JOptionPane.showMessageDialog(loansPanel,"Pin is either wrong or not set. (You can set it in profile by giving address details)");
        }
        return false;
    }

    private boolean validateLoanID(){
        if(Database.ValidLoanID(Integer.parseInt(loansPanel.LoanIdText.getText()))){
            return true;
        }else {
            JOptionPane.showMessageDialog(loansPanel,"Wrong Loan ID");
        }

        return false;
    }

    public int setAmount(){
        int emi = Integer.parseInt((String) Objects.requireNonNull(loansPanel.NoOfMonths.getSelectedItem()));
        int res = (int) (loanDetails.Emi * emi);
        loansPanel.AmountText.setText(String.valueOf(res));
        return res;
    }

    public boolean loanActive(){
        if(loanDetails.loanActive){
            return true;
        }else {
            JOptionPane.showMessageDialog(loansPanel,"Loan is Already Cleared");
        }
        return false;
    }

    public LoanDetails getLoanDetails(){
        return loanDetails;
    }
}

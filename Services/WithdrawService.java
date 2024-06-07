package services;

import Model.UserDetails;
import Views.Componenets.WithdrawPanel;

import javax.swing.*;

public class WithdrawService {
    WithdrawPanel withdrawPanel;
    UserDetails userDetails;

    public WithdrawService(WithdrawPanel withdrawPanel, UserDetails userDetails){
        this.withdrawPanel = withdrawPanel;
        this.userDetails = userDetails;
    }

    public boolean validateWithdraw(){
        if(validateDetails()) {
            if(ValidatePin() && SufficientBalance()) {
                return true;
            }
        }
        return false;
    }

    private boolean validateDetails(){
        String msg = "*Required Field is Empty";
        if(withdrawPanel.AmountText.getText().isEmpty()){
            withdrawPanel.amountlabel.setText(msg);
            return false;
        }
        if(withdrawPanel.PinText.getText().isEmpty()){
            withdrawPanel.amountlabel.setText("");
            withdrawPanel.pinlabel.setText(msg);
            return false;
        }
        withdrawPanel.amountlabel.setText("");
        withdrawPanel.pinlabel.setText("");
        return true;
    }

    public int SubtractBalance(){
        return Integer.parseInt(withdrawPanel.AmountText.getText());
    }

    private boolean ValidatePin(){
        if(Integer.parseInt(withdrawPanel.PinText.getText()) == userDetails.Pin){
            return true;
        }else{
            JOptionPane.showMessageDialog(withdrawPanel,"Pin is either wrong or not set. (You can set it in profile by giving address details)");
        }
        return false;
    }

    private boolean SufficientBalance(){
        if(Integer.parseInt(withdrawPanel.AmountText.getText()) < userDetails.Balance){
            return true;
        }else{
            JOptionPane.showMessageDialog(withdrawPanel,"Insufficient Balance");
        }
        return false;
    }
}


package services;

import Model.UserDetails;
import Views.Componenets.DepositPanel;

import javax.swing.*;

public class DepositService {

    DepositPanel depositPanel;
    UserDetails userDetails;

    public DepositService(DepositPanel depositPanel,UserDetails userDetails){
        this.depositPanel = depositPanel;
        this.userDetails = userDetails;
    }

    public boolean validateDeposit(){
        if(validateDetails()) {
            if(ValidatePin()) {
                return true;
            }
        }
        return false;
    }

    private boolean validateDetails(){
        String msg = "*Required Field is Empty";
        if(depositPanel.AmountText.getText().isEmpty()){
            depositPanel.amountlabel.setText(msg);
            return false;
        }
        if(depositPanel.PinText.getText().isEmpty()){
            depositPanel.amountlabel.setText("");
            depositPanel.pinlabel.setText(msg);
            return false;
        }
        depositPanel.amountlabel.setText("");
        depositPanel.pinlabel.setText("");
        return true;
    }

    public int AddBalance(){
        return Integer.parseInt(depositPanel.AmountText.getText());
    }

    private boolean ValidatePin(){
        if(Integer.parseInt(depositPanel.PinText.getText()) == userDetails.Pin){
            return true;
        }else{
            JOptionPane.showMessageDialog(depositPanel,"Pin is either wrong or not set. (You can set it in profile by giving address details)");
        }
        return false;
    }
}

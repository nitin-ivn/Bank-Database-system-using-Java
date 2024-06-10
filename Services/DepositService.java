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

}

package services;

import Views.Componenets.PanelLogin;

import javax.swing.*;

public class Login {
    PanelLogin panelLogin;


    public Login(PanelLogin panelLogin){
        this.panelLogin = panelLogin;
    }

    public boolean formfilled(){
        String msg = "*Required Field is Empty";

        if(panelLogin.LAccountNumber.getText().isEmpty()){
            panelLogin.LabelAccno.setText(msg);
            return false;
        }
        if(panelLogin.Lpassword.getText().isEmpty()){
            panelLogin.LabelAccno.setText("");
            panelLogin.Labelpass.setText(msg);
            return false;
        }
        panelLogin.LabelAccno.setText("");
        panelLogin.Labelpass.setText("");
        return true;
    }

    public void SetHomePage(){
        if(formfilled()){
            JOptionPane.showMessageDialog(panelLogin,"Details are set");
        }
    }
}

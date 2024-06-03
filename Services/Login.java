package services;

import Model.LoginDetails;
import Views.Componenets.PanelLogin;
import Views.Pages.LoginAndRegisterPage;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.util.ArrayList;

public class Login {
    LoginDetails loginDetails = new LoginDetails();
    Database database = new Database();
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

    public boolean SetHomePage(){
        if(formfilled()){
            getLoginDetails();
            if(ValidateLogin()) {
                return true;
            }
        }
        return false;
    }
    public void getLoginDetails(){
        loginDetails.AccountNumber = Long.parseLong(panelLogin.LAccountNumber.getText());
        loginDetails.password = panelLogin.Lpassword.getText();
    }

    public boolean ValidateLogin(){
        ArrayList<Long> accountnum = database.getAccountNumbers();

        if(!(accountnum.contains(loginDetails.AccountNumber))){
            JOptionPane.showMessageDialog(panelLogin,"Please Enter a Valid Account Number");
            return false;
        }
        if(!(database.getIfRegistered(loginDetails.AccountNumber))){
            JOptionPane.showMessageDialog(panelLogin,"Given Account Number doesn't have a online account.Please create one");
            return false;
        }
        if(!(database.ValidateLoginPassword(loginDetails.password,loginDetails.AccountNumber))){
            JOptionPane.showMessageDialog(panelLogin,"Password seems to be wrong");
            return false;
        }
        return true;
    }


}

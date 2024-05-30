package services;
import Views.Componenets.PanelLogin;

import javax.swing.*;

public class Register {
    PanelLogin panelLogin;

    public Register(PanelLogin panelLogin) {
        this.panelLogin = panelLogin;

    }

    public boolean formfilled(){
        String msg = "*Required Field is Empty";

        if(panelLogin.FirstName.getText().isEmpty()){
            panelLogin.Labelfirstname.setText(msg);
            return false;
        }
        if(panelLogin.LastName.getText().isEmpty()){
            panelLogin.Labelfirstname.setText("");
            panelLogin.Labellastname.setText(msg);
            return false;
        }
        if(panelLogin.RAccountNumber.getText().isEmpty()){
            panelLogin.Labelfirstname.setText("");
            panelLogin.Labellastname.setText("");
            panelLogin.LabelAccountNumber.setText(msg);
            return false;
        }
        if(panelLogin.PhoneNumber.getText().isEmpty()){
            panelLogin.Labelfirstname.setText("");
            panelLogin.Labellastname.setText("");
            panelLogin.LabelAccountNumber.setText("");
            panelLogin.LabelPhoneNo.setText(msg);
            return false;
        }
        if(panelLogin.dob.getText().isEmpty()){
            panelLogin.Labelfirstname.setText("");
            panelLogin.Labellastname.setText("");
            panelLogin.LabelAccountNumber.setText("");
            panelLogin.LabelPhoneNo.setText("");
            panelLogin.LabelDob.setText(msg);
            return false;
        }
        if(panelLogin.Rpassword.getText().isEmpty()){
            panelLogin.Labelfirstname.setText("");
            panelLogin.Labellastname.setText("");
            panelLogin.LabelAccountNumber.setText("");
            panelLogin.LabelPhoneNo.setText("");
            panelLogin.LabelDob.setText("");
            panelLogin.Labelpassword.setText(msg);
            return false;
        }
        if(panelLogin.RconfirmPassword.getText().isEmpty()){
            panelLogin.Labelfirstname.setText("");
            panelLogin.Labellastname.setText("");
            panelLogin.LabelAccountNumber.setText("");
            panelLogin.LabelPhoneNo.setText("");
            panelLogin.LabelDob.setText("");
            panelLogin.Labelpassword.setText("");
            panelLogin.LabelConfirmPassowrd.setText(msg);
            return false;
        }
            panelLogin.Labelfirstname.setText("");
            panelLogin.Labellastname.setText("");
            panelLogin.LabelAccountNumber.setText("");
            panelLogin.LabelPhoneNo.setText("");
            panelLogin.LabelDob.setText("");
            panelLogin.Labelpassword.setText("");
            panelLogin.LabelConfirmPassowrd.setText("");
            return true;
    }

    public void SetHomePage(){
        if(formfilled()){
            JOptionPane.showMessageDialog(panelLogin,"Nigga");
        }
    }
}

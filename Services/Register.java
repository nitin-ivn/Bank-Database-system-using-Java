package services;
import Model.RegisterDetails;
import Views.Componenets.PanelLogin;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Register {
    Database database = new Database();
    PanelLogin panelLogin;
    RegisterDetails registerDetails = new RegisterDetails();
    ArrayList<Long> accountnum;

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

    public boolean SetHomePage(){
        if(formfilled()){
            accountnum = database.getAccountNumbers();
            if(getRegisterDetails() && validateRegister(accountnum, database.getIfRegistered(registerDetails.AccountNumber))) {
                database.InsertRegisterDetails(registerDetails);
                return true;
            }
        }
        return false;
    }

    private boolean getRegisterDetails() {
        registerDetails.FirstName = panelLogin.FirstName.getText();
        registerDetails.LastName = panelLogin.LastName.getText();
        registerDetails.PhoneNumber = Long.parseLong(panelLogin.PhoneNumber.getText());
        registerDetails.AccountNumber = Long.parseLong(panelLogin.RAccountNumber.getText());
        registerDetails.Email = panelLogin.email.getText();


        String datestr = panelLogin.dob.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = sdf.parse(datestr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panelLogin, "Please Enter a Valid Date.");
            return false;
        }
        registerDetails.DOB = date;

        registerDetails.Password = panelLogin.Rpassword.getText();
        return true;
    }

    private boolean validateRegister(ArrayList<Long> accountnum, boolean isRegistered){
        boolean passcorrect = false;
        boolean accExists = accountnum.contains(registerDetails.AccountNumber);


        if(Objects.equals(registerDetails.Password, panelLogin.RconfirmPassword.getText())){
            passcorrect = true;
        }else{
            JOptionPane.showMessageDialog(panelLogin,"Please Enter Same Password.");
        }

        if(!accExists){
            JOptionPane.showMessageDialog(panelLogin,"Please Enter a Valid Account Number");
        }
       if(isRegistered){
           JOptionPane.showMessageDialog(panelLogin,"An Account already exists with the given Account Number");
       }
        return accExists && passcorrect && !isRegistered;
    }
    public long getAccNumber(){
        return registerDetails.AccountNumber;
    }
}

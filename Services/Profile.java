package services;

import Model.Address;
import Model.UserDetails;
import Views.Componenets.ProfilePanel;

import javax.swing.*;

public class Profile {
    final static String msg = "*Required Field is Empty";
    Database database = new Database();
    ProfilePanel profilePanel;

    public Profile(ProfilePanel profilePanel){
        this.profilePanel = profilePanel;
    }

    public boolean validateAddresss(){
        if(Addressformfilled()) {
            database.InsertAddressDetails(getAddressDetails());
            return true;
        }
        return false;
    }

    private boolean Addressformfilled(){
        if(profilePanel.Houseno.getText().isEmpty()){
            profilePanel.housenolabel.setText(msg);
            return false;
        }
        if(profilePanel.Colony.getText().isEmpty()){
            profilePanel.housenolabel.setText("");
            profilePanel.colonylabel.setText(msg);
            return false;
        }
        if(profilePanel.City.getText().isEmpty()){
            profilePanel.housenolabel.setText("");
            profilePanel.colonylabel.setText("");
            profilePanel.citylabel.setText(msg);
            return false;
        }
        if(profilePanel.state.getSelectedIndex() == -1){
            profilePanel.housenolabel.setText("");
            profilePanel.colonylabel.setText("");
            profilePanel.citylabel.setText("");
            profilePanel.statelabel.setText(msg);
            return false;
        }
        if(profilePanel.pincode.getText().isEmpty()){
            profilePanel.housenolabel.setText("");
            profilePanel.colonylabel.setText("");
            profilePanel.citylabel.setText("");
            profilePanel.statelabel.setText("");
            profilePanel.pincodelabel.setText(msg);
            return false;
        }
        profilePanel.housenolabel.setText("");
        profilePanel.colonylabel.setText("");
        profilePanel.citylabel.setText("");
        profilePanel.statelabel.setText("");
        profilePanel.pincodelabel.setText("");
        return true;
    }

    public Address getAddressDetails(){
        Address address = new Address();
        address.HouseNo = profilePanel.Houseno.getText();
        address.Colony = profilePanel.Colony.getText();
        address.City = profilePanel.City.getText();
        address.State = "lol";
        address.Pincode = Integer.parseInt(profilePanel.pincode.getText());
        address.Country = "India";

        return address;
    }

    public boolean validateUserDetails(){
        if(userDetailsformfilled()){
            return true;
        }
        return false;
    }

    private boolean userDetailsformfilled(){
        if(profilePanel.firstname.getText().isEmpty()){
            profilePanel.firstnamelabel.setText(msg);
            return false;
        }
        if(profilePanel.lastname.getText().isEmpty()){
            profilePanel.firstnamelabel.setText("");
            profilePanel.lastnamelabel.setText(msg);
            return false;
        }
        if(profilePanel.phoneno.getText().isEmpty()){
            profilePanel.firstnamelabel.setText("");
            profilePanel.lastnamelabel.setText("");
            profilePanel.phonelabel.setText(msg);
            return false;
        }
        if(profilePanel.email.getText().isEmpty()){
            profilePanel.firstnamelabel.setText("");
            profilePanel.lastnamelabel.setText("");
            profilePanel.phonelabel.setText("");
            profilePanel.emaillabel.setText(msg);
            return false;
        }
        profilePanel.firstnamelabel.setText("");
        profilePanel.lastnamelabel.setText("");
        profilePanel.phonelabel.setText("");
        profilePanel.emaillabel.setText("");
        return true;
    }

    public UserDetails getUserDetails(){
        UserDetails userDetails = new UserDetails();
        userDetails.FirstName = profilePanel.firstname.getText();
        userDetails.LastName = profilePanel.lastname.getText();
        userDetails.PhoneNo = Long.parseLong(profilePanel.phoneno.getText());
        userDetails.Email = profilePanel.email.getText();
        return userDetails;
    }

    public boolean validatePasswordDetails(){
        if(Passwordformfilled()){
            if(ValidatePassConf()) {
                return true;
            }
        }
        return false;
    }

    public String getPassword(){
        return profilePanel.passwordField.getText();
    }

    private boolean Passwordformfilled(){
        if(profilePanel.passwordField.getText().isEmpty()){
            profilePanel.passlabel.setText(msg);
            return false;
        }
        if(profilePanel.confirmpasswordField.getText().isEmpty()){
            profilePanel.passlabel.setText("");
            profilePanel.confpasslabel.setText(msg);
            return false;
        }
        profilePanel.passlabel.setText("");
        profilePanel.confpasslabel.setText("");
        return true;
    }

    private boolean ValidatePassConf(){
        if(profilePanel.passwordField.getText().equals(profilePanel.confirmpasswordField.getText())){
            return true;
        }else{
            JOptionPane.showMessageDialog(profilePanel,"Please Enter Same Password");
            return false;
        }
    }

    public boolean validatePinDetails(){
        if(Pinformfilled()){
            if(ValidatePinConf()) {
                return true;
            }
        }
        return false;
    }

    public int getPin(){
        return Integer.parseInt(profilePanel.pin.getText());
    }

    private boolean Pinformfilled(){
        if(profilePanel.pin.getText().isEmpty()){
            profilePanel.pinlabel.setText(msg);
            return false;
        }
        if(profilePanel.confirmpin.getText().isEmpty()){
            profilePanel.pinlabel.setText("");
            profilePanel.confpinlabel.setText(msg);
            return false;
        }
        profilePanel.pinlabel.setText("");
        profilePanel.confpinlabel.setText("");
        return true;
    }

    private boolean ValidatePinConf(){
        if(Integer.parseInt(profilePanel.pin.getText()) == Integer.parseInt(profilePanel.confirmpin.getText())){
            return true;
        }else{
            JOptionPane.showMessageDialog(profilePanel,"Please Enter Same Pin");
            return false;
        }
    }
}

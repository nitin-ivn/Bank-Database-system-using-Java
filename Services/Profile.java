package services;

import Model.Address;
import Views.Componenets.ProfilePanel;

public class Profile {
    Database database = new Database();
    ProfilePanel profilePanel;

    public Profile(ProfilePanel profilePanel){
        this.profilePanel = profilePanel;
    }

    public boolean validateAddresss(){
        database.InsertAddressDetails(getAddressDetails());
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
}

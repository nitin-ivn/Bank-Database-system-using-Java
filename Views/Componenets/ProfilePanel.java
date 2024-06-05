package Views.Componenets;

import Model.UserDetails;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel{
        UserDetails userDetails;
        String[] statesAndUTs = {
            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
            "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
            "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
            "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
            "Uttar Pradesh", "Uttarakhand", "West Bengal", "Chandigarh",
            "Delhi", "Lakshadweep", "Puducherry", "Ladakh", "Jammu and Kashmir"
    };


    Color bgcolor = new Color(71,75,75);
    JLabel title = new JLabel("Profile");
    JLabel addresslabel = new JLabel("Address");
    MyTextField Houseno = new MyTextField();
    MyTextField Colony = new MyTextField();
    MyTextField City = new MyTextField();
    MyComboBox state = new MyComboBox(statesAndUTs);
    MyTextField pincode = new MyTextField();
    MyTextField country = new MyTextField();
    MyButton setAddress = new MyButton("Update Address");

    JLabel user = new JLabel("User Details");
    MyTextField firstname = new MyTextField();
    MyTextField lastname = new MyTextField();
    MyTextField phoneno = new MyTextField();
    MyTextField email = new MyTextField();
    MyButton UpdateDetails = new MyButton("Update");

    JLabel pass = new JLabel("Password");
    MyPasswordField passwordField = new MyPasswordField();
    MyPasswordField confirmpasswordField = new MyPasswordField();
    MyButton UpdatePassword = new MyButton("Update");

    JLabel resetpin = new JLabel("Reset Pin");
    MyTextField pin = new MyTextField();
    MyTextField confirmpin = new MyTextField();
    MyButton Setpin = new MyButton("Set Pin");

    ButtonOutline DeleteAccount = new ButtonOutline("Delete Account",0);

    public ProfilePanel(UserDetails userDetails){
        setBackground(Color.WHITE);
        this.userDetails = userDetails;
        setLayout(new MigLayout("fill"));

        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,36));
        add(title,"pos 310 0");

        addresslabel.setForeground(bgcolor);
        addresslabel.setFont(new Font("sansserif",Font.BOLD,28));
        add(addresslabel,"pos 30 85");

        Houseno.setHint("House Number");
        add(Houseno,"width 160,pos 30 130");

        Colony.setHint("Colony");
        add(Colony,"width 160,pos 197 130");

        City.setHint("City");
        add(City,"width 160,pos 30 180");

        state.setHint("State");
        state.setBackground(new Color(222, 223, 223));
        state.setSelectedIndex(-1);
        add(state,"width 160,height 42,pos 197 180");

        pincode.setHint("Pin Code");
        add(pincode,"width 160,pos 30 230");

        country.setFocusable(false);
        country.setText("India");
        add(country,"width 160, pos 197 230");

        setAddress.setFont(new Font("sansserif",Font.BOLD,18));
        add(setAddress,"width 100, height 40,pos 30 285");

        user.setForeground(bgcolor);
        user.setFont(new Font("sansserif",Font.BOLD,30));
        add(user,"pos 400 85");

        firstname.setHint("First Name");
        add(firstname,"width 147,pos 400 130");

        lastname.setHint("Last Name");
        add(lastname,"width 147,pos 553 130");

        phoneno.setHint("Phone Number");
        add(phoneno,"width 300,pos 400 180");

        email.setHint("Email");
        add(email,"width 300,pos 400 230");

        UpdateDetails.setFont(new Font("sansserif",Font.BOLD,18));
        add(UpdateDetails,"width 100, height 40,pos 400 285");

        resetpin.setForeground(bgcolor);
        resetpin.setFont(new Font("sansserif",Font.BOLD,28));
        add(resetpin,"pos 30 360");

        pin.setHint("New Pin");
        add(pin,"width 320,pos 30 410");

        confirmpin.setHint("Confirm New Pin");
        add(confirmpin,"width 320,pos 30 460");

        Setpin.setFont(new Font("sansserif",Font.BOLD,18));
        add(Setpin,"width 100, height 40,pos 30 515");

        pass.setFont(new Font("sansserif",Font.BOLD,28));
        pass.setForeground(bgcolor);
        add(pass,"pos 400 360");

        passwordField.setHint("New Password");
        add(passwordField,"width 300,pos 400 410");

        confirmpasswordField.setHint("Confirm New Password");
        add(confirmpasswordField,"width 300, pos 400 460");

        UpdatePassword.setFont(new Font("sansserif",Font.BOLD,18));
        add(UpdatePassword,"width 100,height 40,pos 400 515");

        DeleteAccount.setForeground(Color.RED);
        DeleteAccount.setBackground(Color.WHITE);
        DeleteAccount.setBorderColor(Color.RED);
        DeleteAccount.setFont(new Font("sansserif",Font.BOLD,12));
        add(DeleteAccount,"width 100,height 30,pos 580 585");
    }

    public ProfilePanel getProfilePanel(){
        return ProfilePanel.this;
    }

    public JButton getAddressButton(){
        return setAddress;
    }

    public JButton getUpdateDetailsButton(){
        return UpdateDetails;
    }

    public JButton getUpdatePasswordButton(){
        return UpdatePassword;
    }

    public JButton getpinButton(){
        return Setpin;
    }
}

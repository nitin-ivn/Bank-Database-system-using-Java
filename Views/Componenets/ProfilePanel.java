package Views.Componenets;

import Model.UserDetails;
import net.miginfocom.swing.MigLayout;
import services.Database;

import javax.swing.*;
import javax.xml.crypto.Data;
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

    JLabel Userdetail = new JLabel("User Details");

    public ProfilePanel(){
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
        add(setAddress,"width 100, height 40,pos 30 300");

    }

}

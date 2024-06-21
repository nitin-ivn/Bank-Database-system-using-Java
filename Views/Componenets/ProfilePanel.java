package Views.Componenets;

import Model.UserDetails;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    private final Font labelfont = new Font("sansserif", Font.BOLD,10);
    Color bgcolor = new Color(71,75,75);
    JLabel title = new JLabel("Profile");
    JLabel addresslabel = new JLabel("Address");
    public MyTextField Houseno = new MyTextField();
    public MyTextField Colony = new MyTextField();
    public MyTextField City = new MyTextField();
    public MyComboBox state = new MyComboBox(statesAndUTs);
    public MyTextField pincode = new MyTextField();
    public MyTextField country = new MyTextField();
    MyButton setAddress = new MyButton("Update Address");

    public JLabel housenolabel = new JLabel();
    public JLabel colonylabel = new JLabel();
    public JLabel citylabel = new JLabel();
    public JLabel statelabel = new JLabel();
    public JLabel pincodelabel = new JLabel();

    JLabel user = new JLabel("User Details");
    public MyTextField firstname = new MyTextField();
    public MyTextField lastname = new MyTextField();
    public MyTextField phoneno = new MyTextField();
    public MyTextField email = new MyTextField();
    MyButton UpdateDetails = new MyButton("Update");

    public JLabel firstnamelabel = new JLabel();
    public JLabel lastnamelabel = new JLabel();
    public JLabel phonelabel = new JLabel();
    public JLabel emaillabel = new JLabel();

    JLabel pass = new JLabel("Password");
    public MyPasswordField passwordField = new MyPasswordField();
    public MyPasswordField confirmpasswordField = new MyPasswordField();
    MyButton UpdatePassword = new MyButton("Update");

    public JLabel passlabel = new JLabel();
    public JLabel confpasslabel = new JLabel();

    JLabel resetpin = new JLabel("Reset Pin");
    public MyPasswordField pin = new MyPasswordField();
    public MyPasswordField confirmpin = new MyPasswordField();
    MyButton Setpin = new MyButton("Set Pin");

    public JLabel pinlabel = new JLabel();
    public JLabel confpinlabel = new JLabel();

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

        housenolabel.setFont(labelfont);
        housenolabel.setForeground(Color.RED);
        add(housenolabel,"pos 30 170");

        Colony.setHint("Colony");
        add(Colony,"width 160,pos 197 130");

        colonylabel.setForeground(Color.RED);
        colonylabel.setFont(labelfont);
        add(colonylabel,"pos 197 170");

        City.setHint("City");
        add(City,"width 160,pos 30 190");

        citylabel.setFont(labelfont);
        citylabel.setForeground(Color.RED);
        add(citylabel,"pos 30 230");

        state.setHint("State");
        state.setBackground(new Color(222, 223, 223));
        state.setSelectedIndex(-1);
        add(state,"width 160,height 42,pos 197 190");

        statelabel.setFont(labelfont);
        statelabel.setForeground(Color.RED);
        add(statelabel,"pos 197 230");

        pincode.setHint("Pin Code");
        add(pincode,"width 160,pos 30 250");
        pincode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });
        pincode.setLimit(9);

        pincodelabel.setFont(labelfont);
        pincodelabel.setForeground(Color.RED);
        add(pincodelabel,"pos 30 290");

        country.setFocusable(false);
        country.setText("India");
        add(country,"width 160, pos 197 250");

        setAddress.setFont(new Font("sansserif",Font.BOLD,18));
        add(setAddress,"width 100, height 40,pos 30 305");

        user.setForeground(bgcolor);
        user.setFont(new Font("sansserif",Font.BOLD,30));
        add(user,"pos 400 85");

        firstname.setHint("First Name");
        add(firstname,"width 147,pos 400 130");
        firstname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });

        firstnamelabel.setFont(labelfont);
        firstnamelabel.setForeground(Color.RED);
        add(firstnamelabel,"pos 400 170");

        lastname.setHint("Last Name");
        add(lastname,"width 147,pos 553 130");
        lastname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });

        lastnamelabel.setFont(labelfont);
        lastnamelabel.setForeground(Color.RED);
        add(lastnamelabel,"pos 553 170");

        phoneno.setHint("Phone Number");
        add(phoneno,"width 300,pos 400 190");
        phoneno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });
        phoneno.setLimit(10);

        phonelabel.setFont(labelfont);
        phonelabel.setForeground(Color.RED);
        add(phonelabel,"pos 400 230");

        email.setHint("Email");
        add(email,"width 300,pos 400 250");

        emaillabel.setFont(labelfont);
        emaillabel.setForeground(Color.RED);
        add(emaillabel,"pos 400 290");

        UpdateDetails.setFont(new Font("sansserif",Font.BOLD,18));
        add(UpdateDetails,"width 100, height 40,pos 400 305");

        resetpin.setForeground(bgcolor);
        resetpin.setFont(new Font("sansserif",Font.BOLD,28));
        add(resetpin,"pos 30 380");

        pin.setHint("New Pin");
        add(pin,"width 320,pos 30 430");
        pin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });
        pin.setLimit(4);

        pinlabel.setFont(labelfont);
        pinlabel.setForeground(Color.RED);
        add(pinlabel,"pos 30 470");

        confirmpin.setHint("Confirm New Pin");
        add(confirmpin,"width 320,pos 30 490");
        confirmpin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });
        confirmpin.setLimit(4);

        confpinlabel.setFont(labelfont);
        confpinlabel.setForeground(Color.RED);
        add(confpinlabel,"pos 40 530");

        Setpin.setFont(new Font("sansserif",Font.BOLD,18));
        add(Setpin,"width 100, height 40,pos 30 550");

        pass.setFont(new Font("sansserif",Font.BOLD,28));
        pass.setForeground(bgcolor);
        add(pass,"pos 400 380");

        passwordField.setHint("New Password");
        add(passwordField,"width 300,pos 400 430");

        passlabel.setFont(labelfont);
        passlabel.setForeground(Color.RED);
        add(passlabel,"pos 400 470");

        confirmpasswordField.setHint("Confirm New Password");
        add(confirmpasswordField,"width 300, pos 400 490");

        confpasslabel.setFont(labelfont);
        confpasslabel.setForeground(Color.RED);
        add(confpasslabel,"pos 400 530");

        UpdatePassword.setFont(new Font("sansserif",Font.BOLD,18));
        add(UpdatePassword,"width 100,height 40,pos 400 550");

        DeleteAccount.setForeground(Color.RED);
        DeleteAccount.setBackground(Color.WHITE);
        DeleteAccount.setBorderColor(Color.RED);
        DeleteAccount.setFont(new Font("sansserif",Font.BOLD,12));
        add(DeleteAccount,"width 100,height 30,pos 580 595");
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

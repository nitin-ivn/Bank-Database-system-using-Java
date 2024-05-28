package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelLogin extends JLayeredPane {
//    String[] statesAndUTs = {
//            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
//            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
//            "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
//            "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
//            "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
//            "Uttar Pradesh", "Uttarakhand", "West Bengal", "Chandigarh",
//            "Delhi", "Lakshadweep", "Puducherry", "Ladakh", "Jammu and Kashmir"
//    };

    JPanel login = new JPanel();
    JPanel register = new JPanel();

    MyButton Registerbutton = new MyButton("Register");
    MyTextField fullname = new MyTextField();
    MyTextField RAccountNumber = new MyTextField();
    MyTextField RPhoneNumber = new MyTextField();
    MyTextField email = new MyTextField();
    MyPasswordField Rpassword = new MyPasswordField();
    MyPasswordField RconfirmPassword = new MyPasswordField();
    DOBField dob = new DOBField();

    MyButton LoginButton = new MyButton("Login");


    public PanelLogin(){
        setLayout(new CardLayout());
        add(login,"card3");
        add(register,"card2");
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);

    }

    private void initRegister(){
        register.setBackground(Color.WHITE);
        register.setLayout(new MigLayout("wrap","",""));

        JLabel createAccount = new JLabel("Create Account");
        createAccount.setFont(new Font("sansserif", Font.BOLD,35));
        createAccount.setForeground(new Color(71,75,75));
        register.add(createAccount,"pos 50 50");


        fullname.setHint("Full Name");
        fullname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        register.add(fullname,"width 400px,pos 50 110");

        RAccountNumber.setHint("Account Number");
        RAccountNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        register.add(RAccountNumber,"width 400px, pos 50 170");

        RPhoneNumber.setHint("Phone Number");
        RPhoneNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        register.add(RPhoneNumber,"width 190,pos 50 230");

        dob.setHint("DD/MM/YYYY");
        register.add(dob,"width 200, pos 250 230");

        email.setHint("Email");
        register.add(email,"width 400, pos 50 290");


        Rpassword.setHint("Password");
        register.add(Rpassword,"width 400, pos 50 350");

        RconfirmPassword.setHint("Confirm Password");
        register.add(RconfirmPassword,"width 400,pos 50 410");

        Registerbutton.setFont(new Font("sansserif",Font.BOLD,18));
        register.add(Registerbutton,"width 200, height 50px, pos 50 500");

    }

    private void initLogin(){
        login.setBackground(Color.WHITE);
        login.setLayout(new MigLayout("wrap","",""));

        JLabel LoginAccount = new JLabel("Login");
        LoginAccount.setFont(new Font("sansserif", Font.BOLD,35));
        LoginAccount.setForeground(new Color(71,75,75));
        login.add(LoginAccount,"pos 50 130");


        LoginButton.setFont(new Font("sansserif",Font.BOLD,18));
        login.add(LoginButton, "width 200,pos 50 370");



    }

    public void ShowRegister(boolean show){
        if(show){
            register.setVisible(true);
            login.setVisible(false);
        }else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
}

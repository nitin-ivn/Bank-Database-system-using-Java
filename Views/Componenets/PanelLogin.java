package Views.Componenets;

import Services.Register;
import Views.Pages.LoginAndRegisterPage;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    public JLabel Labelfullname = new JLabel();
    JLabel Labellastname = new JLabel();
    JLabel LabelAccountNumber = new JLabel();
    JLabel LabelPhoneNo = new JLabel();
    JLabel LabelDob = new JLabel();
    JLabel Labelpassword = new JLabel();
    JLabel LabelConfirmPassowrd = new JLabel();


    MyButton Registerbutton = new MyButton("Register");
    public MyTextField FirstName = new MyTextField();
    MyTextField LastName = new MyTextField();
    MyTextField RAccountNumber = new MyTextField();
    MyTextField RPhoneNumber = new MyTextField();
    MyTextField email = new MyTextField();
    MyPasswordField Rpassword = new MyPasswordField();
    MyPasswordField RconfirmPassword = new MyPasswordField();
    DOBField dob = new DOBField();

    MyButton LoginButton = new MyButton("Login");
    MyTextField LAccountNumber = new MyTextField();
    MyPasswordField Lpassword = new MyPasswordField();
    JLabel forgotpassord = new JLabel("Forgot Your Passoword?");


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


        FirstName.setHint("First Name");
        FirstName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        register.add(FirstName,"width 195,pos 50 110");

        Labelfullname.setForeground(Color.RED);
        Labelfullname.setFont(new Font("sansserif",Font.PLAIN,10));
        register.add(Labelfullname,"pos 50 155");

        LastName.setHint("Last Name");
        LastName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        register.add(LastName,"width 195,pos 255 110");

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

        Registerbutton.addActionListener(new RegisterButtonListener());
        Registerbutton.setFont(new Font("sansserif",Font.BOLD,18));
        register.add(Registerbutton,"width 200, height 50px, pos 50 500");

    }

    private void initLogin(){
        login.setBackground(Color.WHITE);
        login.setLayout(new MigLayout("wrap","",""));

        JLabel LoginAccount = new JLabel("Login");
        LoginAccount.setFont(new Font("sansserif", Font.BOLD,35));
        LoginAccount.setForeground(new Color(71,75,75));
        login.add(LoginAccount,"pos 50 160");

        LAccountNumber.setHint("Account Number");
        LAccountNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        login.add(LAccountNumber,"width 400px, pos 50 220");

        Lpassword.setHint("Password");
        login.add(Lpassword,"width 400, pos 50 280");

        forgotpassord.setForeground(Color.BLACK);
        forgotpassord.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"Dumb Piece of shit");
            }
        });
        login.add(forgotpassord,"pos 50 340");

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
    class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Register register1 = new Register(PanelLogin.this);
            register1.SetHomePage();
        }
    }

}

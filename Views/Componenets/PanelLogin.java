package Views.Componenets;

import services.Login;
import services.Register;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelLogin extends JLayeredPane {


    JPanel login = new JPanel();
    JPanel register = new JPanel();

    private final Font labelfont = new Font("sansserif", Font.BOLD,10);

    public JLabel LabelAccno = new JLabel();
    public JLabel Labelpass = new JLabel();

    public JLabel Labelfirstname = new JLabel();
    public JLabel Labellastname = new JLabel();
    public JLabel LabelAccountNumber = new JLabel();
    public JLabel LabelPhoneNo = new JLabel();
    public JLabel LabelDob = new JLabel();
    public JLabel Labelpassword = new JLabel();
    public JLabel LabelConfirmPassowrd = new JLabel();

    JLabel clearform = new JLabel();
    MyButton Registerbutton = new MyButton("Register");
    public MyTextField FirstName = new MyTextField();
    public MyTextField LastName = new MyTextField();
    public MyTextField RAccountNumber = new MyTextField();
    public MyTextField PhoneNumber = new MyTextField();
    public MyTextField email = new MyTextField();
    public MyPasswordField Rpassword = new MyPasswordField();
    public MyPasswordField RconfirmPassword = new MyPasswordField();
    public DOBField dob = new DOBField();

    MyButton LoginButton = new MyButton("Login");
    public MyTextField LAccountNumber = new MyTextField();
    public MyPasswordField Lpassword = new MyPasswordField();
    public JLabel forgotpassord = new JLabel("Forgot Your Passoword?");


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
        createAccount.setFont(new Font("sansserif",Font.BOLD,35));
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

        Labelfirstname.setForeground(Color.RED);
        Labelfirstname.setFont(labelfont);
        register.add(Labelfirstname,"pos 50 155");

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

        Labellastname.setForeground(Color.RED);
        Labellastname.setFont(new Font("sansserif",Font.PLAIN,10));
        register.add(Labellastname,"pos 255 155");

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

        LabelAccountNumber.setForeground(Color.RED);
        LabelAccountNumber.setFont(labelfont);
        register.add(LabelAccountNumber,"pos 50 215");

        PhoneNumber.setHint("Phone Number");
        PhoneNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        register.add(PhoneNumber,"width 190,pos 50 230");

        LabelPhoneNo.setForeground(Color.RED);
        LabelPhoneNo.setFont(labelfont);
        register.add(LabelPhoneNo,"pos 50 275");

        dob.setHint("DD/MM/YYYY");
        register.add(dob,"width 200, pos 250 230");

        LabelDob.setForeground(Color.RED);
        LabelDob.setFont(labelfont);
        register.add(LabelDob,"pos 250 275");

        email.setHint("Email");
        register.add(email,"width 400, pos 50 290");


        Rpassword.setHint("Password");
        register.add(Rpassword,"width 400, pos 50 350");

        Labelpassword.setForeground(Color.RED);
        Labelpassword.setFont(labelfont);
        register.add(Labelpassword,"pos 50 395");

        RconfirmPassword.setHint("Confirm Password");
        register.add(RconfirmPassword,"width 400,pos 50 410");

        LabelConfirmPassowrd.setForeground(Color.RED);
        LabelConfirmPassowrd.setFont(labelfont);
        register.add(LabelConfirmPassowrd,"pos 50 455");

        clearform.setText("Clear Form");
        clearform.setForeground(Color.BLACK);
        clearform.setFont(new Font("sansserif",Font.BOLD,16));
        clearform.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FirstName.setText("");
                LastName.setText("");
                RAccountNumber.setText("");
                PhoneNumber.setText("");
                dob.setText("");
                email.setText("");
                Rpassword.setText("");
                RconfirmPassword.setText("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            }
        });
        register.add(clearform,"pos 50 475");

        Registerbutton.setFont(new Font("sansserif",Font.BOLD,18));
        register.add(Registerbutton,"width 200, height 50px, pos 50 510");

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

        LabelAccno.setForeground(Color.RED);
        LabelAccno.setFont(labelfont);
        login.add(LabelAccno,"pos 50 265");

        Lpassword.setHint("Password");
        login.add(Lpassword,"width 400, pos 50 280");

        Labelpass.setForeground(Color.RED);
        Labelpass.setFont(labelfont);
        login.add(Labelpass,"pos 50 325");

        forgotpassord.setForeground(Color.BLACK);
        forgotpassord.setFont(new Font("sansserif",Font.BOLD,14));
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
    public JButton getLoginButton(){
        return LoginButton;
    }

    public JButton getRegisterButton(){
        return Registerbutton;
    }

    public PanelLogin getloginpanel(){
        return PanelLogin.this;
    }


}

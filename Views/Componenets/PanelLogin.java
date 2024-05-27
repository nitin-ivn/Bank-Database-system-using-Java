package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class PanelLogin extends JLayeredPane {
    JPanel login = new JPanel();
    JPanel register = new JPanel();
    MyButton Registerbutton = new MyButton("Register");


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
        JLabel Rlabel = new JLabel("Create Account");
        Rlabel.setFont(new Font("sansserif", Font.BOLD,35));
        Rlabel.setForeground(new Color(71,75,75));
        register.add(Rlabel);
        register.add(Registerbutton);

    }

    private void initLogin(){

    }
}

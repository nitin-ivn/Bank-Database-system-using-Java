package Views.Pages;

import Views.Componenets.ButtonOutline;
import Views.Componenets.HomeButtons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage {
    Color bgcolor = new Color(71,75,75);
    MigLayout layout;
    HomeButtons AccountDetails = new HomeButtons("Account Details");
    JFrame frame = new JFrame("Bank");
    JPanel sidepanel = new JPanel();

    public HomePage(){
        layout = new MigLayout("insets 0, fill,wrap");
        frame.setLayout(layout);
        frame.setSize(1100,700);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        AccountDetails.setBackground(new Color(64,67,67));
        AccountDetails.setForeground(Color.WHITE);
        AccountDetails.setBorder(new EmptyBorder(5,5,5,5));

        sidepanel.setLayout(new MigLayout("insets 0"));
        sidepanel.add(AccountDetails,"width 100%,height 50,pos 0 250");
        sidepanel.setBackground(bgcolor);

        frame.add(sidepanel,"width 30%, pos 0al 0 n 100%");
    }
}

package Views.Componenets;

import Model.UserDetails;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class AccountDetailsPanel extends JPanel {
    UserDetails userDetails;
    Color bgcolor = new Color(71, 75, 75);
    JLabel AccountDetails = new JLabel("Account Details");

    JLabel FirstName = new JLabel("First Name       :");
    JLabel firstnameValue = new JLabel();

    JLabel LastName = new JLabel("Last Name       :");
    JLabel lastnameValue = new JLabel();

    JLabel AccountNumber = new JLabel("Account Number  :");
    JLabel accountnumbervalue = new JLabel();

    JLabel DOB = new JLabel("DOB          :");
    JLabel dobvalue = new JLabel();

    JLabel Phonenumber = new JLabel("Phone Number   :");
    JLabel phonenumbervalue = new JLabel();

    JLabel Email = new JLabel("Email         :");
    JLabel emailvalue = new JLabel();

    MyButton CheckBalanceButton = new MyButton("Check Balance");

    public AccountDetailsPanel(UserDetails userDetails) {
        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));
        AccountDetails.setForeground(bgcolor);
        AccountDetails.setFont(new Font("sansserif", Font.BOLD, 36));
        add(AccountDetails, "pos 240 60");

        setPreferredSize(new Dimension(400, 100));

        FirstName.setForeground(new Color(102, 108, 108));
        FirstName.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(FirstName, "pos 190 140");

        firstnameValue.setForeground(bgcolor);
        firstnameValue.setFont(new Font("sansserif", Font.BOLD, 20));
        firstnameValue.setText("userDetails.FirstName");
        add(firstnameValue,"pos 350 140");

        LastName.setForeground(new Color(102, 108, 108));
        LastName.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(LastName, "pos 190 190");

        lastnameValue.setForeground(bgcolor);
        lastnameValue.setFont(new Font("sansserif", Font.BOLD, 20));
        lastnameValue.setText("userDetails.LastName");
        add(lastnameValue,"pos 350 190");

        AccountNumber.setForeground(new Color(102, 108, 108));
        AccountNumber.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(AccountNumber, "pos 170 240");

        accountnumbervalue.setForeground(bgcolor);
        accountnumbervalue.setFont(new Font("sansserif", Font.BOLD, 20));
        accountnumbervalue.setText("userDetails.AccountNo");
        add(accountnumbervalue,"pos 350 240");

        DOB.setForeground(new Color(102, 108, 108));
        DOB.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(DOB, "pos 220 290");

        dobvalue.setForeground(bgcolor);
        dobvalue.setFont(new Font("sansserif", Font.BOLD, 20));
        dobvalue.setText("userDetails.DOB");
        add(dobvalue,"pos 350 290");

        Phonenumber.setForeground(new Color(102, 108, 108));
        Phonenumber.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Phonenumber, "pos 175 340");

        phonenumbervalue.setForeground(bgcolor);
        phonenumbervalue.setFont(new Font("sansserif", Font.BOLD, 20));
        phonenumbervalue.setText("userDetails.Phone");
        add(phonenumbervalue,"pos 350 340");

        Email.setForeground(new Color(102, 108, 108));
        Email.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Email, "pos 220 390");

        emailvalue.setForeground(bgcolor);
        emailvalue.setFont(new Font("sansserif", Font.BOLD, 20));
        emailvalue.setText("userDetails.Email");
        add(emailvalue,"pos 350 390");

        CheckBalanceButton.setFont(new Font("sansserif",Font.BOLD,18));
        add(CheckBalanceButton,"width 120,height 40,pos 250 445");
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(bgcolor);
        int lineX = AccountDetails.getX() - 87; // Adjust for the extension on the left
        int lineY = AccountDetails.getY() + AccountDetails.getHeight() + 14; // Adjust as needed
        int lineWidth = AccountDetails.getWidth() + 170; // Adjust for the extension on both sides
        int lineHeight = 2; // Adjust the height of the line as needed
        g.fillRect(lineX, lineY, lineWidth, lineHeight);
    }

    public JButton getCheckBalanceButton(){
        return CheckBalanceButton;
    }

    public AccountDetailsPanel getAccountsPanel(){
        return AccountDetailsPanel.this;
    }
}

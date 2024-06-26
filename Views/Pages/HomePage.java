package Views.Pages;

import Model.UserDetails;
import Views.Componenets.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage {
    UserDetails userDetails;

    Color bgcolor = new Color(71,75,75);
    ImageIcon imageIcon;
    JLabel bankimage;
    MigLayout layout;
    ProfilePanel profilePanel;
    DepositPanel depositPanel;
    LoansPanel loansPanel;
    AccountDetailsPanel accountspanel;
    FundTransferPanel fundTransferPanel;

    ButtonOutline AccountDetails = new ButtonOutline("Account Details",1);
    ButtonOutline Depositbutton = new ButtonOutline("Deposit",1);
    ButtonOutline Loansbutton = new ButtonOutline("Loans",1);
    ButtonOutline FundTransferButton = new ButtonOutline("Fund Transfer", 1);
    ButtonOutline ProfileButton = new ButtonOutline("Profile",0);
    ButtonOutline LogoutButton = new ButtonOutline("Log Out", 0);


    public JFrame frame = new JFrame("Bank");
    JPanel sidepanel = new JPanel();

    public HomePage(UserDetails userDetails){
        depositPanel = new DepositPanel();
        loansPanel = new LoansPanel();
        fundTransferPanel = new FundTransferPanel(userDetails);
        accountspanel = new AccountDetailsPanel();
        accountspanel.setUserDetails(userDetails);
        accountspanel.gui();
        profilePanel = new ProfilePanel(userDetails);
        this.userDetails = userDetails;
        layout = new MigLayout("insets 0, fill,wrap");
        frame.setLayout(layout);
        frame.setSize(1100,700);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageIcon = new ImageIcon("Icons/bankimage.png");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        bankimage = new JLabel();
        bankimage.setPreferredSize(new Dimension(175,175));
        bankimage.setIcon(resizedIcon);

        JLabel banktext = new JLabel("The Bank");
        banktext.setFont(new Font("sansserif",Font.BOLD,30));
        banktext.setForeground(Color.WHITE);

        AccountDetails.setBackground(new Color(64,67,67));
        AccountDetails.setForeground(Color.WHITE);
        AccountDetails.setFont(new Font("sansserif",Font.BOLD,16));
        AccountDetails.setBorder(new EmptyBorder(5,5,5,5));
        AccountDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accountspanel.setVisible(true);
                depositPanel.setVisible(false);
                loansPanel.setVisible(false);
                fundTransferPanel.setVisible(false);
                profilePanel.setVisible(false);
            }
        });

        Depositbutton.setBackground(new Color(64,67,67));
        Depositbutton.setForeground(Color.WHITE);
        Depositbutton.setFont(new Font("",Font.BOLD,16));
        Depositbutton.setBorder(new EmptyBorder(5,5,5,5));
        Depositbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accountspanel.setVisible(false);
                depositPanel.setVisible(true);
                loansPanel.setVisible(false);
                fundTransferPanel.setVisible(false);
                profilePanel.setVisible(false);
            }
        });

        Loansbutton.setBackground(new Color(64,67,67));
        Loansbutton.setForeground(Color.WHITE);
        Loansbutton.setFont(new Font("",Font.BOLD,16));
        Loansbutton.setBorder(new EmptyBorder(5,5,5,5));
        Loansbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accountspanel.setVisible(false);
                depositPanel.setVisible(false);
                loansPanel.setVisible(true);
                fundTransferPanel.setVisible(false);
                profilePanel.setVisible(false);
            }
        });

        FundTransferButton.setBackground(new Color(64,67,67));
        FundTransferButton.setForeground(Color.WHITE);
        FundTransferButton.setFont(new Font("",Font.BOLD,16));
        FundTransferButton.setBorder(new EmptyBorder(5,5,5,5));
        FundTransferButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accountspanel.setVisible(false);
                depositPanel.setVisible(false);
                loansPanel.setVisible(false);
                fundTransferPanel.setVisible(true);
                profilePanel.setVisible(false);
            }
        });

        ProfileButton.setBackground(new Color(71,75,75));
        ProfileButton.setForeground(Color.WHITE);
        ProfileButton.setBorderColor(Color.WHITE);
        ProfileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accountspanel.setVisible(false);
                depositPanel.setVisible(false);
                loansPanel.setVisible(false);
                fundTransferPanel.setVisible(false);
                profilePanel.setVisible(true);
            }
        });

        LogoutButton.setBackground(new Color(71,75,75));
        LogoutButton.setForeground(Color.WHITE);
        LogoutButton.setBorderColor(Color.WHITE);

        sidepanel.setLayout(new MigLayout("insets 0"));
        sidepanel.add(AccountDetails,"width 100%,height 60,pos 0 270");
        sidepanel.add(Depositbutton,"width 100%,height 60,pos 0 325");
        sidepanel.add(Loansbutton,"width 100%,height 60,pos 0 380");
        sidepanel.add(FundTransferButton,"width 100%,height 60,pos 0 435");
        sidepanel.setBackground(bgcolor);
        sidepanel.add(bankimage,"pos 68 10");
        sidepanel.add(banktext,"pos 90 190");
        sidepanel.add(ProfileButton,"width 110,height 40,pos 10 600");
        sidepanel.add(LogoutButton,"width 110, height 40,pos 190 600");

        frame.add(sidepanel,"width 30%, pos 0al 0 n 100%");
        frame.add(accountspanel,"width 70%, pos 1al 0 n 100%");
        frame.add(depositPanel,"width 70%, pos 1al 0 n 100%");
        frame.add(profilePanel,"width 70%, pos 1al 0 n 100%");
        frame.add(loansPanel,"width 70%, pos 1al 0 n 100%");
        frame.add(fundTransferPanel,"width 70%, pos 1al 0 n 100%");

        accountspanel.setVisible(true);
        profilePanel.setVisible(false);
        depositPanel.setVisible(false);
        loansPanel.setVisible(false);
        fundTransferPanel.setVisible(false);
        frame.setVisible(true);
    }

    public void LogoutButtonActionPerformed(ActionListener listener){
        LogoutButton.addActionListener(listener);
    }


    public void setAddresssButtonActionListener(ActionListener listener){
        profilePanel.getAddressButton().addActionListener(listener);
    }

    public void setUpdateDetailsActionListener(ActionListener listener){
        profilePanel.getUpdateDetailsButton().addActionListener(listener);
    }

    public void setUpdatePasswordActionListener(ActionListener listener){
        profilePanel.getUpdatePasswordButton().addActionListener(listener);
    }

    public void setpinActionListener(ActionListener listener){
        profilePanel.getpinButton().addActionListener(listener);
    }

    public void setDepositbuttonActionListener(ActionListener listener){
            depositPanel.getDepositButton().addActionListener(listener);
    }

    public void setCheckBalanceButtonActionListener(ActionListener listener){
            accountspanel.getCheckBalanceButton().addActionListener(listener);
    }


    public void setFundTransferButtonActionListener(ActionListener listener){
            fundTransferPanel.getTransferFundsButton().addActionListener(listener);
    }
    public void setTransactionHistoryButtonActionListener(ActionListener listener){
            fundTransferPanel.getTransactionHistoryButton().addActionListener(listener);
    }

    public void setApplicationButtonActionListener(ActionListener listener){
            loansPanel.getApplybutton().addActionListener(listener);
    }

    public void setShowLoansButtonActionListener(ActionListener listener){
            loansPanel.getShowLoansButton().addActionListener(listener);
    }

    public LoansPanel getLoansPanel(){
        return loansPanel.getLoanPanel();
    }

    public void setNextPaymentButtonActionListener(ActionListener listener){
            loansPanel.getNextPaymentButton().addActionListener(listener);
    }

    public void setPayLoanButtonActionListener(ActionListener listener){
            loansPanel.getPayLoanButton().addActionListener(listener);
    }

    public NewLoanFrame getNewloanFrame(){
        return loansPanel.getApplicationframe();
    }

    public ProfilePanel getProfilePanel(){
        return profilePanel.getProfilePanel();
    }

    public DepositPanel getDepositPanel(){
        return depositPanel.getDepositPanel();
    }

    public AccountDetailsPanel getAccountspanel(){
        return accountspanel.getAccountsPanel();
    }


    public FundTransferPanel getFundTransferPanel(){
        return fundTransferPanel.getfundtransferpanel();
    }
}

import Model.UserDetails;
import Views.Pages.HomePage;
import Views.Pages.LoginAndRegisterPage;
import services.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    static LoginAndRegisterPage loginAndRegisterPage;
    static HomePage homepage;
    static UserDetails userDetails;
    public static void main(String[] args) {
        setHomepage();
    }
    public static void Loginpage(){
        loginAndRegisterPage = new LoginAndRegisterPage();
        loginAndRegisterPage.gui();
        loginAndRegisterPage.setLoginButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login1 = new Login(loginAndRegisterPage.getpanel());
                if(login1.SetHomePage()){
                    loginAndRegisterPage.frame.dispose();
                    userDetails = Database.setUserDetails(login1.getAccNumber());
                    setHomepage();

                }
            }
        });
        loginAndRegisterPage.setRegisterButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register1 = new Register(loginAndRegisterPage.getpanel());
                if(register1.SetHomePage()){
                    loginAndRegisterPage.frame.dispose();
                    userDetails = Database.setUserDetails(register1.getAccNumber());
                    setHomepage();
                }
            }
        });
    }

    public static void setHomepage(){
        Database.setBalance();
        Database.setpin();
        homepage = new HomePage(userDetails);
        Profile profile = new Profile(homepage.getProfilePanel());
        DepositService depositService = new DepositService(homepage.getDepositPanel(),userDetails);
        FundTransferService fundTransferService =new FundTransferService(homepage.getFundTransferPanel(),userDetails);
        homepage.LogoutButtonActionPerformed(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepage.frame.dispose();
                Loginpage();
            }
        });
        homepage.setAddresssButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(profile.validateAddresss()){
                    Database.setpin();
                    userDetails = Database.GetUserDetails();
                    if(userDetails.Pin == 0) {
                        int pin = random();
                        Database.SetUserPin(pin);
                        JOptionPane.showMessageDialog(homepage.getProfilePanel(), "Address is Set Successfully and your PIN is "+pin);
                    }else{
                        JOptionPane.showMessageDialog(homepage.getProfilePanel(),"Address is Updated Successfully and dumb your pin is "+userDetails.Pin);
                    }
                }
            }
        });

        homepage.setCheckBalanceButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(homepage.getAccountspanel(),"Your Account Balance is "+userDetails.Balance);
            }
        });

        homepage.setDepositbuttonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(depositService.validateDeposit()){
                    Database.UpdateBalance(userDetails.Balance + depositService.AddBalance(),userDetails.AccountNumber);
                    Database.setBalance();
                    JOptionPane.showMessageDialog(homepage.getDepositPanel(),"Amount Deposited Successfully");
                    homepage.getDepositPanel().qrpanel.setVisible(false);
                }
            }
        });


        homepage.setFundTransferButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fundTransferService.validateFundTransfer()){
                    int bal = Database.getReceiverBalance(fundTransferService.getAccNum());
                    Database.UpdateBalance(bal + fundTransferService.getAmount(),fundTransferService.getAccNum());
                    JOptionPane.showMessageDialog(homepage.getFundTransferPanel(),"Amount Transferred Successfully");
                }
            }
        });
    }

    private static int random(){
        Random rand = new Random();
        return (rand.nextInt(9000)+1000);
    }
}
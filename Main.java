
import Model.UserDetails;
import Views.Pages.HomePage;
import Views.Pages.LoginAndRegisterPage;
import services.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Objects;
import java.util.Random;

public class Main {
    static LoginAndRegisterPage loginAndRegisterPage;
    static HomePage homepage;
    static UserDetails userDetails;
    public static void main(String[] args) {
        Loginpage();
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
        NewLoanService newLoanService = new NewLoanService(homepage.getNewloanFrame());
        PaymentService paymentService = new PaymentService(homepage.getLoansPanel(),userDetails);

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
                        JOptionPane.showMessageDialog(homepage.getProfilePanel(), "Address is Set Successfully and your PIN is "+pin);
                        Database.SetUserPin(pin);
                        Database.setpin();
                    }else{
                        JOptionPane.showMessageDialog(homepage.getProfilePanel(),"Address is Updated Successfully");
                    }
                }
            }
        });

        homepage.setUpdateDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(profile.validateUserDetails()) {
                    Database.UpdateUserDetails(profile.getUserDetails());
                    userDetails = Database.setUserDetails(userDetails.AccountNumber);
                    homepage.getAccountspanel().setUserDetails(userDetails);
                    homepage.getAccountspanel().gui();
                    homepage.getAccountspanel().revalidatePanel();
                    JOptionPane.showMessageDialog(homepage.getProfilePanel(), "Details Updated Successfully");
                }
            }
        });

        homepage.setpinActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(profile.validatePinDetails()) {
                    Database.UpdatePinDetails(profile.getPin());
                    Database.setpin();
                    JOptionPane.showMessageDialog(homepage.getProfilePanel(), "Pin Updated Successfully");
                }
            }
        });

        homepage.setUpdatePasswordActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(profile.validatePasswordDetails()) {
                    Database.UpdatePasswordDetails(profile.getPassword());
                    JOptionPane.showMessageDialog(homepage.getProfilePanel(), "Password Updated Successfully");
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
                    Database.insertTransactions(depositService.getTransaction());
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
                    Database.UpdateBalance(userDetails.Balance - fundTransferService.getAmount(),userDetails.AccountNumber);
                    Database.setBalance();
                    Database.insertTransactions(fundTransferService.getTransaction());
                    JOptionPane.showMessageDialog(homepage.getFundTransferPanel(),"Amount Transferred Successfully");
                }
            }
        });

        homepage.setTransactionHistoryButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepage.getFundTransferPanel().showTransactionHistory(Database.getTransactionsByAccountNumber(userDetails.AccountNumber));
            }
        });

        homepage.setApplicationButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(newLoanService.validateApplication()) {
                    Database.InsertLoanDetails(newLoanService.getLoanDetails());
                    JOptionPane.showMessageDialog(homepage.getNewloanFrame(), "Application Submitted Successfully");
                }
            }
        });

        homepage.setShowLoansButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(homepage.getLoansPanel().comboBox.getSelectedIndex() == 0){
                    homepage.getLoansPanel().setHomePanelTable(Database.getLoanDetails((String) homepage.getLoansPanel().comboBox.getSelectedItem()));
                }else if(homepage.getLoansPanel().comboBox.getSelectedIndex() == 1){
                    homepage.getLoansPanel().setVehiclePanelTable(Database.getLoanDetails((String) homepage.getLoansPanel().comboBox.getSelectedItem()));
                }else if(homepage.getLoansPanel().comboBox.getSelectedIndex() == 2){
                    homepage.getLoansPanel().setPersonalPanelTable(Database.getLoanDetails((String) homepage.getLoansPanel().comboBox.getSelectedItem()));
                }
            }
        });

        homepage.setNextPaymentButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(paymentService.validateNext()) {
                    homepage.getLoansPanel().getPayLoanButton().setVisible(true);
                    int res = paymentService.setAmount();
                }
            }
        });
        final boolean[] PaymentDone = {false};
        homepage.setPayLoanButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = paymentService.setAmount();
                if(paymentService.loanActive()){
                    if(paymentService.getLoanDetails().NumofMonthsRemaining > Integer.parseInt((String) Objects.requireNonNull(homepage.getLoansPanel().NoOfMonths.getSelectedItem()))){
                        int num = paymentService.getLoanDetails().NumofMonthsRemaining - Integer.parseInt((String) Objects.requireNonNull(homepage.getLoansPanel().NoOfMonths.getSelectedItem()));
                        if(Database.getReceiverBalance(userDetails.AccountNumber) >= res){
                            Database.insertTransactions(paymentService.getTransaction());
                            Database.UpdateLoanDetails(num,true,paymentService.getLoanDetails().loanID);
                            Database.UpdateBalance((Database.getReceiverBalance(userDetails.AccountNumber) - res),userDetails.AccountNumber);
                            Database.setBalance();
                            PaymentDone[0] = true;
                        }else{
                            JOptionPane.showMessageDialog(homepage.getLoansPanel(),"Insufficient Balance");
                        }
                    }else if(paymentService.getLoanDetails().NumofMonthsRemaining == Integer.parseInt((String) Objects.requireNonNull(homepage.getLoansPanel().NoOfMonths.getSelectedItem()))){
                        if(Database.getReceiverBalance(userDetails.AccountNumber) >= res){
                            Database.insertTransactions(paymentService.getTransaction());
                            Database.UpdateLoanDetails(0,false,paymentService.getLoanDetails().loanID);
                            Database.UpdateBalance(Database.getReceiverBalance(userDetails.AccountNumber) - res,userDetails.AccountNumber);
                            Database.setBalance();
                            PaymentDone[0] = true;
                        }else{
                            JOptionPane.showMessageDialog(homepage.getLoansPanel(),"Insufficient Balance");
                        }
                    }else{
                        JOptionPane.showMessageDialog(homepage.getLoansPanel(),"You have less months remaining than you are trying to pay now");
                    }
                    if(PaymentDone[0]) {
                        JOptionPane.showMessageDialog(homepage.getLoansPanel(), "Payment Completed Successfully");
                    }
                }
                homepage.getLoansPanel().LoanIdText.setText("");
                homepage.getLoansPanel().AmountText.setText("");
                homepage.getLoansPanel().pinText.setText("");
                homepage.getLoansPanel().LoanIdText.setFocusable(true);
            }
        });
    }

    private static int random(){
        Random rand = new Random();
        return (rand.nextInt(9000)+1000);
    }
}
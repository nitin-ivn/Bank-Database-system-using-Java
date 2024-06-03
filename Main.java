import Views.Pages.HomePage;
import Views.Pages.LoginAndRegisterPage;
import services.Login;
import services.Register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static LoginAndRegisterPage loginAndRegisterPage;
    public static void main(String[] args) {
        new HomePage();
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
                    new HomePage();
                }
            }
        });
        loginAndRegisterPage.setRegisterButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register1 = new Register(loginAndRegisterPage.getpanel());
                if(register1.SetHomePage()){
                    loginAndRegisterPage.frame.dispose();
                    new HomePage();
                }
            }
        });
    }
}
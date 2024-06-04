import Model.UserDetails;
import Views.Pages.HomePage;
import Views.Pages.LoginAndRegisterPage;
import services.Database;
import services.Login;
import services.Register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        homepage = new HomePage(userDetails);
        homepage.LogoutButtonActionPerformed(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homepage.frame.dispose();
                Loginpage();
            }
        });
    }
}
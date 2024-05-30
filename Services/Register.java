package Services;
import Views.Componenets.PanelLogin;

import javax.swing.*;

public class Register {
    PanelLogin panelLogin;

    public Register(PanelLogin panelLogin) {
        this.panelLogin = panelLogin;

    }

    public boolean formfilled(){
        if(panelLogin.FirstName.getText().isEmpty()){
            panelLogin.Labelfullname.setText("*Required Field is Empty*");
            return false;
        }


        return true;
    }

    public void SetHomePage(){
        if(formfilled()){
            JOptionPane.showMessageDialog(panelLogin,"Nigga");
        }
    }
}

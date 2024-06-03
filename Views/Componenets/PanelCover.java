package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class PanelCover extends JPanel{
    private final DecimalFormat df = new DecimalFormat("###0.###");
    ImageIcon imageIcon;
    JLabel bankimage;
    private ActionListener event;
    private JButton testing;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    ButtonOutline Signinbutton;
    private boolean isLogin;
    MigLayout layout;

    public PanelCover(){
        layout = new MigLayout("insets 0,wrap,fill");
        setLayout(layout);
        Signinbutton = new ButtonOutline("Sign In",0);
        Signinbutton.addActionListener(this::jbuttonActionPerfored);
        Signinbutton.setFont(new Font("sansserif",Font.BOLD,18));
        Signinbutton.setColor(new Color(71,75,75));
        Signinbutton.setColorOver(Color.WHITE);
        Signinbutton.setBorderColor(Color.WHITE);
        Signinbutton.setBackground(new Color(71,75,75));
        Signinbutton.setForeground(Color.WHITE);
        add(Signinbutton,"width 200, height 45 ,pos 50 430");
//

        title = new JLabel("Welcome To The Bank");
        title.setFont(new Font("sansserif",Font.BOLD,30));
        title.setForeground(new Color(245,245,245));
        add(title,"pos 50 280");

        description = new JLabel("<html>To create a online account u must have a offline account first<br> with known account number.</html>");
        description.setForeground(new Color(245,245,245));
        description.setFont(new Font("sansserif",Font.BOLD,14));
        add(description,"pos 50 330");

        description1 = new JLabel("Already Have a Account?");
        description1.setForeground(new Color(245,245,245));
        description1.setFont(new Font("sansserif",Font.BOLD,14));
        add(description1,"pos 50 400");

        imageIcon = new ImageIcon("Icons/bankimage.png");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        bankimage = new JLabel();
        bankimage.setPreferredSize(new Dimension(200,200));
        bankimage.setIcon(resizedIcon);
        add(bankimage,"pos 150 60");

    }

    private void jbuttonActionPerfored(ActionEvent evt){
        event.actionPerformed(evt);
    }

    protected void paintComponent(Graphics grphics) {
        super.paintComponent(grphics);
        Graphics2D g2 = (Graphics2D) grphics;
        GradientPaint gra = new GradientPaint(0,0,new Color(71,75,75), 0, getHeight(),new Color(71,75,75));
        g2.setPaint(gra);
        g2.fillRect(0,0,getWidth(),getHeight());
    }

    public void addEvent(ActionListener event){
        this.event = event;
    }

    public void registerLeft(double v){
        v = Double.parseDouble(df.format(v));
        login(false);
        layout.setComponentConstraints(title,"pad 0 -"+v+"% 0 0, pos 50 280");
        layout.setComponentConstraints(description,"pad 0 -"+v+"% 0 0, pos 50 330");
        layout.setComponentConstraints(description1,"pad 0 -"+v+"% 0 0, pos 50 400");
    }

    public void registerRight(double v){
        v = Double.parseDouble(df.format(v));
        login(false);
        layout.setComponentConstraints(title,"pad 0 -"+v+"% 0 0, pos 50 280");
        layout.setComponentConstraints(description,"pad 0 -"+v+"% 0 0, pos 50 330");
        layout.setComponentConstraints(description1,"pad 0 -"+v+"% 0 0, pos 50 400");
    }

    public void loginLeft(double v){
        v = Double.parseDouble(df.format(v));
        login(true);
        layout.setComponentConstraints(title,"pad 0 "+v+"% 0 "+v+"%,  pos 50 280");
        layout.setComponentConstraints(description,"pad 0 "+v+"% 0 "+v+"%,  pos 50 330");
        layout.setComponentConstraints(description1,"pad 0 "+v+"% 0 "+v+"%,  pos 50 400");
    }

    public void loginRight(double v){
        v = Double.parseDouble(df.format(v));
        login(true);
        layout.setComponentConstraints(title,"pad 0 "+v+"% 0 "+v+"%, pos 50 280");
        layout.setComponentConstraints(description,"pad 0 "+v+"% 0 "+v+"%,  pos 50 330");
        layout.setComponentConstraints(description1,"pad 0 "+v+"% 0 "+v+"%,  pos 50 400");
    }

    private void login(boolean login){
        if(!login){
            description.setText("<html>To create a online account u must have a offline account first<br> with known account number.</html>");
            description1.setText("Already Have a Account?");
            Signinbutton.setText("Sign In");
        }else{
            description.setText("<html>Welcome Back! Please enter your Account Number<br> and Password to Proceed</html>");
            description1.setText("Not Registered?");
            Signinbutton.setText("Sign Up");
        }
    }
}



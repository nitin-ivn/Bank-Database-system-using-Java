package Views;

import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class View {
    JLayeredPane bg = new JLayeredPane();
    MigLayout layoutforlogin;
    private PanelCover cover;
    private PanelLogin loginRegister;
    private boolean isLogin;
    JFrame frame = new JFrame("Bank");
    private final int coversize = 50;
    private final int loginsize = 50;
    private final int addsize = 30;
    private final DecimalFormat df = new DecimalFormat("##0.###");


    public void LoginAndRegisterPage() {
        bg.setSize(1100,700);
        frame.setContentPane(bg);
        bg.setBackground(Color.WHITE);
        bg.setOpaque(true);
        layoutforlogin = new MigLayout("fill,insets 0");
        frame.setLayout(layoutforlogin);
        cover = new PanelCover();
        loginRegister = new PanelLogin();
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction){
                double fractionCover;
                double fractionLogin;
                double size = coversize;
                if(fraction<= 0.5f){
                    size += fraction*addsize;
                }else{
                    size += addsize - fraction * addsize;
                }
                if(isLogin){
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                }else{
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                }
                fractionCover=Double.valueOf(df.format(fractionCover));
                fractionLogin=Double.valueOf(df.format(fractionLogin));
                layoutforlogin.setComponentConstraints(cover,"width "+size+"%, pos "+fractionCover+"al 0 n 100%");
                layoutforlogin.setComponentConstraints(loginRegister,"width "+loginsize+"%, pos "+fractionLogin+"al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end(){
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(1000, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        frame.setSize(1100, 700);
        frame.add(cover,"width "+coversize+"%, pos 0al 0 n 100%");
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()){
                    animator.start();
                }
            }
        });

        frame.add(loginRegister,"width "+loginsize+"%, pos 1al 0 n 100%");

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class PanelCover extends JPanel{
    private ActionListener event;
    private JButton testing;
    PanelCover(){
        setLayout(new MigLayout("insets 0"));
        testing = new JButton("testing");
        testing.addActionListener(this::jbuttonActionPerfored);


        add(testing,"pos 220 400");
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
}

class PanelLogin extends JLayeredPane{
    JPanel login = new JPanel();
    JPanel register = new JPanel();


    PanelLogin(){
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
    }

    private void initLogin(){

    }
}

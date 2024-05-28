package Views.Pages;
import Views.Componenets.PanelCover;
import Views.Componenets.PanelLogin;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Pages {
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
                if(fraction >= 0.5f){
                    loginRegister.ShowRegister(isLogin);
                }
                fractionCover=Double.parseDouble(df.format(fractionCover));
                fractionLogin=Double.parseDouble(df.format(fractionLogin));
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

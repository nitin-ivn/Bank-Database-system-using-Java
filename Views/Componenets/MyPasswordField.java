package Views.Componenets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

public class MyPasswordField extends JPasswordField {
    private String hint;
    private final Image eye;
    private final Image eye_hide;
    private boolean hide = true;
    public MyPasswordField() {
        setSelectionColor(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = getWidth() - 30;
                if(new Rectangle(x,0,30,30).contains(e.getPoint())){
                    hide = !hide;
                    if(hide){
                        setEchoChar('*');
                    }else{
                        setEchoChar((char) 0);
                    }
                }else{

                }
            }
        });
        eye = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/eye.png"))).getImage();
        eye_hide = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icons/eye_hide.png"))).getImage();
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = getWidth() - 30;
                if(new Rectangle(x,0,30,30).contains(e.getPoint())){
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }else{
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            }
        });
        setFont(new java.awt.Font("sansserif", 0, 13));
        setBorder(new EmptyBorder(10, 12, 15, 30));
        setBackground(new Color(222, 223, 223));
        setForeground(new Color(80, 80, 80));
    }


    public void paint(Graphics g) {
        super.paint(g);
        if (getText().isEmpty()) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(128,128,128));
            g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        super.paintComponent(g);
        createHide(g2);
    }

    private void createHide(Graphics2D g2){
        int x = getWidth() - 30 + 5;
        int y = getHeight() - 30;
        g2.drawImage(hide ? eye_hide : eye, x, y, null);
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
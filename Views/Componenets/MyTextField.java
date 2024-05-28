package Views.Componenets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MyTextField extends JTextField {
    private String hint;
    public MyTextField() {
        setSelectionColor(Color.WHITE);
        setFont(new java.awt.Font("sansserif", Font.PLAIN, 13));
        setBorder(new EmptyBorder(10, 12, 15, 12));
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


    public void setHint(String hint) {
        this.hint = hint;
    }

}
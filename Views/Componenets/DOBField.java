package Views.Componenets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class DOBField extends JFormattedTextField{
    private String hint;
    public DOBField() {
        new SimpleDateFormat("dd/MM/yyyy");
        setSelectionColor(Color.WHITE);
        setFont(new java.awt.Font("sansserif", Font.PLAIN, 13));
        setBorder(new EmptyBorder(10, 12, 15, 12));
        setBackground(new Color(222, 223, 223));
        setForeground(new Color(80, 80, 80));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    e.consume();
                }
            }
        });

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String dobText = getText();
                if (dobText.length() == 8) {
                    StringBuilder formattedText = new StringBuilder(dobText);
                    formattedText.insert(2, '/');
                    formattedText.insert(5, '/');
                    setText(formattedText.toString());
                }
            }
        });
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
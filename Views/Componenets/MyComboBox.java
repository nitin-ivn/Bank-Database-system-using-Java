package Views.Componenets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyComboBox extends JComboBox<String> {
    private String hint;

    public MyComboBox(String[] items) {
        super(items);
        setUI(new MyComboBoxUI());
        setFont(new Font("sansserif", Font.PLAIN, 13));
        setBorder(new EmptyBorder(5, 10, 5, 5));
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    class MyComboBoxUI extends BasicComboBoxUI {
        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            g.setColor(new Color(222, 223, 223));
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        @Override
        protected JButton createArrowButton() {
            JButton customArrowButton = new JButton(new ImageIcon("Icons/arrow.png"));
            customArrowButton.setContentAreaFilled(false);
            customArrowButton.setFocusPainted(false);
            customArrowButton.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); // Restore default arrow button
            return customArrowButton;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getSelectedIndex() == -1) {
            int h = getHeight();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(128, 128, 128));
            g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
}

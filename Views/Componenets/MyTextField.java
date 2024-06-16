package Views.Componenets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
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

    public void setLimit(int limit){
        PlainDocument doc1 = (PlainDocument) MyTextField.this.getDocument();
        doc1.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= limit && string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length <= limit && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

}
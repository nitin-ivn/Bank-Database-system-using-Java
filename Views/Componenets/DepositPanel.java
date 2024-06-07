package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DepositPanel extends JPanel {
    private final Font labelfont = new Font("sansserif", Font.BOLD,10);

    Color bgcolor = new Color(71,75,75);
    JLabel title = new JLabel("Deposit");

    public JLabel amountlabel = new JLabel();
    JLabel Amount = new JLabel("Amount:");
    public MyTextField AmountText = new MyTextField();

    public JLabel pinlabel = new JLabel();
    JLabel Pin = new JLabel("Pin:");
    public MyTextField PinText = new MyTextField();

    MyButton DepositButton = new MyButton("Deposit");

    public DepositPanel(){
        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));

        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,36));
        add(title,"pos 300 40");

        Amount.setForeground(new Color(102, 108, 108));
        Amount.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Amount,"pos 210 125");

        AmountText.setHint("");
        add(AmountText,"width 250,pos 290 120");
        AmountText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        PlainDocument doc = (PlainDocument) AmountText.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= 6 && string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length <= 6 && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        amountlabel.setFont(labelfont);
        amountlabel.setForeground(Color.RED);
        add(amountlabel,"pos 290 160");

        Pin.setForeground(new Color(102, 108, 108));
        Pin.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Pin,"pos 230 185");

        PinText.setHint("");
        add(PinText,"width 250,pos 290 180");
        PinText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        PlainDocument doc1 = (PlainDocument) PinText.getDocument();
        doc1.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= 4 && string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length <= 4 && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        pinlabel.setFont(labelfont);
        pinlabel.setForeground(Color.RED);
        add(pinlabel,"pos 290 220");

        DepositButton.setFont(new Font("sansserif",Font.BOLD,18));
        add(DepositButton,"width 100,height 40,pos 290 250");
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(bgcolor);
        int lineX = title.getX() - 75; // Adjust for the extension on the left
        int lineY = title.getY() + title.getHeight() + 12; // Adjust as needed
        int lineWidth = title.getWidth() + 170; // Adjust for the extension on both sides
        int lineHeight = 2; // Adjust the height of the line as needed
        g.fillRect(lineX, lineY, lineWidth, lineHeight);
    }

    public JButton getDepositButton(){
        return DepositButton;
    }

    public DepositPanel getDepositPanel(){
        return DepositPanel.this;
    }
}

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

public class FundTransferPanel extends JPanel{
    private final Font labelfont = new Font("sansserif", Font.BOLD,10);
    Color bgcolor = new Color(71,75,75);

    JLabel title = new JLabel("Fund Transfers");

    public JLabel Accountlabel = new JLabel();
    JLabel AccountNumber = new JLabel("Account No:");
    public MyTextField AccountNumberText = new MyTextField();

    public JLabel amountlabel = new JLabel();
    JLabel Amount = new JLabel("Amount:");
    public MyTextField AmountText = new MyTextField();

    public JLabel pinlabel = new JLabel();
    JLabel Pin = new JLabel("Pin:");
    public MyTextField PinText = new MyTextField();

    MyButton FundTransferButton = new MyButton("Transfer Funds");
    public FundTransferPanel(){
        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));

        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,36));
        add(title,"pos 270 40");

        AccountNumber.setForeground(new Color(102, 108, 108));
        AccountNumber.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(AccountNumber,"pos 180 125");

        AccountNumberText.setHint("Of the Receiver");
        add(AccountNumberText,"width 250,pos 290 120");
        AccountNumberText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        setLimit(AccountNumberText,12);

        Accountlabel.setFont(labelfont);
        Accountlabel.setForeground(Color.RED);
        add(Accountlabel,"pos 290 160");

        Amount.setForeground(new Color(102, 108, 108));
        Amount.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Amount,"pos 210 185");

        AmountText.setHint("Up to to 6 Digits");
        add(AmountText,"width 250,pos 290 180");
        AmountText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        setLimit(AmountText,6);

        amountlabel.setFont(labelfont);
        amountlabel.setForeground(Color.RED);
        add(amountlabel,"pos 290 220");

        Pin.setForeground(new Color(102, 108, 108));
        Pin.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Pin,"pos 230 250");

        PinText.setHint("4 Digit Pin");
        add(PinText,"width 250,pos 290 245");
        PinText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        setLimit(PinText,4);

        pinlabel.setFont(labelfont);
        pinlabel.setForeground(Color.RED);
        add(pinlabel,"pos 290 285");

        FundTransferButton.setFont(new Font("sansserif",Font.BOLD,18));
        add(FundTransferButton,"width 100,height 40,pos 290 315");
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(bgcolor);
        int lineX = title.getX() - 90; // Adjust for the extension on the left
        int lineY = title.getY() + title.getHeight() + 12; // Adjust as needed
        int lineWidth = title.getWidth() + 170; // Adjust for the extension on both sides
        int lineHeight = 2; // Adjust the height of the line as needed
        g.fillRect(lineX, lineY, lineWidth, lineHeight);
    }

    private void setLimit(JTextField field,int limit){
        PlainDocument doc1 = (PlainDocument) field.getDocument();
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

    public FundTransferPanel getfundtransferpanel(){
        return FundTransferPanel.this;
    }

    public JButton getTransferFundsButton(){
        return FundTransferButton;
    }
}

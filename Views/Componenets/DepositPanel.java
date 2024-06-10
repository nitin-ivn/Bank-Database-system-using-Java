package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    MyButton Next = new MyButton("Next");

    public JPanel qrpanel = new JPanel();

    public DepositPanel(){
        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));

        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,36));
        add(title,"pos 120 40");

        Amount.setForeground(new Color(102, 108, 108));
        Amount.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Amount,"pos 30 125");

        AmountText.setHint("Up to 6 digits");
        add(AmountText,"width 250,pos 115 120");
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
        add(amountlabel,"pos 115 160");


        Next.setFont(new Font("sansserif",Font.BOLD,18));
        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qrpanel.setVisible(true);
            }
        });
        add(Next,"width 100,height 40,pos 450 120");

        qrpanel.setBackground(Color.WHITE);
        qrpanel.setLayout(new MigLayout("fill"));
        add(qrpanel,"width 90%,height 50%,pos 10 230");

        ImageIcon imageIcon = new ImageIcon("Icons/Qr.png");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel bankimage = new JLabel();
        bankimage.setPreferredSize(new Dimension(300,300));
        bankimage.setIcon(resizedIcon);
        qrpanel.add(bankimage,"pos 100 30");

        JLabel text = new JLabel("*Please Scan This QR in any of your payment apps and complete the payment and Click Deposit");
        text.setForeground(bgcolor);
        text.setFont(new Font("sansserif",Font.BOLD,12));
        qrpanel.add(text,"pos 20 350");

        DepositButton.setFont(new Font("sansserif",Font.BOLD,18));
        qrpanel.add(DepositButton,"width 100,height 40,pos 420 250");
        qrpanel.setVisible(false);
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
}

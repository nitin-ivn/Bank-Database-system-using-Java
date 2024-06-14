package Views.Componenets;

import Model.Transactions;
import Model.UserDetails;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FundTransferPanel extends JPanel{
    UserDetails userDetails;

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
    public MyPasswordField PinText = new MyPasswordField();

    MyButton FundTransferButton = new MyButton("Transfer Funds");
    MyButton TransactionHistory = new MyButton("History");

    public FundTransferPanel(UserDetails userDetails){
        this.userDetails = userDetails;

        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));
        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,36));
        add(title,"pos 270 100");

        AccountNumber.setForeground(new Color(102, 108, 108));
        AccountNumber.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(AccountNumber,"pos 180 185");

        AccountNumberText.setHint("Of the Receiver");
        add(AccountNumberText,"width 250,pos 290 180");
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
        add(Accountlabel,"pos 290 220");

        Amount.setForeground(new Color(102, 108, 108));
        Amount.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Amount,"pos 210 245");

        AmountText.setHint("Up to to 6 Digits");
        add(AmountText,"width 250,pos 290 240");
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
        add(amountlabel,"pos 290 280");

        Pin.setForeground(new Color(102, 108, 108));
        Pin.setFont(new Font("sansserif", Font.PLAIN, 20));
        add(Pin,"pos 230 310");

        PinText.setHint("4 Digit Pin");
        add(PinText,"width 250,pos 290 305");
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
        add(pinlabel,"pos 290 345");

        FundTransferButton.setFont(new Font("sansserif",Font.BOLD,18));
        add(FundTransferButton,"width 100,height 40,pos 290 375");

        TransactionHistory.setFont(new Font("sansserif",Font.BOLD,18));
        add(TransactionHistory,"width 100,height 40,pos 10 10");

        JLabel transactionlabel = new JLabel("Transaction History");
        transactionlabel.setForeground(bgcolor);
        transactionlabel.setFont(new Font("sansserif",Font.BOLD,36));

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

    public void showTransactionHistory(List<Transactions> transactionsList) {
        JFrame transactionHistoryFrame = new JFrame("Transaction History");
        transactionHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(titleLabel, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Transaction");
        model.addColumn("Sent From");
        model.addColumn("Sent To");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Amount");
        for (int i = transactionsList.size() - 1; i >= 0; i--) {
            Transactions transactions = transactionsList.get(i);
            if (transactions.receivers_AccountNo == userDetails.AccountNumber && transactions.senders_AccountNo != userDetails.AccountNumber) {
                model.addRow(new Object[]{"Funds Received", transactions.senders_AccountNo, transactions.receivers_AccountNo, transactions.date, transactions.time, "+"+transactions.amount});
            }else if(transactions.receivers_AccountNo == userDetails.AccountNumber){
                model.addRow(new Object[]{"Deposit", transactions.senders_AccountNo, transactions.receivers_AccountNo, transactions.date, transactions.time, "+"+transactions.amount});
            }else{
                model.addRow(new Object[]{transactions.transactionperformed, transactions.senders_AccountNo, transactions.receivers_AccountNo, transactions.date, transactions.time,"-"+ transactions.amount});
            }
        }

//        for (int i = transactionsList.size() - 1; i >= 0; i--) {
//            Transactions transactions = transactionsList.get(i);
//            if (transactions.receivers_AccountNo == userDetails.AccountNumber && transactions.senders_AccountNo != userDetails.AccountNumber) {
//                model.addRow(new Object[]{"Funds Received", transactions.senders_AccountNo, transactions.receivers_AccountNo, transactions.date, transactions.time, transactions.amount});
//            }else{
//                model.addRow(new Object[]{transactions.transactionperformed, transactions.senders_AccountNo, transactions.receivers_AccountNo, transactions.date, transactions.time, transactions.amount});
//            }
//        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        transactionHistoryFrame.add(panel);
        transactionHistoryFrame.pack();
        transactionHistoryFrame.setSize(750,700);
        transactionHistoryFrame.setLocationRelativeTo(null);
        transactionHistoryFrame.setVisible(true);
    }

    public FundTransferPanel getfundtransferpanel(){
        return FundTransferPanel.this;
    }

    public JButton getTransferFundsButton(){
        return FundTransferButton;
    }

    public JButton getTransactionHistoryButton(){
        return TransactionHistory;
    }
}

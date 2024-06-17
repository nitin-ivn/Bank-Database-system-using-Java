package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Objects;

public class NewLoanFrame extends JFrame{
    String[] loans = {"Home Loans","Vehicle Loans","Personal Loans"};
    String[] years = {"5","10","15","20","25"};
    public JLabel title = new JLabel("Application for New Loan");
    private final Color bgcolor = new Color(71,75,75);
    private final Color labelcolor = new Color(102, 108, 108);
    private final Font labelfont = new Font("sansserif", Font.PLAIN, 20);
    private final Font validfont = new Font("sansserif", Font.BOLD,10);

    public JLabel labelloantype = new JLabel();
    public JLabel labelamount = new JLabel();
    public JLabel labelduration = new JLabel();
    public JLabel labelimg = new JLabel();

    public JLabel img = new JLabel("");

    File selectedimg;

    JLabel Loantypelabel = new JLabel("Loan Type  :");
    JLabel loanAmountlabel = new JLabel("Amount     :");
    JLabel Durationlabel = new JLabel("Duration(Years)   :");
    JLabel intrestlabel = new JLabel("Intrest     :");
    JLabel emipermon = new JLabel("EMI per Month :");
    JLabel idenproof = new JLabel("Identity Proof :");

    public MyComboBox LoanType = new MyComboBox(loans);
    public MyTextField loanAmountText = new MyTextField();
    public MyComboBox DurationText = new MyComboBox(years);
    public MyTextField EMItext = new MyTextField();
    public MyTextField IntrestRateText = new MyTextField();
    double Total = 0,yearly =0,monthly =0;
    int index;

    MyButton Applybutton = new MyButton("Apply");
    MyButton idenbutton = new MyButton("Browse");
    public void gui(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));

        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,26));
        add(title,"pos 110 10");

        Loantypelabel.setForeground(labelcolor);
        Loantypelabel.setFont(labelfont);
        add(Loantypelabel,"pos 80 67");

        LoanType.setHint("Select Loan");
        LoanType.setBackground(new Color(222, 223, 223));
        LoanType.setSelectedIndex(-1);
        LoanType.setFocusable(false);
        add(LoanType,"width 250,height 42,pos 210 60");
        LoanType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (LoanType.getSelectedIndex() == 1) {
                        loanAmountText.setText("");
                        index = 1;
                        DurationText.removeAllItems();
                        DurationText.addItem("2");
                        DurationText.addItem("4");
                        DurationText.addItem("6");
                        DurationText.addItem("8");
                    } else if (LoanType.getSelectedIndex() == 2) {
                        DurationText.setSelectedIndex(-1);
                        loanAmountText.setText("");
                        index = 2;
                        DurationText.removeAllItems();
                        DurationText.addItem("2");
                        DurationText.addItem("3");
                        DurationText.addItem("4");
                        DurationText.addItem("5");
                        DurationText.addItem("6");
                        DurationText.addItem("7");
                    } else if (LoanType.getSelectedIndex() == 0) {
                        DurationText.setSelectedIndex(-1);
                        loanAmountText.setText("");
                        index = 0;
                        DurationText.removeAllItems();
                        DurationText.addItem("5");
                        DurationText.addItem("10");
                        DurationText.addItem("15");
                        DurationText.addItem("20");
                        DurationText.addItem("25");
                    }
                }catch (Exception ex){
                    LoanType.setSelectedIndex(index);
                    JOptionPane.showMessageDialog(NewLoanFrame.this, "Please don't change the Loan Type Once you entered the amount");
                }
            }
        });
        index = -1;
        labelloantype.setForeground(Color.RED);
        labelloantype.setFont(validfont);
        add(labelloantype,"pos 215 102");

        loanAmountlabel.setForeground(labelcolor);
        loanAmountlabel.setFont(labelfont);
        add(loanAmountlabel,"pos 90 124");


        loanAmountText.setHint("Amount");
        add(loanAmountText,"width 250,height 40,pos 210 115");
        loanAmountText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if(!Character.isDigit(ch)){
                    e.consume();
                }
            }
        });
        loanAmountText.setLimit(7);

        labelamount.setForeground(Color.RED);
        labelamount.setFont(validfont);
        add(labelamount,"pos 215 157");

        Durationlabel.setForeground(labelcolor);
        Durationlabel.setFont(labelfont);
        add(Durationlabel,"pos 30 179");

        DurationText.setHint("In Years");
        DurationText.setBackground(new Color(222, 223, 223));
        DurationText.setFocusable(false);
        add(DurationText,"width 250,height 42,pos 210 170");
        DurationText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!loanAmountText.getText().isEmpty()) {
                    Total = Integer.parseInt(loanAmountText.getText()) + (Integer.parseInt(loanAmountText.getText()) * 0.12);
                    yearly = Total /Double.parseDouble((String) Objects.requireNonNull(DurationText.getSelectedItem()));
                    DecimalFormat df = new DecimalFormat("0.00");
                    monthly = yearly / 12;
                    EMItext.setText(String.valueOf(df.format(monthly)));
                }
            }
        });

        labelduration.setForeground(Color.RED);
        labelduration.setFont(validfont);
        add(labelduration,"pos 215 212");

        intrestlabel.setForeground(labelcolor);
        intrestlabel.setFont(labelfont);
        add(intrestlabel,"pos 100 229");

        IntrestRateText.setText("12%");
        IntrestRateText.setHint("");
        IntrestRateText.setFocusable(false);
        add(IntrestRateText,"width 250,height 40,pos 210 225");


        emipermon.setForeground(labelcolor);
        emipermon.setFont(labelfont);
        add(emipermon,"pos 50 283");

        EMItext.setHint("EMI per month");
        EMItext.setFocusable(false);
        add(EMItext,"width 250,height 40,pos 210 280");

        idenproof.setForeground(labelcolor);
        idenproof.setFont(labelfont);
        add(idenproof,"pos 60 340");

        img.setBackground(Color.BLACK);
        add(img,"width 200,height 170,pos 150 380");
        Border bf = BorderFactory.createLineBorder(Color.BLACK);
        img.setBorder(bf);

        add(idenbutton,"width 100,height 20,pos 210 340");
        idenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser browseimg = new JFileChooser();
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
                browseimg.addChoosableFileFilter(fileNameExtensionFilter);
                int showopen = browseimg.showOpenDialog(null);

                if(showopen == JFileChooser.APPROVE_OPTION){
                    selectedimg = browseimg.getSelectedFile();
                    String selectedimgpath = selectedimg.getAbsolutePath();
                    ImageIcon img1 = new ImageIcon(selectedimgpath);
                    Image image = img1.getImage().getScaledInstance(img.getWidth(),img.getHeight(),Image.SCALE_SMOOTH);
                    img.setIcon(new ImageIcon(image));
                }
            }
        });

        labelimg.setForeground(Color.RED);
        labelimg.setFont(validfont);
        add(labelimg,"pos 215 365");

        Applybutton.setFont(new Font("sansserif",Font.BOLD,20));
        add(Applybutton,"width 100,height 35,pos 210 570");

        pack();
        setSize(550,700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public NewLoanFrame getApplicationPanel(){
        return NewLoanFrame.this;
    }

    public JButton getApplyButton(){
        return Applybutton;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(bgcolor);
        int lineX = title.getX() - 80; // Adjust for the extension on the left
        int lineY = title.getY() + title.getHeight() + 30; // Adjust as needed
        int lineWidth = title.getWidth() + 170; // Adjust for the extension on both sides
        int lineHeight = 2; // Adjust the height of the line as needed
        g.fillRect(lineX, lineY, lineWidth, lineHeight);
    }

}

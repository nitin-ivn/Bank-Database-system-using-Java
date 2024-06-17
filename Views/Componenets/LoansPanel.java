package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoansPanel extends JPanel{
    String[] loans = {"Home Loans","Vehicle Loans","Personal Loans"};

    private final Font labelfont = new Font("sansserif", Font.BOLD,10);
    Color bgcolor = new Color(71,75,75);
    Font titlefont = new Font("sansserif",Font.BOLD,36);

    JLabel title = new JLabel("Loans");
    NewLoanFrame newLoanFrame = new NewLoanFrame();

    JPanel HomeLoansPanel = new JPanel();
    JPanel VehicleLoansPanel = new JPanel();
    JPanel PersonalLoansPanel = new JPanel();
    JPanel PaymentPanel = new JPanel();

    MyComboBox comboBox = new MyComboBox(loans);
    MyButton showbutton = new MyButton("Show");

    MyButton newloanbutton = new MyButton("Apply");

    public LoansPanel(){
        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));
        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,38));
        add(title,"pos 340 10");

        JLabel homepaneltitle = new JLabel("Home Loans");
        homepaneltitle.setFont(titlefont);
        HomeLoansPanel.setBackground(Color.WHITE);
        HomeLoansPanel.setLayout(new MigLayout("fill"));
        HomeLoansPanel.add(homepaneltitle,"pos 10 10");
        add(HomeLoansPanel,"width 90%,height 40%,pos 40 150");

        JLabel vehicletitle = new JLabel("Vehicle Loans");
        vehicletitle.setFont(titlefont);
        VehicleLoansPanel.setBackground(Color.WHITE);
        VehicleLoansPanel.setLayout(new MigLayout("fill"));
        VehicleLoansPanel.add(vehicletitle,"pos 10 10");
        add(VehicleLoansPanel,"width 90%,height 40%,pos 40 150");

        JLabel personalltitle = new JLabel("Personal Loans");
        personalltitle.setFont(titlefont);
        PersonalLoansPanel.setBackground(Color.WHITE);
        PersonalLoansPanel.setLayout(new MigLayout("fill"));
        PersonalLoansPanel.add(personalltitle,"pos 10 10");
        add(PersonalLoansPanel,"width 90%,height 40%,pos 40 150");

        PaymentPanel.setBackground(Color.BLACK);
        PaymentPanel.setLayout(new MigLayout("fill"));
        add(PaymentPanel,"width 90%,height 30%,pos 40 450");
        PaymentPanel.setVisible(false);

        HomeLoansPanel.setVisible(false);
        VehicleLoansPanel.setVisible(false);
        PersonalLoansPanel.setVisible(false);

        newloanbutton.setFont(new Font("sansserif",Font.BOLD,18));
        add(newloanbutton,"width 100,height 40,pos 10 10");
        newloanbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newLoanFrame.gui();
            }
        });

        comboBox.setHint("Select Loan");
        comboBox.setBackground(new Color(222, 223, 223));
        comboBox.setSelectedIndex(-1);
        comboBox.setFocusable(false);
        add(comboBox,"width 250,height 42,pos 190 90");

        showbutton.setFont(new Font("sansserif",Font.BOLD,18));
        add(showbutton,"width 100,height 40,pos 450 90");
        showbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedIndex() == 0){
                    HomeLoansPanel.setVisible(true);
                    VehicleLoansPanel.setVisible(false);
                    PersonalLoansPanel.setVisible(false);
                }else if(comboBox.getSelectedIndex() == 1){
                    HomeLoansPanel.setVisible(false);
                    VehicleLoansPanel.setVisible(true);
                    PersonalLoansPanel.setVisible(false);
                }else if(comboBox.getSelectedIndex() == 2){
                    HomeLoansPanel.setVisible(false);
                    VehicleLoansPanel.setVisible(false);
                    PersonalLoansPanel.setVisible(true);
                }
            }
        });
    }

    public NewLoanFrame getApplicationframe(){
        return newLoanFrame.getApplicationPanel();
    }

    public JButton getApplybutton(){
        return newLoanFrame.getApplyButton();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(bgcolor);
        int lineX = title.getX() - 80; // Adjust for the extension on the left
        int lineY = title.getY() + title.getHeight() + 12; // Adjust as needed
        int lineWidth = title.getWidth() + 170; // Adjust for the extension on both sides
        int lineHeight = 2; // Adjust the height of the line as needed
        g.fillRect(lineX, lineY, lineWidth, lineHeight);
    }
}

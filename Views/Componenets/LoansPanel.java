package Views.Componenets;

import Model.LoanDetails;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoansPanel extends JPanel{
    String[] loans = {"Home Loans","Vehicle Loans","Personal Loans"};

    private final Font labelfont = new Font("sansserif", Font.BOLD,10);
    Color bgcolor = new Color(71,75,75);
    Font titlefont = new Font("sansserif",Font.BOLD,36);

    JLabel title = new JLabel("Loans");
    NewLoanFrame newLoanFrame = new NewLoanFrame();

    public JPanel HomeLoansPanel = new JPanel();
    public JPanel VehicleLoansPanel = new JPanel();
    public JPanel PersonalLoansPanel = new JPanel();
    public JPanel PaymentPanel = new JPanel();

    public MyTextField LoanIdText = new MyTextField();
    public MyTextField AmountText = new MyTextField();
    public MyPasswordField pinText = new MyPasswordField();

    public MyComboBox comboBox = new MyComboBox(loans);
    MyButton showbutton = new MyButton("Show");

    MyButton Paymentsbutton = new MyButton("Payments");

    MyButton newloanbutton = new MyButton("Apply");

    public LoansPanel() {
        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));
        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif", Font.BOLD, 38));
        add(title, "pos 340 10");

        JLabel homepaneltitle = new JLabel("Home Loans");
        homepaneltitle.setFont(titlefont);
        HomeLoansPanel.setBackground(Color.WHITE);
        HomeLoansPanel.setLayout(new BorderLayout());
        HomeLoansPanel.add(homepaneltitle, BorderLayout.NORTH);
        add(HomeLoansPanel, "width 90%,height 40%,pos 40 150");

        JLabel vehicletitle = new JLabel("Vehicle Loans");
        vehicletitle.setFont(titlefont);
        VehicleLoansPanel.setBackground(Color.WHITE);
        VehicleLoansPanel.setLayout(new BorderLayout());
        VehicleLoansPanel.add(vehicletitle, BorderLayout.NORTH);
        add(VehicleLoansPanel, "width 90%,height 40%,pos 40 150");

        JLabel personalltitle = new JLabel("Personal Loans");
        personalltitle.setFont(titlefont);
        PersonalLoansPanel.setBackground(Color.WHITE);
        PersonalLoansPanel.setLayout(new BorderLayout());
        PersonalLoansPanel.add(personalltitle, BorderLayout.NORTH);
        add(PersonalLoansPanel, "width 90%,height 40%,pos 40 150");

        PaymentPanel.setBackground(Color.WHITE);
        PaymentPanel.setLayout(new MigLayout("fill"));
        add(PaymentPanel, "width 90%,height 30%,pos 40 450");
        PaymentPanel.setVisible(false);

        HomeLoansPanel.setVisible(false);
        VehicleLoansPanel.setVisible(false);
        PersonalLoansPanel.setVisible(false);

        newloanbutton.setFont(new Font("sansserif", Font.BOLD, 18));
        add(newloanbutton, "width 100,height 40,pos 10 10");
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
        add(comboBox, "width 250,height 42,pos 190 90");

        showbutton.setFont(new Font("sansserif", Font.BOLD, 18));
        add(showbutton, "width 100,height 40,pos 450 90");

        Paymentsbutton.setFont(new Font("sansserif",Font.BOLD,18));
        add(Paymentsbutton,"width 100,height 40,pos 600 10");
        Paymentsbutton.setVisible(false);
    }

    public void setHomePanelTable(List<LoanDetails> loanDetails){
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Loan ID");
        model.addColumn("Account Number");
        model.addColumn("Loan");
        model.addColumn("Amount");
        model.addColumn("Duration(Years)");
        model.addColumn("Months Remaining");
        model.addColumn("EMI(M)");
        model.addColumn("Loan Active");
        for(int i=loanDetails.size() - 1;i>=0;i--){
            LoanDetails loanDetails1 = loanDetails.get(i);
            model.addRow(new Object[]{loanDetails1.loanID,loanDetails1.AccountNumber,loanDetails1.TypeofLoan,loanDetails1.loanAmount,loanDetails1.DurationInYears,loanDetails1.NumofMonthsRemaining,loanDetails1.Emi,loanDetails1.loanActive});
        }

        TableColumnModel columnModel = table.getColumnModel();
        int accountNumberColumnIndex = 1;
        int columnWidth = 130;
        columnModel.getColumn(accountNumberColumnIndex).setPreferredWidth(columnWidth);

        JScrollPane scrollPane = new JScrollPane(table);
        HomeLoansPanel.add(scrollPane, BorderLayout.CENTER);



        HomeLoansPanel.setVisible(true);
        PersonalLoansPanel.setVisible(false);
        VehicleLoansPanel.setVisible(false);

    }

    public void setVehiclePanelTable(List<LoanDetails> loanDetails){
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Loan ID");
        model.addColumn("Account Number");
        model.addColumn("Loan");
        model.addColumn("Amount");
        model.addColumn("Duration(Years)");
        model.addColumn("Months Remaining");
        model.addColumn("EMI(M)");
        model.addColumn("Loan Active");
        for(int i=loanDetails.size() - 1;i>=0;i--){
            LoanDetails loanDetails1 = loanDetails.get(i);
            model.addRow(new Object[]{loanDetails1.loanID,loanDetails1.AccountNumber,loanDetails1.TypeofLoan,loanDetails1.loanAmount,loanDetails1.DurationInYears,loanDetails1.NumofMonthsRemaining,loanDetails1.Emi,loanDetails1.loanActive});
        }

        TableColumnModel columnModel = table.getColumnModel();
        int accountNumberColumnIndex = 1;
        int columnWidth = 130;
        columnModel.getColumn(accountNumberColumnIndex).setPreferredWidth(columnWidth);

        JScrollPane scrollPane = new JScrollPane(table);
        VehicleLoansPanel.add(scrollPane, BorderLayout.CENTER);


        HomeLoansPanel.setVisible(false);
        PersonalLoansPanel.setVisible(false);
        VehicleLoansPanel.setVisible(true);

    }

    public void setPersonalPanelTable(List<LoanDetails> loanDetails){
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Loan ID");
        model.addColumn("Account Number");
        model.addColumn("Loan");
        model.addColumn("Amount");
        model.addColumn("Duration(Years)");
        model.addColumn("Months Remaining");
        model.addColumn("EMI(M)");
        model.addColumn("Loan Active");
        for(int i=loanDetails.size() - 1;i>=0;i--){
            LoanDetails loanDetails1 = loanDetails.get(i);
            model.addRow(new Object[]{loanDetails1.loanID,loanDetails1.AccountNumber,loanDetails1.TypeofLoan,loanDetails1.loanAmount,loanDetails1.DurationInYears,loanDetails1.NumofMonthsRemaining,loanDetails1.Emi,loanDetails1.loanActive});
        }

        TableColumnModel columnModel = table.getColumnModel();
        int accountNumberColumnIndex = 1;
        int columnWidth = 130;
        columnModel.getColumn(accountNumberColumnIndex).setPreferredWidth(columnWidth);

        JScrollPane scrollPane = new JScrollPane(table);
        PersonalLoansPanel.add(scrollPane, BorderLayout.CENTER);

        HomeLoansPanel.setVisible(false);
        PersonalLoansPanel.setVisible(true);
        VehicleLoansPanel.setVisible(false);

    }

    public void setPayments(){
        PaymentPanel.setVisible(true);
        LoanIdText.setHint("Loan ID");
        add(LoanIdText,"width 150,pos 10 10");

    }

    public NewLoanFrame getApplicationframe(){
        return newLoanFrame.getApplicationPanel();
    }

    public JButton getApplybutton(){
        return newLoanFrame.getApplyButton();
    }

    public LoansPanel getLoanPanel(){
        return LoansPanel.this;
    }

    public JButton getShowLoansButton(){
        return showbutton;
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

package services;

import Model.LoanDetails;
import Model.UserDetails;
import Views.Componenets.NewLoanFrame;

import java.util.Objects;

public class NewLoanService {
    UserDetails userDetails;
    NewLoanFrame newLoanFrame;

    public NewLoanService(NewLoanFrame newLoanFrame){
        this.newLoanFrame = newLoanFrame;
    }

    public boolean validateApplication(){
        if(formfilled()) {
            if(validateAmount()) {
                return true;
            }
        }
        return false;
    }

    public boolean formfilled(){
        String msg = "*Required Field is Empty";
        if(newLoanFrame.LoanType.getSelectedIndex() == -1){
            newLoanFrame.labelloantype.setText(msg);
            return false;
        }
        if(newLoanFrame.loanAmountText.getText().isEmpty()){
            newLoanFrame.labelloantype.setText("");
            newLoanFrame.labelamount.setText(msg);
            return false;
        }
        if(newLoanFrame.DurationText.getSelectedIndex() == -1){
            newLoanFrame.labelloantype.setText("");
            newLoanFrame.labelamount.setText("");
            newLoanFrame.labelduration.setText(msg);
            return false;
        }
        if(newLoanFrame.img.getIcon() == null){
            newLoanFrame.labelloantype.setText("");
            newLoanFrame.labelamount.setText("");
            newLoanFrame.labelduration.setText("");
            newLoanFrame.labelimg.setText(msg);
            return false;
        }
        newLoanFrame.labelloantype.setText("");
        newLoanFrame.labelamount.setText("");
        newLoanFrame.labelduration.setText("");
        newLoanFrame.labelimg.setText("");
        return true;
    }

    public boolean validateAmount(){
        if(newLoanFrame.LoanType.getSelectedIndex() == 0){
            if(Integer.parseInt(newLoanFrame.loanAmountText.getText()) < 1000000){
                newLoanFrame.labelamount.setText("Enter amount above 10,00,000");
                return false;
            }
            if(Integer.parseInt(newLoanFrame.loanAmountText.getText()) > 9000000){
                newLoanFrame.labelamount.setText("Limit is up to 90,00,000");
                return false;
            }
        }

        if(newLoanFrame.LoanType.getSelectedIndex() == 1){
            if(Integer.parseInt(newLoanFrame.loanAmountText.getText()) < 50000){
                newLoanFrame.labelamount.setText("Enter amount above 50,000");
                return false;
            }
            if(Integer.parseInt(newLoanFrame.loanAmountText.getText()) > 5000000){
                newLoanFrame.labelamount.setText("Limit is up to 50,00,000");
                return false;
            }
        }

        if(newLoanFrame.LoanType.getSelectedIndex() == 2){
            if(Integer.parseInt(newLoanFrame.loanAmountText.getText()) < 50000){
                newLoanFrame.labelamount.setText("Enter amount above 50,000");
                return false;
            }
            if(Integer.parseInt(newLoanFrame.loanAmountText.getText()) > 1000000){
                newLoanFrame.labelamount.setText("Limit is up to 10,00,000");
                return false;
            }
        }
        newLoanFrame.labelamount.setText("");
        return true;
    }

    public LoanDetails getLoanDetails(){
        LoanDetails loanDetails = new LoanDetails();
        loanDetails.TypeofLoan = (String) newLoanFrame.LoanType.getSelectedItem();
        loanDetails.loanAmount = Integer.parseInt(newLoanFrame.loanAmountText.getText());
        loanDetails.DurationInYears = Integer.parseInt(Objects.requireNonNull(newLoanFrame.DurationText.getSelectedItem()).toString());
        loanDetails.IntrestRate = 12;
        loanDetails.Emi = Double.parseDouble(newLoanFrame.EMItext.getText());
        loanDetails.loanActive = true;
        loanDetails.NumofMonthsRemaining = loanDetails.DurationInYears*12;
        return loanDetails;
    }
}

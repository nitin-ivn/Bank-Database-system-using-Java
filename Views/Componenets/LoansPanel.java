package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoansPanel extends JPanel{
    private final Font labelfont = new Font("sansserif", Font.BOLD,10);
    Color bgcolor = new Color(71,75,75);

    JLabel title = new JLabel("Loans");

    MyButton newloanbutton = new MyButton("Apply");

    public LoansPanel(){
        setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));
        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,38));
        add(title,"pos 340 10");

        newloanbutton.setFont(new Font("sansserif",Font.BOLD,18));
        add(newloanbutton,"width 100,height 40,pos 10 10");
        newloanbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewLoanFrame newLoanFrame = new NewLoanFrame();
            }
        });


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

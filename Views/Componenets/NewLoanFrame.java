package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class NewLoanFrame extends JFrame{
    public JLabel title = new JLabel("Application for New Loan");
    Color bgcolor = new Color(71,75,75);


    public NewLoanFrame(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(new MigLayout("fill"));

        title.setForeground(bgcolor);
        title.setFont(new Font("sansserif",Font.BOLD,26));
        add(title,"pos 110 10");

        pack();
        setSize(550,700);
        setLocationRelativeTo(null);
        setVisible(true);
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

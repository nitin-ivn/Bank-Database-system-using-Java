package Views.Componenets;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCover extends JPanel{
    private ActionListener event;
    private JButton testing;

    public PanelCover(){
        setLayout(new MigLayout("insets 0"));
        testing = new JButton("testing");
        testing.addActionListener(this::jbuttonActionPerfored);
        add(testing,"pos 220 400");
    }

    private void jbuttonActionPerfored(ActionEvent evt){
        event.actionPerformed(evt);
    }

    protected void paintComponent(Graphics grphics) {
        super.paintComponent(grphics);
        Graphics2D g2 = (Graphics2D) grphics;
        GradientPaint gra = new GradientPaint(0,0,new Color(71,75,75), 0, getHeight(),new Color(71,75,75));
        g2.setPaint(gra);
        g2.fillRect(0,0,getWidth(),getHeight());
    }

    public void addEvent(ActionListener event){
        this.event = event;
    }
}



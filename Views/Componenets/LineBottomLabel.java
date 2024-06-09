package Views.Componenets;

import javax.swing.*;
import java.awt.*;

public class LineBottomLabel extends JLabel {
    private Color lineColor;

    LineBottomLabel(String text, Color lineColor) {
        super(text);
        this.lineColor = lineColor;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Calculate the starting position for the line
        int lineStartY = getHeight() - 10;

        // Draw the line extending below the label
        g2d.setColor(lineColor);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(-5, lineStartY+10, getWidth()+5, lineStartY + 10);

        g2d.dispose();
    }
}


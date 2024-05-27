package Views.Componenets;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private boolean over;
    private Color colorOver;
    private Color color;
    private Color colorClick;
    private Color borderColor;
    private int radius=0;



    public MyButton(String buttontext) {
        setText(buttontext);
        setColor(color);
        colorOver = new Color(71,75,75);
        colorClick = new Color(54, 56, 56);
        borderColor = new Color(71,75,75);
        setContentAreaFilled(false);
        set
    }

    public void painComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),radius,radius);
        g2.setColor(getBackground());
        g2.fillRoundRect(2,2,getWidth()-4,getHeight()-4,radius,radius);
        super.paintComponent(g);
    }
}

package fr.unice.polytech.si4.complexite.testihm;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import fr.unice.polytech.si4.complexite.Box;

/**
 * @author mmultari
 * @version 27/12/14.
 */

public class Panneau extends JPanel {

private Rectangle2D[][] boxDisplay;
    private Box theBox;

    public Panneau(Box aBox){
        super();
        theBox=aBox;
        boxDisplay=new Rectangle2D[theBox.getWidth()][theBox.getHeight()];
    }


    @Override
    public void paintComponent(Graphics g) {
        //v2(g);
        v1(g);

    }

    private void v1(Graphics g){
        this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        for (int i =0; i<(2*2); i++){
            final JLabel label = new JLabel("Label");
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(label);
        }
    }

    private void v2(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp, gp2, gp3, gp4, gp5, gp6;
        gp = new GradientPaint(0, 0, Color.RED, 20, 0, Color.magenta, true);
        gp2 = new GradientPaint(20, 0, Color.magenta, 40, 0, Color.blue, true);
        gp3 = new GradientPaint(40, 0, Color.blue, 60, 0, Color.green, true);
        gp4 = new GradientPaint(60, 0, Color.green, 80, 0, Color.yellow, true);
        gp5 = new GradientPaint(80, 0, Color.yellow, 100, 0, Color.orange, true);
        gp6 = new GradientPaint(100, 0, Color.orange, 120, 0, Color.red, true);

        g2d.setPaint(gp);
        //x1, y1, width, height
        g2d.fillRect(0, 0, 20, this.getHeight());
        g2d.setPaint(gp2);
        g2d.fillRect(20, 0, 20, this.getHeight());
        g2d.setPaint(gp3);
        g2d.fillRect(40, 0, 20, this.getHeight());
        g2d.setPaint(gp4);
        g2d.fillRect(60, 0, 20, this.getHeight());
        g2d.setPaint(gp5);
        g2d.fillRect(80, 0, 20, this.getHeight());
        g2d.setPaint(gp6);
        g2d.fillRect(100, 0, 40, this.getHeight());

    }
}

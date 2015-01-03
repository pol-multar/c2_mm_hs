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
    private static final int squareLength = 50;

    public Panneau(Box aBox) {
        super();
        theBox = aBox;
        boxDisplay = new Rectangle2D[theBox.getWidth()][theBox.getHeight()];
    }


    @Override
    public void paintComponent(Graphics g) {
        //v2(g);
        v3(g);

    }

    private void v1(Graphics g) {
        this.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        for (int i = 0; i < (2 * 2); i++) {
            final JLabel label = new JLabel("Label");
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(label);
        }
    }

    private void v2(Graphics g) {
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

    private void v3(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        createGraphicBox(g2);
        fillingGraphicBox(g2);

    }

    private void createGraphicBox(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < this.boxDisplay.length; i++) {
            for (int j = 0; j < this.boxDisplay.length; j++) {
                boxDisplay[i][j] = new Rectangle2D.Double(startX, startY, squareLength, squareLength);
                g2.draw(boxDisplay[i][j]);
                startX = startX + squareLength;
            }
            startY = startY + squareLength;
            startX = 0;
        }

    }

    private void fillingGraphicBox(Graphics2D g2){
        g2.setColor(Color.YELLOW);
        g2.fill(boxDisplay[0][0]);
        g2.fill(boxDisplay[0][1]);
        g2.setColor(Color.BLACK);
        g2.fill(boxDisplay[0][2]);
    }
}

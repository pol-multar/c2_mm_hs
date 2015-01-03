package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author mmultari
 * @version 03/01/15.
 */
public class OneBoxView extends JPanel{

    private Rectangle2D[][] boxDisplay;
    private Box theBox;
    private static final int oneSquareLength = 50;
    
    public OneBoxView(Box aBox){
        super();
        theBox = aBox;
        boxDisplay = new Rectangle2D[theBox.getWidth()][theBox.getHeight()];
    }

    @Override
    public void paintComponent(Graphics g) {
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
                boxDisplay[i][j] = new Rectangle2D.Double(startX, startY, oneSquareLength, oneSquareLength);
                g2.draw(boxDisplay[i][j]);
                startX = startX + oneSquareLength;
            }
            startY = startY + oneSquareLength;
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

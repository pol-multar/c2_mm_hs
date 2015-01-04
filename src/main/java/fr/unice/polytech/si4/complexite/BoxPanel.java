package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;

/**
 * The class to display a Box
 *
 * @author Hugo
 * @version 03/01/2015.
 */
public class BoxPanel extends JPanel {
    public static int SQUARE_SIZE = 30;

    /**
     * The constructor of a BoxPanel
     *
     * @param b the box to be displayed
     */
    public BoxPanel(Box b) {
        setLayout(new GridLayout(b.getHeight(), b.getWidth()));
        for (int i = 0; i < b.getHeight(); i++) {
            for (int j = 0; j < b.getWidth(); j++) {
                JPanel squarePane = new JPanel();
                setBorder(squarePane, b, j, i);
                if (b.getId(j, i) != 0) {
                    squarePane.setBackground(IdColorManager.getColor(b.getId(j, i)));
                }
                add(squarePane);
            }
        }
        setPreferredSize(new Dimension(SQUARE_SIZE * b.getWidth(), SQUARE_SIZE * b.getHeight()));
    }

    /**
     * A method to set the border
     *
     * @param p the panel to be modified
     * @param b the box used with the panel
     * @param x the row
     * @param y the colomn
     */
    public void setBorder(JPanel p, Box b, int x, int y) {
        int id = b.getId(x, y);
        p.setBorder(BorderFactory.createMatteBorder(b.getId(x, y - 1) != id ? 1 : 0,
                b.getId(x - 1, y) != id ? 1 : 0,
                b.getId(x, y + 1) != id ? 1 : 0,
                b.getId(x + 1, y) != id ? 1 : 0, Color.BLACK));
    }
}

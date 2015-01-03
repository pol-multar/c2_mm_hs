package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Hugo on 03/01/2015.
 */
public class BoxPanel extends JPanel {
    private final int squareSize = 30;

    public BoxPanel(Box b) {
        setLayout(new GridLayout(b.getHeight(), b.getWidth()));
        for(int i=0; i<b.getHeight(); i++){
            for(int j=0; j<b.getWidth(); j++){
                JPanel squarePane = new JPanel();
                setBorder(squarePane, b, j, i);
                if(b.getId(j, i)!=0) {
                    squarePane.setBackground(IdColorManager.getColor(b.getId(j, i)));
                }
                add(squarePane);
            }
        }
        setPreferredSize(new Dimension(squareSize * b.getWidth(), squareSize * b.getHeight()));
    }

    public void setBorder(JPanel p, Box b, int x, int y){
        int id = b.getId(x, y);
        p.setBorder(BorderFactory.createMatteBorder(b.getId(x, y-1)!=id?1:0,
                b.getId(x-1, y)!=id?1:0,
                b.getId(x, y+1)!=id?1:0,
                b.getId(x+1, y)!=id?1:0, Color.BLACK));
    }
}

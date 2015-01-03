package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Hugo on 03/01/2015.
 */
public class HugoBoxPanel extends JPanel {
    private final int squareSize = 30;

    public HugoBoxPanel(Box b) {
        setLayout(new GridLayout(b.getHeight(), b.getWidth()));
        for(int i=0; i<b.getHeight(); i++){
            for(int j=0; j<b.getWidth(); j++){
                JPanel squarePane = new JPanel();
                setBorder(squarePane, b, j, i);
                if(b.getId(j, i)!=0) {
                    squarePane.setBackground(HugoColorManager.getColor(b.getId(j, i)));
                }
                add(squarePane);
            }
        }
        setPreferredSize(new Dimension(squareSize * b.getWidth(), squareSize * b.getHeight()));
    }

    public void setBorder(JPanel p, Box b, int x, int y){
        p.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
    }
}

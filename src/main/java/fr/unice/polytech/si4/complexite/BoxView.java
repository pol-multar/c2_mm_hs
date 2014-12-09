package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;

/**
 * @author mmultari
 * @version 09/12/14.
 */
public class BoxView extends JPanel{

    Box box;

    public BoxView(Box b){

        box=b;

    }

    public void paintComponent(Graphics g){
        g.drawRect(box.getWidth(), box.getHeight(), 75, 75);
    }
}

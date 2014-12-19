package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;

/**
 * @author mmultari
 * @version 09/12/14.
 */
public class BoxViewDeprec extends JPanel{

    public static final int UNITE=10;

    Box box;

    public BoxViewDeprec(Box b){
        box=b;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public Dimension getPreferredSize(){
        return new Dimension(450,400);
    }

    public void paintComponent(Graphics g){
        g.drawRect(10, 20, UNITE*box.getWidth(), UNITE*box.getHeight());

    }
}

package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mmultari
 * @version 03/01/15.
 */
public class BoxWindow extends JFrame {

    private List<Box> boxes;

    private Map<Integer, Color> colorAssoc;

    private int windowDepth;
    private int windowWidth;

    private String boxNumberLabelString = "Nombre de boites: ";

    private JLabel boxNumberLabel;

    public BoxWindow(List<Box> l,Map<Integer, Color> colors, int depth, int width){
        boxes=l;
        colorAssoc=colors;
        windowDepth=depth;
        windowWidth=width;
        boxNumberLabelString ="Nombre de boites: "+l.size();
        boxNumberLabel = new JLabel(boxNumberLabelString, JLabel.CENTER);
    }

    public void displayWindow(){
        this.setTitle("Rectangle Packing");
        this.setSize(windowDepth, windowWidth);
        Container contents = getContentPane();
        contents.add(boxNumberLabel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //La location X=0,Y=0 commence en haut a gauche
        this.setLocationRelativeTo(null);
        /*contents.add(new OneBoxView(new Box(3, 3)), BorderLayout.CENTER);
        contents.add(new OneBoxView(new Box(4, 4)), BorderLayout.CENTER);*/
        List<OneBoxView> l = new ArrayList<>();
        l.add(new OneBoxView(new Box(3, 3)));
        l.add(new OneBoxView(new Box(4, 4)));
        contents.add(new MultipleBoxView(l));
        this.setVisible(true);
    }


}

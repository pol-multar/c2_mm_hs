package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mmultari
 * @version 09/12/14.
 */
public class BoxViewerDeprec {

    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;

    //400 pixels
    private static final int X_SIZE=800;
//100 pixels
    private static final int Y_SIZE=200;

    //Color used for empty locations.
    public static final Color EMPTY_COLOR = Color.white;

    //Color used for objects that have no defined color.
    public static final Color UNKNOWN_COLOR = Color.gray;

    //List of color usable
    public static final Color COLORTAB[]={Color.black,Color.blue,Color.cyan,Color.darkGray,Color.green,Color.magenta,Color.orange,Color.pink,Color.red,Color.yellow};

    private final String BOX_PREFIX="Boite ";
    private JLabel boxLabel;

    // List of boxes in the field.
    private List<Box> boxes;

    // The current state of the field.
    private Field field;

    //The color - id associations
    private Map<Integer, Color> colors;


    public BoxViewerDeprec(List<Box> l) {
        super();
/*
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        */

        int depth = DEFAULT_DEPTH;
        int width = DEFAULT_WIDTH;

        boxes = new ArrayList<>(l);
        colors = new HashMap<>();

        initColors();

        //setTitle("Projet 2 Complexite : Affichage des boxes");
        //setPreferredSize(new Dimension(X_SIZE, Y_SIZE));

        //setLocationRelativeTo(null);


        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setContentPane(new BoxView(boxes.get(0)));
        //pack();
        //setVisible(true);

    }

    private void initColors() {
        for (Box b : boxes) {
            addColors(b.getIds());
        }

    }

    private void addColors(List<Integer> ids) {
        for(int i=0;i<ids.size();i++){
            colors.put(ids.get(i),COLORTAB[i%COLORTAB.length]);
        }

    }

}

package fr.unice.polytech.si4.complexite;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mmultari
 * @version 19/12/14.
 */
public class BoxViewer {
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 400;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 500;

    // The list of box created.
    private List<Box> boxes;


    //The Frame containing boxes
    private BoxWindow window;

    //Color used for empty locations.
    public static final Color EMPTY_COLOR = Color.white;

    //Color used for objects that have no defined color.
    public static final Color UNKNOWN_COLOR = Color.gray;

    //List of color usable
    private static final Color COLORTAB[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.green, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow};

    //The color - id associations
    private Map<Integer, Color> colors;

    public BoxViewer(List<Box> l) {

        this(l, DEFAULT_DEPTH, DEFAULT_WIDTH);

    }

    public BoxViewer(List<Box> l, int depth, int width) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        boxes = new ArrayList<>(l);
        colors = new HashMap<>();

        //Je remplis la table d'assoc
        initColors();

        //Je crée ma vue
        //window = new BoxView(colors,depth,width);
        window = new BoxWindow(l,colors,depth,width);



        //Je l'affiche
        //launchView();
        window.displayWindow();
        
    }



    private void initColors() {
        for (Box b : boxes) {
            addColors(b.getIds());
        }

    }

    private void addColors(List<Integer> ids) {
        for (int i = 0; i < ids.size(); i++) {
            colors.put(ids.get(i), COLORTAB[i % COLORTAB.length]);
        }

    }

}

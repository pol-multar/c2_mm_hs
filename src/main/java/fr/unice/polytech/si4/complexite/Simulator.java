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
public class Simulator {
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;

    // List of boxes in the field.
    private List<Box> boxes;

    // The current state of the field.
    private Field field;

    private BoxView view;

    //Color used for empty locations.
    public static final Color EMPTY_COLOR = Color.white;

    //Color used for objects that have no defined color.
    public static final Color UNKNOWN_COLOR = Color.gray;

    //List of color usable
    private static final Color COLORTAB[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.green, Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow};

    //The color - id associations
    private Map<Integer, Color> colors;

    public Simulator(List<Box> l) {

        this(l, DEFAULT_DEPTH, DEFAULT_WIDTH);

    }

    public Simulator(List<Box> l, int depth, int width) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        boxes = new ArrayList<>(l);
        field = new Field(depth, width);
        colors = new HashMap<>();

        initColors();

        view = new BoxView(colors,depth,width);

launchView();
        
    }

    private void launchView() {
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

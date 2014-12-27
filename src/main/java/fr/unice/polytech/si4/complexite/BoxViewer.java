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
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;

    // The list of box created.
    private List<Box> boxes;

    //List of ids in the field
    private List<Id> ids;

    // The current state of the field.
    private Field field;

    //The box view
    private BoxView view;

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
        ids = new ArrayList<>();
        field = new Field(depth, width);
        colors = new HashMap<>();

        //Je remplis la table d'assoc
        initColors();

        //Je crée ma vue
        view = new BoxView(colors,depth,width);

        //Je l'affiche
        launchView();
        
    }

    private void launchView() {
        populate();
        updateViews();

    }

    /**
     * Update all existing views.
     */
    private void updateViews() {
        view.showStatus(field);
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

    //TODO correct this
    private void populate(){
        field.clear();

        Box b=boxes.get(0);

        for(int row=0; row<b.getHeight();row++){
            for(int col=0;col<b.getWidth();col++){
                Location location=new Location(row,col);
                Id i= new Id(b.getId(row,col),field,location);
                this.ids.add(i);
            }
        }
    }
}

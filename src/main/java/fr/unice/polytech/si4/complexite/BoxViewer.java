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
public class BoxViewer extends JFrame {

    //Color used for empty locations.
    public static final Color EMPTY_COLOR = Color.white;

    //Color used for objects that have no defined color.
    public static final Color UNKNOWN_COLOR = Color.gray;

    //List of color usable
    public static final Color COLORTAB[]={Color.black,Color.blue,Color.cyan,Color.darkGray,Color.green,Color.magenta,Color.orange,Color.pink,Color.red,Color.yellow};

    private List<Box> boxes;
    private Map<Integer, Color> colors;


    public BoxViewer(List<Box> l) {
        boxes = new ArrayList<>(l);
        colors = new HashMap<>();
        initColors();
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

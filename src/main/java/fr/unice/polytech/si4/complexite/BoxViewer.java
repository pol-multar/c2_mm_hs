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

    //The top-left corner of the new location is specified by the x and y parameters in the coordinate space of this component's parent.
    private static final int X_LOCATION=20;

    private static final int Y_LOCATION=50;

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


    private List<Box> boxes;
    private Map<Integer, Color> colors;


    public BoxViewer(List<Box> l) {
        super();
        boxes = new ArrayList<>(l);
        colors = new HashMap<>();

        initColors();

        setTitle("Projet 2 Complexite : Affichage des boxes");
        setPreferredSize(new Dimension(X_SIZE, Y_SIZE));

        setLocationRelativeTo(null);
        //boxLabel=new JLabel(BOX_PREFIX,JLabel.CENTER);

        //setLocation(X_LOCATION,Y_LOCATION);

        //Container contents = getContentPane();

        //contents.add(boxLabel,BorderLayout.SOUTH);
        //fixer la taille des cases a 10 pixels
        //mettre les deux scrolls bars

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new BoxView(boxes.get(0)));
        pack();
        setVisible(true);

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

package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mmultari
 * @version 03/01/15.
 */
public class MultipleBoxView extends JPanel {

    private List<OneBoxView> theList;

    public MultipleBoxView(List<OneBoxView> aList){
        super();
        theList=new ArrayList<>(aList);
        this.setLayout(new GridLayout(3,2,5, 5));
        for(OneBoxView aView : theList){
            this.add(aView);
        }


    }


}

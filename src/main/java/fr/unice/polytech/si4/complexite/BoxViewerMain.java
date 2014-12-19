package fr.unice.polytech.si4.complexite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmultari
 * @version 09/12/14.
 */
public class BoxViewerMain {
    public static void main(String[] args) {
        List<Box> l=new ArrayList<>();
        Box b = new Box(3,3);
        Rectangle r1 = new Rectangle(2,1);
        try {
            b.putRectangle(r1, 1, 2);
        }catch(ArrayIndexOutOfBoundsException e){}
        l.add(b);
        BoxViewerDeprec viewer= new BoxViewerDeprec(l);
    }
}

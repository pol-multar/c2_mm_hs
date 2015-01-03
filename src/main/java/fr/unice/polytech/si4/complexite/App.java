package fr.unice.polytech.si4.complexite;
import fr.unice.polytech.si4.complexite.testihm.Chronometer;

import javax.swing.*;
import java.util.List;
/**
 * The main of the program
 */
public class App 
{
    public static void main( String[] args )
    {
        // Choose the file
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(new JFrame());
        if(fc.getSelectedFile() == null) return;
        String filename = fc.getSelectedFile().getAbsolutePath();

        // Read the file
        BoxReader br = new BoxReader(filename);
        Box box =br.getBox();
        List<Rectangle> rectangleList = br.getRectangleList();

        // Process
        BoxEngine be = new BoxEngine(box, rectangleList);
        List<Box> boxList = null;
        Chronometer.start();
        try {
            boxList = be.firstFitDecreasingHeightProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Chronometer.stop();
        for(Box b : boxList){
            System.out.println(b);
        }
        new HugoBoxView(boxList, Chronometer.getSeconds());
    }
}

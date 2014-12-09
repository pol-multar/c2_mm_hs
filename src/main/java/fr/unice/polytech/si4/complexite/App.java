package fr.unice.polytech.si4.complexite;
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
        try {
            boxList = be.fastProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Box b : boxList){
            System.out.println(b);
        }
    }
}

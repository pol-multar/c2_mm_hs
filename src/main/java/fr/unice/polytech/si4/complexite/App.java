package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.util.List;

/**
 * The main of the program
 */
public class App {
    public static void main(String[] args) {
        // Choose the file
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(new JFrame());
        if (fc.getSelectedFile() == null) return;
        String filename = fc.getSelectedFile().getAbsolutePath();

        // Read the file
        BoxReader br = new BoxReader(filename);
        Box box = br.getBox();
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
        /*for(Box b : boxList){
            System.out.println(b);
        }*/
        SpinnerNumberModel model = new SpinnerNumberModel(30, //initial value
                1, //min
                100, //max
                1);//step
        JSpinner spinner = new JSpinner(model);
        final JComponent[] inputs = new JComponent[] {
                new JLabel("Taille d'une unité (en pixels)"),
                spinner
        };
        JOptionPane.showMessageDialog(null, inputs, "Choisir l'échelle", JOptionPane.PLAIN_MESSAGE);
        BoxPanel.SQUARE_SIZE = Integer.parseInt(spinner.getValue().toString());

        new MainWindow(boxList, Chronometer.getSeconds());
    }
}

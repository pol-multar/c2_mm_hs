package fr.unice.polytech.si4.complexite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the given file to get information about boxes and rectangles
 */
public class BoxReader {
    private static final String SEPARATOR1 = ",";
    private static final String SEPARATOR2 = "x";

    private Box box = null;
    private List<Rectangle> rectangleList = null;

    /**
     * The constructor of the class. It reads the file and creates box and rectangles
     *
     * @param filePath
     */
    BoxReader(String filePath) {
        BufferedReader in = null;
        rectangleList = new ArrayList<Rectangle>();
        try {
            in = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            String[] split = null;
            if ((line = in.readLine()) != null) {
                split = line.split(SEPARATOR2);
                box = new Box(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
            if ((line = in.readLine()) != null) {
                split = line.split(SEPARATOR1);
                String[] split2 = null;
                for (int i = 0; i < split.length; i++) {
                    split2 = split[i].split(SEPARATOR2);
                    rectangleList.add(new Rectangle(Integer.parseInt(split2[0]), Integer.parseInt(split2[1])));
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Accessor of the box
     *
     * @return the box created
     */
    public Box getBox() {
        return box;
    }

    /**
     * Accessor of the rectangles
     *
     * @return the rectangles created
     */
    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }
}

package fr.unice.polytech.si4.complexite;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Hugo
 * @version 03/01/2015.
 */

/**
 * The class used to generate a color for an id
 */
public abstract class IdColorManager {
    private static Map<Integer, Color> colorsById = new HashMap<Integer, Color>();

    /**
     * Return the color associate to an id
     *
     * @param id the id of a rectangle
     * @return the color associated with the id
     */
    public static Color getColor(int id) {
        if (colorsById.containsKey(id)) {
            return colorsById.get(id);
        }
        Color randomCol;
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        randomCol = new Color(r, g, b);
        colorsById.put(id, randomCol);
        return randomCol;
    }
}

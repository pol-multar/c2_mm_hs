package fr.unice.polytech.si4.complexite;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Hugo on 03/01/2015.
 */
public abstract class IdColorManager {
    private static Map<Integer, Color> colorsById = new HashMap<Integer, Color>();

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

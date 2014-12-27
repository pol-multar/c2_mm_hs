package fr.unice.polytech.si4.complexite;

import java.util.ArrayList;
import java.util.List;

/**
 * Designs the boxes
 */
public class Box {
    private int[][] matrix;
    private List<Integer> ids;


    public Box(int width, int height) {
        matrix = new int[width][height];
        ids = new ArrayList<Integer>();
    }

    private boolean canPutRectangle(Rectangle r, int x, int y) {
        try {
            for (int i = x; i < x + r.getWidth(); i++) {
                for (int j = y; j < y + r.getHeight(); j++) {
                    if (matrix[i][j] != 0) return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean putRectangle(Rectangle r, int x, int y) {
        if(!canPutRectangle(r, x, y))return false;
        ids.add(r.getId());
        for (int i = x; i < x + r.getWidth(); i++) {
            for (int j = y; j < y + r.getHeight(); j++) {
                matrix[i][j] = r.getId();
            }
        }
        return true;
    }

    public int getId(int x, int y) {
        return matrix[x][y];
    }

    public List<Integer> getIds() {
        return ids;
    }

    public int getWidth() {
        return matrix.length;
    }

    public int getHeight() {
        if (getWidth() == 0) return 0;
        return matrix[0].length;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < 2 * getHeight() + 1; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 2 * getWidth() + 1; j++) {
                    if (j % 2 == 0) {
                        res = res.concat("+");
                    } else {
                        res = res.concat("---");
                    }
                }
            } else {
                for (int j = 0; j < 2 * getWidth() + 1; j++) {
                    if (j % 2 == 0) {
                        res = res.concat("|");
                    } else {
                        res = res.concat(" " + matrix[(j - 1) / 2][(i - 1) / 2]) + " ";
                    }
                }
            }
            res = res.concat("\n");
        }

        return res;
    }

}

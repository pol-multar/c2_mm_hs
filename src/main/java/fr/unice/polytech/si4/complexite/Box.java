package fr.unice.polytech.si4.complexite;

import java.util.ArrayList;
import java.util.List;

/**
 * Designs the boxes
 */
public class Box {
    private int[][] matrix;
    private List<Integer> ids;

    /**
     * The Box constructor
     * @param width width of the box
     * @param height height of the box
     */
    public Box(int width, int height) {
        matrix = new int[width][height];
        ids = new ArrayList<Integer>();
    }

    /**
     * Decide if a rectangle r can be place in the box
     * @param r the rectangle to place
     * @param x the row to test
     * @param y the column to test
     * @return true if it can be placed
     */
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

    /**
     * Put the rectangle given in the box
     * @param r the rectangle to place
     * @param x the row
     * @param y the colomn
     * @return true if the rectangle have been placed
     */

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

    /**
     * Return the id place at (x,y) in the box
     * @param x the row
     * @param y the colomn
     * @return an id
     */
    public int getId(int x, int y) {
        try {
            return matrix[x][y];
        }catch (Exception e){
            return -1;
        }
    }

    /**
     * Return of the ids contained in the box
     * @return a list of id
     */
    public List<Integer> getIds() {
        return ids;
    }

    /**
     * Return the width of the box
     * @return
     */
    public int getWidth() {
        return matrix.length;
    }

    /**
     * return the height of the box
     * @return
     */
    public int getHeight() {
        if (getWidth() == 0) return 0;
        return matrix[0].length;
    }

    /**
     * A simple ihm of the box in String
     * @return a String of the box to display in shell
     */
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

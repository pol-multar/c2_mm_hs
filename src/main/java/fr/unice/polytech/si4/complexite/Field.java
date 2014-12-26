package fr.unice.polytech.si4.complexite;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represent a rectangular grid of field positions. Each position is able to
 * store a single id.
 * @author mmultari
 * @version 19/12/14.
 */
public class Field {

    // The depth and width of the field.
    private int depth, width;
    // Storage for the ids content.
    private Object[][] field;

    /**
     * Represent a field of the given dimensions.
     *
     * @param depth
     *            The depth of the field.
     * @param width
     *            The width of the field.
     */

    public Field(int depth, int width) {
        this.depth = depth;
        this.width = width;
        field = new Object[depth][width];
    }

    /**
     * Empty the field.
     */
    public void clear() {
        for (int row = 0; row < depth; row++) {
            for (int col = 0; col < width; col++) {
                field[row][col] = null;
            }
        }
    }

    /**
     * Clear the given location.
     *
     * @param location
     *            The location to clear.
     */
    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    /**
     * Place an id at the given location. If there is already an id at
     * the location it will be lost.
     *
     * @param id
     *            The id of the rectangle to be placed.
     * @param row
     *            Row coordinate of the location.
     * @param col
     *            Column coordinate of the location.
     */
    public void place(Object id, int row, int col) {
        place(id, new Location(row, col));
    }

    /**
     * Place an id at the given location. If there is already an id at
     * the location it will be lost.
     *
     * @param id
     *            The id of the rectangle to be placed.
     * @param location
     *            Where to place the id.
     */
    public void place(Object id, Location location) {
        field[location.getRow()][location.getCol()] = id;
    }

    /**
     * Return the id at the given location, if any.
     *
     * @param location
     *            Where in the field.
     * @return The id at the given location, or null if there is none.
     */
    public Object getObjectAt(Location location) {
        return getObjectAt(location.getRow(), location.getCol());
    }

    /**
     * Return the id at the given location, if any.
     *
     * @param row
     *            The desired row.
     * @param col
     *            The desired column.
     * @return The id at the given location, or null if there is none.
     */
    public Object getObjectAt(int row, int col) {
        return field[row][col];
    }


    /**
     * Return the depth of the field.
     *
     * @return The depth of the field.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Return the width of the field.
     *
     * @return The width of the field.
     */
    public int getWidth() {
        return width;
    }
}

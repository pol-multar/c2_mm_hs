package fr.unice.polytech.si4.complexite;

/**
 * Designs the rectangles
 * A rectangle is represented by :
 * an ID
 * a width
 * a height
 */

public class Rectangle {
    private static int ID = 0;
    private int width;
    private int height;
    private int id;

    /**
     * The constructor of rectangle class
     *
     * @param w the width of the rectangle
     * @param h the height of the rectangle
     */
    Rectangle(int w, int h) {
        width = w;
        height = h;
        id = ++ID;
    }

    /**
     * Return the width of a rectangle
     * @return an int representing the width of a rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Return the height of a rectangle
     * @return an int representing the height of a rectangle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Return the id of a rectangle
     * @return an int representing the id of a rectangle
     */
    public int getId() {
        return id;
    }

    /**
     * Return a String that giving information about the rectangle
     * @return a string representing a rectangle
     */
    public String toString() {
        return id + "=[" + width + ";" + height + "]";
    }
}

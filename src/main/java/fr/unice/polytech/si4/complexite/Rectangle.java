package fr.unice.polytech.si4.complexite;

/**
 * Created by Hugo on 09/12/2014.
 */
public class Rectangle {
    private static int ID = 0;
    private int width;
    private int height;
    private int id;

    Rectangle(int w, int h){
        width = w;
        height = h;
        id = ++ID;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return id+"=["+width+";"+height+"]";
    }
}

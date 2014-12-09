package fr.unice.polytech.si4.complexite;

/**
 * Created by Hugo on 09/12/2014.
 */
public class Box {
    private int[][] matrix;

    Box(int width, int height){
        matrix = new int[width][height];
    }

    public void putRectangle(Rectangle r, int x, int y) throws ArrayIndexOutOfBoundsException{
        for(int i=x; i<x+r.getWidth(); i++){
            for(int j=y; j<y+r.getHeight(); j++){
                matrix[i][j] = r.getId();
            }
        }
    }

    public int getId(int x, int y){
        return matrix[x][y];
    }

    public int getWidth(){
        return matrix.length;
    }

    public int getHeight(){
        if(getWidth() == 0) return 0;
        return matrix[0].length;
    }

    public String toString(){
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
                        res = res.concat(" "+matrix[(j - 1) / 2][(i - 1) / 2])+" ";
                    }
                }
            }
            res = res.concat("\n");
        }

        return res;
    }
}

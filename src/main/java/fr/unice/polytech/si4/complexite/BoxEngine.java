package fr.unice.polytech.si4.complexite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The process
 */
public class BoxEngine {
    private Box box;
    private List<Rectangle> rectangleList;

    BoxEngine(Box b, List<Rectangle> rl){
        box = b;
        rectangleList = rl;
    }

    /**
     * A simple process
     * @return the list of the boxes
     * @throws Exception if it can't be resolved
     */
    List<Box> firstFitDecreasingHeightProcess() throws Exception{
        checkRectanglesSizes();

        sortByWidth();

        List<Box> boxList = new ArrayList<Box>();
        Box b;
        while(!rectangleList.isEmpty()) {
            b = new Box(box.getWidth(), box.getHeight());
            for (int i = 0; i < b.getHeight(); i++) {
                for (int j = 0; j < b.getWidth(); j++) {
                    if (b.getId(j, i) != 0) continue;
                    for (Rectangle r : rectangleList) {
                        if (!b.putRectangle(r, j, i)) continue;
                        rectangleList.remove(r);
                        break;
                    }
                }
            }
            boxList.add(b);
        }
        return boxList;
    }

    private void checkRectanglesSizes() throws Exception {
        for (Rectangle r : rectangleList) {
            if (r.getWidth() > box.getWidth() || r.getHeight() > box.getHeight()){
                throw new Exception("Some rectangles may be larger or higher than the box !");
            }
        }
    }

    private void sortByWidth(){
        Collections.sort(rectangleList, new FirstFitDecreasingHeightComparator());
    }

    class FirstFitDecreasingHeightComparator implements Comparator<Rectangle> {
        @Override
        public int compare(Rectangle a, Rectangle b) {
            if(a.getHeight()>b.getHeight() || (a.getHeight() == b.getHeight() && a.getWidth()>b.getWidth())) {
                return -1;
            }
            if(a.getHeight()==b.getHeight() && a.getWidth() == b.getWidth()){
                return 0;
            }
            return 1;
        }
    }
}

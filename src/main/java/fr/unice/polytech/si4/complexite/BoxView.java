package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * @author mmultari
 * @version 19/12/14.
 */
public class BoxView extends JFrame {

    private FieldView fieldView;
    private Map<Integer, Color> colors;

    public BoxView(Map<Integer, Color> colors, int depth, int width) {
        this.colors = colors;

        setTitle("Rectangle Packing");

        setLocation(20, 50);

        fieldView = new FieldView(depth, width);

        Container contents = getContentPane();

        contents.add(fieldView, BorderLayout.CENTER);

        pack();
        setVisible(true);

    }

    /**
     * @return The color to be used for a given id.
     */
    private Color getColor(int id) {
        Color col = colors.get(id);
        if (col == null) {
            // no color defined for this class
            return Simulator.UNKNOWN_COLOR;
        } else {
            return col;
        }
    }

    public void showStatus(Field field) {
        if (!isVisible()) {
            setVisible(true);
        }
        fieldView.preparePaint();

        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Integer id = (Integer) field.getObjectAt(row, col);
                if (id != null) {
                    fieldView.drawMark(col, row, getColor(id));
                } else {
                    fieldView.drawMark(col, row, Simulator.EMPTY_COLOR);
                }
            }
        }
        fieldView.repaint();

    }

    /**
     * Provide a graphical view of a rectangular field. This is a nested class
     * (a class defined inside a class) which defines a custom component for the
     * user interface. This component displays the field. This is rather
     * advanced GUI stuff - you can ignore this for your project if you like.
     */
    private class FieldView extends JPanel {
        private final int GRID_VIEW_SCALING_FACTOR = 6;

        private int gridWidth, gridHeight;
        private int xScale, yScale;
        Dimension size;
        private Graphics g;
        private Image fieldImage;

        /**
         * Create a new FieldView component.
         */
        public FieldView(int height, int width) {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         */
        public Dimension getPreferredSize() {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                    gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Prepare for a new round of painting. Since the component may be
         * resized, compute the scaling factor again.
         */
        public void preparePaint() {
            if (!size.equals(getSize())) { // if the size has changed...
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if (xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if (yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }

        /**
         * Paint on grid location on this field in a given color.
         */
        public void drawMark(int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale - 1, yScale - 1);
        }

        /**
         * The field view component needs to be redisplayed. Copy the internal
         * image to screen.
         */
        public void paintComponent(Graphics g) {
            if (fieldImage != null) {
                Dimension currentSize = getSize();
                if (size.equals(currentSize)) {
                    g.drawImage(fieldImage, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    g.drawImage(fieldImage, 0, 0, currentSize.width,
                            currentSize.height, null);
                }
            }
        }
    }
}

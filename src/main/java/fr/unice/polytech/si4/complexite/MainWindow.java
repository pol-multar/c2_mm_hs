package fr.unice.polytech.si4.complexite;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Hugo on 03/01/2015.
 */
public class MainWindow extends JFrame {
    public MainWindow(List<Box> l, double time) {
        JPanel infoPane = new JPanel(new GridLayout(2,1));
        infoPane.add(new JLabel("Nombre de boxes : "+l.size()));
        infoPane.add(new JLabel("Nombre de secondes : "+time));
        add(infoPane, BorderLayout.NORTH);
        JPanel boxesPane = new JPanel();
        JScrollPane scrollPane = new JScrollPane(boxesPane);
        add(scrollPane);

        for(Box b : l){
            boxesPane.add(new BoxPanel(b));
        }

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}

package fr.unice.polytech.si4.complexite.testihm;

import javax.swing.*;
import java.awt.*;

import fr.unice.polytech.si4.complexite.Box;

/**
 * @author mmultari
 * @version 27/12/14.
 */
public class Fenetre extends JFrame {

    public Fenetre() {
        v1();
    }

    private void v1() {
        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //La location X=0,Y=0 commence en haut a gauche
        this.setLocationRelativeTo(null);
        //Instanciation d'un objet JPanel
        //JPanel pan = new JPanel();
        //Définition de sa couleur de fond
        //pan.setBackground(Color.ORANGE);
        //On prévient notre JFrame que notre JPanel sera son content pane
        //this.setContentPane(pan);
        this.setContentPane(new Panneau(new Box(3, 3)));
        this.setVisible(true);

    }

    private void v2() {

        this.setTitle("Bouton");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //On définit le layout à utiliser sur le content pane
        //Trois lignes sur deux colonnes
        //this.setLayout(new GridLayout(3, 2));
        GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(3);
        gl.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        gl.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        //Ou en abrégé : GridLayout gl = new GridLayout(3, 2, 5, 5);
        this.setLayout(gl);
        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(new Panneau(new Box(3, 3)));
        this.getContentPane().add(new JButton("2"));
        this.getContentPane().add(new JButton("3"));
        this.getContentPane().add(new JButton("4"));
        this.getContentPane().add(new JButton("5"));
        this.setVisible(true);

    }

    private void v3() {
        this.setTitle("GridBagLayout");
        this.setSize(300, 160);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On crée nos différents conteneurs de couleur différente
        Panneau cell1 = new Panneau(new Box(3,3));
        //cell1.setBackground(Color.YELLOW);
        cell1.setPreferredSize(new Dimension(60, 40));
        JPanel cell2 = new JPanel();
        cell2.setBackground(Color.red);
        cell2.setPreferredSize(new Dimension(60, 40));
        JPanel cell3 = new JPanel();
        cell3.setBackground(Color.green);
        cell3.setPreferredSize(new Dimension(60, 40));
        JPanel cell4 = new JPanel();
        cell4.setBackground(Color.black);
        cell4.setPreferredSize(new Dimension(60, 40));
        JPanel cell5 = new JPanel();
        cell5.setBackground(Color.cyan);
        cell5.setPreferredSize(new Dimension(60, 40));
        JPanel cell6 = new JPanel();
        cell6.setBackground(Color.BLUE);
        cell6.setPreferredSize(new Dimension(60, 40));
        JPanel cell7 = new JPanel();
        cell7.setBackground(Color.orange);
        cell7.setPreferredSize(new Dimension(60, 40));
        JPanel cell8 = new JPanel();
        cell8.setBackground(Color.DARK_GRAY);
        cell8.setPreferredSize(new Dimension(60, 40));

        //Le conteneur principal
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(300, 120));
        content.setBackground(Color.WHITE);
        //On définit le layout manager
        content.setLayout(new GridBagLayout());

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();

        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        content.add(cell1, gbc);
        //---------------------------------------------
        gbc.gridx = 1;
        content.add(cell2, gbc);
        //---------------------------------------------
        gbc.gridx = 2;
        content.add(cell3, gbc);
        //---------------------------------------------
        //Cette instruction informe le layout que c'est une fin de ligne
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 3;
        content.add(cell4, gbc);
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        //Celle-ci indique que la cellule se réplique de façon verticale
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(cell5, gbc);
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridheight = 1;
        //Celle-ci indique que la cellule se réplique de façon horizontale
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell6, gbc);
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        content.add(cell7, gbc);
        //---------------------------------------------
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell8, gbc);
        //---------------------------------------------
        //On ajoute le conteneur
        this.setContentPane(content);
        this.setVisible(true);

    }
}

package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    public Main(){
        this.setTitle("Zipper");
        this.setBounds(275,300,250,250);
        this.setJMenuBar(menuBar);
        Action addAction = new Action("Dodaj", "Dodaj plik do archiwum", " ctrl D", new ImageIcon("dodaj.png"));
        Action removeAction = new Action("Usuń","Usuń plik z archiwum", " ctrl Z", new ImageIcon("usun.png"));
        Action zipAction = new Action("Zipuj", "Stwórz archiwum", "ctrl S");

        JMenu menuFile = menuBar.add(new JMenu("Plik"));
        JMenuItem menuOpen = menuFile.add(addAction);
        JMenuItem menuRemove = menuFile.add(removeAction);
        JMenuItem menuZip = menuFile.add(zipAction);

        list.setBorder(BorderFactory.createEtchedBorder());

        bAdd = new JButton(addAction);
        bRemove = new JButton(removeAction);
        bZip = new JButton(zipAction);
        GroupLayout layout = new GroupLayout(getContentPane());

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(list, 100, 150, Short.MAX_VALUE)
                .addContainerGap(0,Short.MAX_VALUE)
                .addGroup(
                        layout.createParallelGroup()
                        .addComponent(bAdd).addComponent(bRemove).addComponent(bZip)
                )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                .addComponent(list, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,  Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(bAdd)
                        .addComponent(bRemove)
                        .addGap(5, 40, Short.MAX_VALUE)
                        .addComponent(bZip))
        );

        this.getContentPane().setLayout(layout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
    private JList list = new JList();
    private JButton bAdd;
    private JButton bRemove;
    private JButton bZip;
    private JMenuBar menuBar = new JMenuBar();
    public static void main(String[] args) {
    new Main().setVisible(true);
    }
    private class Action extends AbstractAction{

        public Action(String name, String description, String keyShortcut){
            this.putValue(Action.NAME, name);
            this.putValue(Action.SHORT_DESCRIPTION, description);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(keyShortcut));
        }
        public Action(String name, String description, String keyShortcut, Icon icon){
        this(name,description,keyShortcut);
        this.putValue(Action.SMALL_ICON, icon);
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }

    }
}

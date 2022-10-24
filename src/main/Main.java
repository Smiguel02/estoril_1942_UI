package main;   //weird stuff lol

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window= new JFrame();

        //Sets window outlayer parameters
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); //Later change this to true, or not
        window.setTitle("Estoril 1942");

        Game_Panel gamePanel= new Game_Panel();
        window.add(gamePanel);

        window.pack();

        //Window "position" on screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();

    }
}
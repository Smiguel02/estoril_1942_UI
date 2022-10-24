package main;

import javax.swing.JPanel;

import java.awt.*;
import Entitys.*;


public class Game_Panel extends JPanel implements Runnable{ //basically Panel is a subclass of JPanel

    //Screen settings, starting with fixed resolutions
    //lets consider 16:9 monitors
    //Still need to define better sizes
    int screenWidth= 1920/2;    //960
    int screenHeight= 1080/2;   //540
    int FPS=60;

    Thread gameThread;  //Used to keep the game going
    Mouse mouse = new Mouse();  //cant call MouseEvent() because it needs other arguments
    Board board = new Board(this, mouse);

    int x_square=100, y_square=100;
    public Game_Panel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);   //improves game rendering as it is done off screen
        this.addMouseListener(mouse);   //makes mouse assigned to this component
        this.setFocusable(true);        //generates an Interrupt
    }

    public void startGameThread(){
        gameThread = new Thread(this);  //basically when starting a thread I need to appoint it to a certain object/target
        gameThread.start(); //will start game thread and go to run()
    }

    //Main loop
    @Override
    public void run() {
        long loop_time = 1000/FPS;
        long currentTime;
        long lastTime=System.currentTimeMillis();
        long elapsed_time=0;


        while(gameThread!=null){

            //Will add a thing that moves the box to where I click
            //Should work
            currentTime=System.currentTimeMillis();
            elapsed_time=currentTime-lastTime;
            if(elapsed_time>=loop_time) {
                elapsed_time=(currentTime-lastTime)-elapsed_time;
                lastTime=System.currentTimeMillis();

                update();

                repaint();

            }
        }


    }

    public void update(){
        //System.out.println("Running program!");
        board.update();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        board.draw(g2);
        g2.dispose();
    }

}

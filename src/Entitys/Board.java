package Entitys;


import main.Game_Panel;
import main.Mouse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Board extends Entitys{

    Mouse mouse;

    //first initialization stances
    public Board(Game_Panel gp, Mouse mouse){
        x=100;
        y=100;
        width=100;
        height=100;

        //basically I had to do this initialization beacuse I need the pointer to the board.
        this.mouse= mouse;
        this.getBoardImage();
    }

    public void getBoardImage(){
        try {
            //needs to be png
            element = ImageIO.read(getClass().getResourceAsStream("/boards/board_text.png"));   //image is 700x700 bt lets see what happens
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //let's add update and draw to this class, and later we put it in Entitys
    public void update(){
        if(mouse.isPressed){
            x=mouse.x_local;
            y= mouse.y_local;
            System.out.println("x: "+x+"\ty: "+y);
        }
    }

    public void draw(Graphics2D g2){

        //g2.setColor(Color.CYAN);
        //g2.fillRect(x, y, 100, 100);

        //let's add some images to this thing

        g2.drawImage(element, x,y, width, height, null);



    }
}

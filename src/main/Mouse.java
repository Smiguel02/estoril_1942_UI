package main;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//THis is interesting, I think this library is basically an Interrupt, so it is called always "this happens"
public class Mouse implements MouseListener {


    private void mousePosition(MouseEvent e){
        x_local=e.getX();
        y_local=e.getY();
        //System.out.println("x: "+x_local+"\ty: "+y_local);
    }

    //Might need to later change this to private and call this as a function
    public int x_local, y_local;
    boolean isInside;
    public boolean isPressed;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //should also add, "is BUTTON1"
        if(isInside){
            mousePosition(e);
            isPressed=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(isInside){
            isPressed=false;
        }

    }

    @Override
    //here we will read x,y position
    public void mouseEntered(MouseEvent e) {
        isInside=true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isInside=false;
    }
}

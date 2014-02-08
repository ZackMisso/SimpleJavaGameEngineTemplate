// This code was written by Firal Studios
// Head and only Dev: Zackary Misso
// This project is an example of my simple Java Engine
// which is free for public used on my (Zack Misso) gitHub.
// This was also developed to help teach the students at Cedar
// Park High basic programming. Hope this code helps to anyone
// who uses it.

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MousepadListener implements MouseListener{
	private int mouseX,mouseY; // the coordinates of the mouse
	private boolean clicked; // if the mouse is being clicked
	
	public MousepadListener(){
		mouseX=mouseY=0;
		clicked=false;
	}
	
    @Override
	// what happens when the mouse is clicked
	public void mouseClicked(MouseEvent event){
		mouseX=event.getX();
		mouseY=event.getY();
		clicked=true;
	}
	
    @Override
	// what happens when the mouse enters the screen
	public void mouseEntered(MouseEvent event){
		// does nothing
	}
	
    @Override
	// what happens when the mouse exits the screen
	public void mouseExited(MouseEvent event){
		// does nothing
	}
	
	@Override
	// what happens when the mouse is pressed
	public void mousePressed(MouseEvent event){
		mouseClicked(event);
	}
	
	@Override
	// what happens when the mouse is released
	public void mouseReleased(MouseEvent event){
		clicked=false;
	}
	
	// returns true if the mouse is pressed
	public boolean isMousePressed(){return clicked;}
	// returns the x position of the mouse
	public int getX(){return mouseX;}
	// returns the y position of the mouse
	public int getY(){return mouseY;}
}
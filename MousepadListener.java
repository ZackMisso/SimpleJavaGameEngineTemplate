// Simple Java Game Engine Template
// Created by Zackary (Firal) Misso
// This code is free to use

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MousepadListener implements MouseListener{
	private int mouseX,mouseY; // the coordinates of the mouse
	private boolean clicked; // if the mouse is being clicked
	
	public MousepadListener(){
		mouseX=mouseY=0;
		clicked=false;
	}
	
	// what happens when the mouse is clicked
	public void mouseClicked(MouseEvent event){
		mouseX=event.getX();
		mouseY=event.getY();
		clicked=true;
	}
	
	// what happens when the mouse enters the screen
	public void mouseEntered(MouseEvent event){
		// does nothing
	}
	
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
	
	// toString method included for the testing system
	public String toString(){
		return "";
		// implement
	}
	
	// returns true if the mouse is pressed
	public boolean isMousePressed(){return clicked;}
	// returns the x position of the mouse
	public int getX(){return mouseX;}
	// returns the y position of the mouse
	public int getY(){return mouseY;}
}
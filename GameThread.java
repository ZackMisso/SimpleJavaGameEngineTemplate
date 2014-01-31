// Simple Java Game Engine Template
// Created by Zackary (Firal) Misso
// This code is free to use

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awr.image.BufferedImage;
public class GameThread extends JPanel implements Runnable{
	private final Game game; // a reference to the main Game
	// implement high level game objects such as physics engines (maybe a future add)

	public GameThread(Game param){
		game=param;
	}

	// the update Loop
	public void update(){
		try{
			// update Game agents
		}catch(Exception e){Sytem.out.println("There was a system failure");}
		// ^ happens if there is an eror in the thread (Will probably never happen)
	}

	// the draw Loop
	public void draw(Graphics g){
		super.paint(g);
		BufferedImage backBuffer=new BufferedImage(640,480,BufferedImage.TYPE_INT_RBG);
		Graphics g2=backBuffer.getGraphics();
		//g2.drawImage(...);
		// draw your images onto the buffer
		// the below two lines should ALWAYS go last
		g.drawImage(backBuffer,0,0,game.getWindow());
		g2.dispose();
	}

	// the Main Loop
	public void run(){
		boolean running=true;
		long lastTime=System.nanoTime();
		double nsPerTick=1000000000D/60D;
		int ticks=0;
		int frames=0;
		long lastTimer=System.currentTimeMillis();
		double delta=0;
		while(running){
			long now=System.nanoTime();
			delta+=(now-lastTime)/nsPerTick;
			lastTime=now;
			boolean shouldRender=false;
			while(delta>=1){
				ticks++;
				update();
				delta-=1;
				shouldRender=true;
			}
			if(shouldRender){
				frames++;
				paint(game.getWindow().getGraphics());
			}
			if(System.currentTimeMillis()-lastTimer>=1000){
				lastTimer+=1000;
				// Uncomment the code below to print out the games ticks and frame rate
				//System.out.println("FPS :: "+ticks+" ticks, "+frames+" frames");
				frames=0;
				ticks=0;
			}
		}
	}

	// getter methods
	public Game getGame(){return game;}
}
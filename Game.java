// Simple Java Game Engine Template
// Created by Zackary (Firal) Misso
// This code is free to use

import javax.swing.JFrame
public class Game{
	private final JFrame window; // the window for the game
	private final GameThread gameThread; // the game thread
	private final KeyboardListener keyListener; // reads key input
	private final MousepadListener mouseListener; // reads mouse input

	public Game(int x,int y,String title){
		window=new Frame();
		window.setSize(x,y);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(title);
		window.setVisible(true);
		gameThread=new GameThread(this);
		keyListener=new KeyBoardListener();
		mouseListener=new MousepadListener();
		window.add(gameThread);
		window.addKeyListener(keyListener);
		window.addMouseListener(mouseListener);
		new Thread(gameThread).start();
	}

	// getter methods
	public JFame getWindow(){return window;}
	public KeyboardListener getKeyListener(){return keyListener;}
	public MousepadListener getMouseListener(){return mouseListener;}
	public GameThread getGameThread(){return gameThread;}
}
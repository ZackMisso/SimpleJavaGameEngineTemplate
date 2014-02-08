// This code was written by Firal Studios
// Head and only Dev: Zackary Misso
// This project is an example of my simple Java Engine
// which is free for public used on my (Zack Misso) gitHub.
// This was also developed to help teach the students at Cedar
// Park High basic programming. Hope this code helps to anyone
// who uses it.

import javax.swing.JFrame;
public class Game{
	private final JFrame window; // the window for the game
	private final GameThread gameThread; // the game thread
	private final KeyboardListener keyListener; // reads key input
	private final MousepadListener mouseListener; // reads mouse input

	public Game(int x,int y,String title){
		window=new JFrame();
		window.setSize(x,y);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(title);
		window.setVisible(true);
		gameThread=new GameThread(this);
		keyListener=new KeyboardListener();
		mouseListener=new MousepadListener();
		window.add(gameThread);
		window.addKeyListener(keyListener);
		window.addMouseListener(mouseListener);
		new Thread(gameThread).start();
	}
    
    @Override
    public String toString(){
        return "Game was made.... Good Luck";
    }

	// getter methods
	public JFrame getWindow(){return window;}
	public KeyboardListener getKeyListener(){return keyListener;}
	public MousepadListener getMouseListener(){return mouseListener;}
	public GameThread getGameThread(){return gameThread;}
}
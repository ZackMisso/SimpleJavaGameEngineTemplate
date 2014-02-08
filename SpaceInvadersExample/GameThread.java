// This code was written by Firal Studios
// Head and only Dev: Zackary Misso
// This project is an example of my simple Java Engine
// which is free for public used on my (Zack Misso) gitHub.
// This was also developed to help teach the students at Cedar
// Park High basic programming. Hope this code helps to anyone
// who uses it.

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;
public class GameThread extends JPanel implements Runnable{
    private final Game game;
	private final ArrayList<Enemy> enemies;
	private final ArrayList<Enemy_Bullet> ebullets;
	private final ArrayList<Player_Bullet> pbullets;
	private final Player player;

	public GameThread(Game param){
		game=param;
		enemies=new ArrayList<Enemy>();
		ebullets = new ArrayList<Enemy_Bullet>();
		pbullets = new ArrayList<Player_Bullet>();
        player = new Player(this);
		for(int i=32;i<450;i+=40){
            for(int f=40;f<130;f+=40){
                Enemy e = new Enemy(this);
                e.setYpos(f);
                e.setXpos(i);
                e.setWidth(32);
                e.setHeight(32);
                enemies.add(e);
            }
		}
	}

	// the update Loop
	public void update(){
		try{
            for(int i=0;i<enemies.size();i++)
                if(enemies.get(i).update())
                    enemies.remove(i--);
            for(Player_Bullet obj:pbullets)
                obj.update();
            for(Enemy_Bullet obj:ebullets)
                obj.update();
            if(player.update()||enemies.isEmpty())
                System.exit(0);
		}catch(Exception e){System.out.println("There was a system failure");}
		// ^ happens if there is an eror in the thread (Will probably never happen)
	}

	// the draw Loop
	public void paint(Graphics g){
		super.paint(g);
		BufferedImage backBuffer=new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
		Graphics g2=backBuffer.getGraphics();
		// draw enemies
        g2.setColor(Color.RED);
		for(Enemy obj : enemies)
			g2.drawRect(obj.getXpos(),obj.getYpos(),obj.getWidth(),obj.getHeight());
        // draw player's bullets
        g2.setColor(Color.YELLOW);
		for(Player_Bullet obj : pbullets)
			g2.drawRect(obj.getXpos(),obj.getYpos(),obj.getWidth(),obj.getHeight());
		// draw enemy bullets
        g2.setColor(Color.ORANGE);
		for(Enemy_Bullet obj : ebullets)
			g2.drawRect(obj.getXpos(),obj.getYpos(),obj.getWidth(),obj.getHeight());
        // draw player
        g2.setColor(Color.BLUE);
        g2.drawRect(player.getXpos(),player.getYpos(),player.getWidth(),player.getHeight());
		// draw your images onto the buffer
		// the below two lines should ALWAYS go last
		g.drawImage(backBuffer,0,0,game.getWindow());
		g2.dispose();
	}

	// the Main Loop (you can ignore this)
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
	public Game getReference(){return game;}
    public Player getPlayer(){return player;}
    public ArrayList<Player_Bullet> getPlayerBullets(){return pbullets;}
    public ArrayList<Enemy_Bullet> getEnemyBullets(){return ebullets;}
}
// This code was written by Firal Studios
// Head and only Dev: Zackary Misso
// This project is an example of my simple Java Engine
// which is free for public used on my (Zack Misso) gitHub.
// This was also developed to help teach the students at Cedar
// Park High basic programming. Hope this code helps to anyone
// who uses it.

import java.util.ArrayList;
public class Enemy extends GameEntity{
	private int counter;

    public Enemy(GameThread param){
        super(param);
    }

    public boolean update(){
    	counter++;
    	if(counter%100==0)
    		setYpos(getYpos()+1);
        int num=(int)(Math.random()*500);
        if(num>497){ // change this number to make it harder
            Enemy_Bullet temp=new Enemy_Bullet(getReference());
            temp.setWidth(5);
            temp.setHeight(12);
            temp.setXpos(getXpos()+15);
            temp.setYpos(getYpos());
            getReference().getEnemyBullets().add(temp);
        }
        return checkForCollision();
    }
    
    public boolean checkForCollision(){
        ArrayList<Player_Bullet> pbullets=getReference().getPlayerBullets();
        for(int i=0;i<pbullets.size();i++){
            if(pbullets.get(i).getRect().intersects(getRect())){
                pbullets.remove(i);
                return true;
            }
        }
        return false;
    }
}
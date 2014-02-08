// This code was written by Firal Studios
// Head and only Dev: Zackary Misso
// This project is an example of my simple Java Engine
// which is free for public used on my (Zack Misso) gitHub.
// This was also developed to help teach the students at Cedar
// Park High basic programming. Hope this code helps to anyone
// who uses it.

import java.util.ArrayList;
public class Player extends GameEntity{
    private int shoot_counter;

    public Player(GameThread param){
        super(param);
        setXpos(0);
        setYpos(400);
        setWidth(32);
        setHeight(32);
        shoot_counter=0;
    }

    @Override
    public boolean update(){
        shoot_counter++;
        if(getReference().getReference().getKeyListener().isKeyPressed(65)){
            // move left
            if(getXpos()>10)
                setXpos(getXpos()-3);
        }
        if(getReference().getReference().getKeyListener().isKeyPressed(68)){
            // move right
            if(getXpos()<460)
                setXpos(getXpos()+3);
        }
        if(getReference().getReference().getKeyListener().isKeyPressed(32)){
            // shoot
            if(shoot_counter>50){
                Player_Bullet temp=new Player_Bullet(getReference());
                temp.setWidth(5);
                temp.setHeight(12);
                temp.setXpos(getXpos()+15);
                temp.setYpos(getYpos());
                getReference().getPlayerBullets().add(temp);
                shoot_counter=0;
            }
        }
        return checkForCollision();
    }
    
    public boolean checkForCollision(){
        ArrayList<Enemy_Bullet> ebullets=getReference().getEnemyBullets();
        for(int i=0;i<ebullets.size();i++){
            if(ebullets.get(i).getRect().intersects(getRect())){
                ebullets.remove(i);
                return true;
            }
        }
        return false;
    }
}
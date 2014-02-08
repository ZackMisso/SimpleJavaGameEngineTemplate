// This code was written by Firal Studios
// Head and only Dev: Zackary Misso
// This project is an example of my simple Java Engine
// which is free for public used on my (Zack Misso) gitHub.
// This was also developed to help teach the students at Cedar
// Park High basic programming. Hope this code helps to anyone
// who uses it.

public class Player_Bullet extends GameEntity{

    public Player_Bullet(GameThread param){
        super(param);
    }

    @Override
    public boolean update(){
    	setYpos(getYpos()-5);
        return false;
    }
}
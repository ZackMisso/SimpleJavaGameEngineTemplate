// This code was written by Firal Studios
// Head and only Dev: Zackary Misso
// This project is an example of my simple Java Engine
// which is free for public used on my (Zack Misso) gitHub.
// This was also developed to help teach the students at Cedar
// Park High basic programming. Hope this code helps to anyone
// who uses it.

import java.awt.Rectangle;
public abstract class GameEntity{
    private final GameThread reference;
    private final Rectangle rigidBody;
    
    public GameEntity(GameThread param){
        reference=param;
        rigidBody=new Rectangle(0,0,0,0);
    }
    
    public abstract boolean update();
    
    public int getXpos(){
        return (int)rigidBody.getX();
    }
    
    public int getYpos(){
        return (int)rigidBody.getY();
    }
    
    public int getWidth(){
        return (int)rigidBody.getWidth();
    }
    
    public int getHeight(){
        return (int)rigidBody.getHeight();
    }
    
    public void setXpos(int param){
        rigidBody.setLocation(param,(int)rigidBody.getY());
    }
    
    public void setYpos(int param){
        rigidBody.setLocation((int)rigidBody.getX(),param);
    }
    
    public void setWidth(int param){
        rigidBody.setSize(param,(int)rigidBody.getHeight());
    }
    
    public void setHeight(int param){
        rigidBody.setSize((int)rigidBody.getWidth(),param);
    }

    public GameThread getReference(){return reference;}
    public Rectangle getRect(){return rigidBody;}
}

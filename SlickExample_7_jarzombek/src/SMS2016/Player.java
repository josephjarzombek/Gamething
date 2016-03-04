/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS2016;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author josephjarzombek
 */
public class Player {
    public float x = 96f;
    public float y = 228f;
    public int health = 200;
    public float speed = .5f;
    int counter =0;
    float hitboxX = x + 8f;
    float hitboxY = y + 8f;
    private int startX, startY, width = 30, height = 42;
    public Shape rect = new Rectangle(getplayershitboxX(),
            getplayershitboxY(), width, height);
    public float pdelta;
    public Animation Playeranime, up, down, left, right, sprite, wait;
    private int direction; 
   
    public Player() throws SlickException {
        SpriteSheet runningSS = new SpriteSheet(
                "res/mom.png", 64, 64, 0);
        up = new Animation();
        up.setAutoUpdate(true);
        up.addFrame(runningSS.getSprite(0, 8), 100);
        up.addFrame(runningSS.getSprite(1, 8), 100);
        up.addFrame(runningSS.getSprite(2, 8), 100);
        up.addFrame(runningSS.getSprite(3, 8), 100);
        up.addFrame(runningSS.getSprite(4, 8), 100);
        up.addFrame(runningSS.getSprite(5, 8), 100);
        up.addFrame(runningSS.getSprite(6, 8), 100);
        up.addFrame(runningSS.getSprite(7, 8), 100);
        up.addFrame(runningSS.getSprite(8, 8), 100);

        down = new Animation();
        down.setAutoUpdate(false);
        down.addFrame(runningSS.getSprite(0, 10), 100);
        down.addFrame(runningSS.getSprite(1, 10), 100);
        down.addFrame(runningSS.getSprite(2, 10), 100);
        down.addFrame(runningSS.getSprite(3, 10), 100);
        down.addFrame(runningSS.getSprite(4, 10), 100);
        down.addFrame(runningSS.getSprite(5, 10), 100);
        down.addFrame(runningSS.getSprite(6, 10), 100);
        down.addFrame(runningSS.getSprite(7, 10), 100);
        down.addFrame(runningSS.getSprite(8, 10), 100);

        left = new Animation();
        left.setAutoUpdate(false);
        left.addFrame(runningSS.getSprite(0, 9), 100);
        left.addFrame(runningSS.getSprite(1, 9), 100);
        left.addFrame(runningSS.getSprite(2, 9), 100);
        left.addFrame(runningSS.getSprite(3, 9), 100);
        left.addFrame(runningSS.getSprite(4, 9), 100);
        left.addFrame(runningSS.getSprite(5, 9), 100);
        left.addFrame(runningSS.getSprite(6, 9), 100);
        left.addFrame(runningSS.getSprite(7, 9), 100);
        left.addFrame(runningSS.getSprite(8, 9), 100);

        right = new Animation();
        right.setAutoUpdate(false);
        right.addFrame(runningSS.getSprite(0, 11), 100);
        right.addFrame(runningSS.getSprite(1, 11), 100);
        right.addFrame(runningSS.getSprite(2, 11), 100);
        right.addFrame(runningSS.getSprite(3, 11), 100);
        right.addFrame(runningSS.getSprite(4, 11), 100);
        right.addFrame(runningSS.getSprite(5, 11), 100);
        right.addFrame(runningSS.getSprite(6, 11), 100);
        right.addFrame(runningSS.getSprite(7, 11), 100);
        right.addFrame(runningSS.getSprite(8, 11), 100);

        wait = new Animation();
        wait.setAutoUpdate(true);
        wait.addFrame(runningSS.getSprite(0, 14), 733);
        wait.addFrame(runningSS.getSprite(1, 14), 733);
        wait.addFrame(runningSS.getSprite(2, 14), 733);
        wait.addFrame(runningSS.getSprite(3, 14), 733);
        sprite = wait;

    }

    
    public void setpdelta(float somenum) {
        pdelta = somenum;
    }

    public float getpdelta() {
        return pdelta;
    }

    public float getplayersX() {
        return x;
    }

    public float getplayersY() {
        return y;
    }

    public float getplayershitboxX() {
        return x + 18f;
    }

    public float getplayershitboxY() {
        return y + 18f;
    }

    public void setplayershitboxX() {
        hitboxX = getplayershitboxX();
    }

    public void setplayershitboxY() {
        hitboxY = getplayershitboxY();
    }
    
    public void setDirection(int i){
        this.direction = i;
    }
    public int getDirection(){
        return this.direction;
    }

}
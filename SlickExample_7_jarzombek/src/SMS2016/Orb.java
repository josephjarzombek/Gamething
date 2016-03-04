/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS2016;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author josephjarzombek
 */
public class Orb {
    private int locationx;
    private int locationy;
    private int hitboxx;
    private int hitboxy;
    private int size;
    private boolean isVisible;
    Image orbpic;
    Shape hitbox; 
    private int direction;
    private int timeExists;
    public Orb(int x, int y) throws SlickException{
        this.isVisible = false;
        this.locationx = x;
        this.locationy = y;
        this.orbpic = new Image ("res/bullet.png");
        this.hitbox = new Rectangle (x,y,16,24);
    }
       public void settimeExists(int t){
        this.timeExists = t;
    }
        public void countdown(){
        this.timeExists--;
    }
    
    public int gettimeExists(){
        
        return this.timeExists;
    }
    
    public Image getOrbpic(){
        return orbpic;
    }

    public int getHitboxx() {
        return hitboxx;
    }

    public void setHitboxx(int hitboxx) {
        this.hitboxx = hitboxx;
    }

    public int getHitboxy() {
        return hitboxy;
    }

    public void setHitboxy(int hitboxy) {
        this.hitboxy = hitboxy;
    }
    public void setOrb(Image orbpic) {
        this.orbpic=orbpic;
    }

    public Shape getHitbox() {
        return hitbox;
    }
    
    public void setHitbox(Shape hitbox) {
        this.hitbox = hitbox;
    }

    public int getLocationx() {
        return locationx;
    }

    public void setLocationx(int locationx) {
        this.locationx = locationx;
    }

    public int getLocationy() {
        return locationy;
    }

    public void setLocationy(int locationy) {
        this.locationy = locationy;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    public void setLocation(int a, int b, Player player) {
        this.setLocationx((int)player.x);
        this.setLocationy((int)player.y);
        this.setHitboxx((int)player.x + 5);
        this.setHitboxy((int)player.y - 10);
    }

    /**
     * Getters and setters are a common concept in Java.
     * A design guideline in Java, and object oriented
     * programming in general, is to encapsulate/isolate
     * values as much as possible. 
     * Getters - are methods used to query the value of 
     * instance variables.
     * this.getLocationX();
     * Setters - methods that set values for instance 
     * variables. 
     * orb1.setLocation(Player.x, Player.y);
     */
    public void setDirection(int i){
        this.direction = i;
    }
    public int getDirection(){
        return this.direction;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS2016;


import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author josephjarzombek
 */
public class Playercar {
    public float x = 96f;
    public float y = 128f;
    float hitboxX = x + 8f;
    float hitboxY = y + 8f;
    public float pdelta;
    private int startX, startY, width = 30, height = 42;
    public Shape rect = new Rectangle(getplayershitboxX(),
            getplayershitboxY(), width, height);
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
    
    
}

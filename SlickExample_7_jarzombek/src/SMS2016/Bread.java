/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS2016;

/**
 *
 * @author josephjarzombek
 */
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author josephjarzombek
 */
public class Bread {
    
	public int x;
	public int y;
	public boolean isvisible = true;
	Image currentImage;
	Shape hitbox;
	Image bread = new Image(
			"res/bread.png");

	Bread(int a, int b) throws SlickException {
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(a, b, 32, 32);// 64 is the width of the item
		this.currentImage = bread;

	}
}



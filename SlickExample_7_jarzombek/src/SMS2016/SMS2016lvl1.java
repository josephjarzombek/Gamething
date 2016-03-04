package SMS2016;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
class blocked {
	public static boolean[][] blocked;
	public static boolean[][] getblocked() {
		return blocked;
	}
}
public class SMS2016lvl1 extends BasicGameState {
        
        public static Player player;
        public Orb orb;
        public static Beef prime;
        public static Enemy flava, flav;
        public static Onomy fluvu, fluv;
        public static Bread grain;
        public static Lettus leaf;
        public Cashier amanda;
        public ArrayList<Cashier> register= new ArrayList();
        public ArrayList<Lettus> head = new ArrayList();
        public ArrayList<Bread> crust = new ArrayList();
        public ArrayList<Enemy> bonez = new ArrayList();
        public ArrayList<Onomy> firez = new ArrayList();
        public ArrayList<Beef> cut = new ArrayList();
        public ArrayList<Ninja> dojo = new ArrayList();
	private static TiledMap grassMap;
	private static AppGameContainer app;
	private static Camera camera;
	public static int counter = 0;
	private static final int SIZE = 64;
	private static final int SCREEN_WIDTH = 1000;
	private static final int SCREEN_HEIGHT = 750;
	public SMS2016lvl1(int xSize, int ySize) {
	}
	public void init(GameContainer gc, StateBasedGame sbg)
	throws SlickException {
		gc.setTargetFrameRate(60);
		gc.setShowFPS(false);
		grassMap = new TiledMap("res/groc.tmx");
		camera = new Camera(gc, grassMap);
                player = new Player();
		blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];
		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int tileID = grassMap.getTileId(xAxis, yAxis, 1);
				String value = grassMap.getTileProperty(tileID,
				"blocked", "false");
				if ("true".equals(value)) {
					blocked.blocked[xAxis][yAxis] = true;
				}
			}
		}
		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int xBlock = (int) xAxis;
				int yBlock = (int) yAxis;
				if (!blocked.blocked[xBlock][yBlock]) {
					if (yBlock % 7 == 0 && xBlock % 15 == 0 ) {
					}
				}
			}
		}
		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int xBlock = (int) xAxis;
				int yBlock = (int) yAxis;
				if (!blocked.blocked[xBlock][yBlock]) {
					if (xBlock % 9 == 0	&& yBlock % 25 == 0) {
					}
				}
			}
		}
                orb = new Orb((int) player.x, (int) player.y);
                amanda = new Cashier(2000,3000);
                prime = new Beef(2560,500);
                grain = new Bread(464,1500);
                flava = new Enemy(900,800);
                flav = new Enemy(256,256);
                leaf = new Lettus(1504,1104);
                fluvu = new Onomy(1800,3000);
                fluv = new Onomy(3004,192);
                bonez.add(flava);
                bonez.add(flav);
                firez.add(fluvu);
                firez.add(fluv);
                register.add(amanda);
                head.add(leaf);
                cut.add(prime);
                crust.add(grain);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	throws SlickException {
		camera.centerOn((int) player.x, (int) player.y);
		camera.drawMap();
		camera.translateGraphics();
		player.sprite.draw((int) player.x, (int) player.y);
                if (player.health > 0){
		g.drawString("Cash: " + player.health, camera.cameraX + 10,
				camera.cameraY + 10);
                }else{
                    g.drawString("Cash: 0" , camera.cameraX + 10,
				camera.cameraY + 10);
                }
		g.drawString("time passed: " +counter/1000, camera.cameraX +600,camera.cameraY );

                 for (Enemy e : bonez) {
			if (e.isAlive) {
				e.currentanime.draw(e.Bx, e.By);

                        }
                }
                for (Onomy e : firez) {
			if (e.isAlive) {
				e.currentanime.draw(e.Bx, e.By);
                        }
                }
                 for (Beef n : cut) {
			if (n.isvisible) {
				n.currentImage.draw(n.x, n.y);
                        }
                }
                  for (Cashier e : register) {
			if (e.isAlive) {
				e.currentanime.draw(e.Bx, e.By);
                        }
                }
                 for (Lettus n : head) {
			if (n.isvisible) {
				n.currentImage.draw(n.x, n.y);
                        }
                }
                 for (Bread n : crust) {
			if (n.isvisible) {
				n.currentImage.draw(n.x, n.y);
                        }
                }
                 if (orb.isIsVisible()) {
                     orb.orbpic.draw(orb.getLocationx(), orb.getLocationy());
                 }        
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
                throws SlickException {
		counter += delta;
		Input input = gc.getInput();
		float fdelta = delta * player.speed;
		player.setpdelta(fdelta);
		double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);
		float projectedright = player.x + fdelta + SIZE;
		boolean cangoright = projectedright < rightlimit;
		if (input.isKeyDown(Input.KEY_UP)) {
			player.sprite = player.up;
                        player.setDirection(0);
			float fdsc = (float) (fdelta - (SIZE * .15));
			if (!(isBlocked(player.x, player.y - fdelta) || isBlocked((float) (player.x + SIZE + 1.5), player.y - fdelta))) {
				player.sprite.update(delta);
				player.y -= fdelta;
			}
		} else if (input.isKeyDown(Input.KEY_DOWN)) {
			player.sprite = player.down;
                        player.setDirection(2);
			if (!isBlocked(player.x, player.y + SIZE + fdelta)
			|| !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {
				player.sprite.update(delta);
				player.y += fdelta;
			}
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			player.sprite = player.left;
                        player.setDirection(3);
			if (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x
			- fdelta, player.y + SIZE - 1))) {
				player.sprite.update(delta);
				player.x -= fdelta;
			}
		} else if (input.isKeyDown(Input.KEY_RIGHT)) {
			player.sprite = player.right;
                        player.setDirection(1);
			if (cangoright
				&& (!(isBlocked(player.x + SIZE + fdelta,
                                player.y) || isBlocked(player.x + SIZE + fdelta, player.y
				+ SIZE - 1)))) {
			    	player.sprite.update(delta);
				player.x += fdelta;
			}
        } else if (input.isKeyPressed(Input.KEY_SPACE)) {
            orb.setDirection(player.getDirection());
            orb.settimeExists(100);
            orb.setLocationx((int) player.x);
            orb.setLocationy((int) player.y);
            orb.hitbox.setX(orb.getLocationx());
            orb.hitbox.setY(orb.getLocationy());
            orb.setIsVisible(!orb.isIsVisible());
        }
		player.rect.setLocation(player.getplayershitboxX(),
				player.getplayershitboxY());
                        if (orb.isIsVisible()) {
            if (orb.gettimeExists() > 0) {
                if (orb.getDirection() == 0) {
                    orb.setLocationx((int) player.x);
                    orb.setLocationy(orb.getLocationy() - 5);
                } else if (orb.getDirection() == 2) {
                    orb.setLocationx((int) player.x);
                    orb.setLocationy(orb.getLocationy() + 5);
                } else if (orb.getDirection() == 3) {
                    orb.setLocationx(orb.getLocationx() - 5);
                    orb.setLocationy(orb.getLocationy());
                } else if (orb.getDirection() == 1) {
                    orb.setLocationx(orb.getLocationx() + 5);
                    orb.setLocationy(orb.getLocationy());
                }
                orb.hitbox.setX(orb.getLocationx());
                orb.hitbox.setY(orb.getLocationy());
                orb.countdown();
            } else {
                orb.setIsVisible(false);
            }
        }
		for (Onomy e : firez) {
			if (player.rect.intersects(e.rect)) {
				if (e.isAlive) {
					player.health -= 2;
				}
			}
		}
		for (Enemy e : bonez) {
			if (player.rect.intersects(e.rect)) {
				if (e.isAlive) {
					player.health -= 2;
				}
			}
		}
                for (Beef n : cut) {
			if (player.rect.intersects(n.hitbox)) {
				if (n.isvisible) {

                                        player.counter = player.counter + 1;
					n.isvisible = false;
				}
			}
		}
                for (Lettus n : head) {
			if (player.rect.intersects(n.hitbox)) {
				if (n.isvisible) {
					player.counter = player.counter + 1;
					n.isvisible = false;
				}
			}
		}
		for (Bread n : crust) {
			if (player.rect.intersects(n.hitbox)) {
				if (n.isvisible) {
					player.counter = player.counter + 1;
					n.isvisible = false;
				}
			}
		}
		for (Cashier e : register) {
			if (player.rect.intersects(e.rect)) {
				if (e.isAlive && player.counter == 3 && player.health > 150) {
					sbg.enterState(4, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                                }else{
                                    makevisible();
			sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
				}
			}
		}
		        for (Enemy e : bonez) {
                        if (orb.hitbox.intersects(e.rect)){
                        e.isAlive = false;
                    }
        }
                for (Onomy e : firez) {
                        if (orb.hitbox.intersects(e.rect)){
                        e.isAlive = false;
                    }
        }
}       
	public int getID() {
		return 1;
	}
	public void makevisible(){
		}
	private boolean isBlocked(float tx, float ty) {
		int xBlock = (int) tx / SIZE;
		int yBlock = (int) ty / SIZE;
		return blocked.blocked[xBlock][yBlock];
	}
}
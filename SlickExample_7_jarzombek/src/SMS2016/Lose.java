package SMS2016;


import static SMS2016.SMS2016lvl1.player;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import org.newdawn.slick.Game;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.state.transition.FadeInTransition;

import org.newdawn.slick.state.transition.FadeOutTransition;

public class Lose extends BasicGameState {

    private StateBasedGame game;
    public Image startimage;

     public Lose(int xSize, int ySize) {

    }

    public void init(GameContainer container, StateBasedGame game)

            throws SlickException {
    	startimage = new Image("res/LossScreen.png");

        this.game = game;

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g)

            throws SlickException {
    	
    	startimage.draw();

        g.setColor(Color.white);

        g.drawString("press 1 to try again", 400, 320);

    }

    public void update(GameContainer container, StateBasedGame game, int delta)

            throws SlickException {

    }

    public int getID() {

        return 2;


    }

    @Override


    public void keyReleased(int key, char c) {


        switch (key) {


            case Input.KEY_1:

                player.health  = 200;
                player.speed = .4f;
                SMS2016lvl1.counter = 0;
                player.x = 96f;
                player.y = 228f;
                SMS2016lvl1.prime.isvisible = true;
                SMS2016lvl1.grain.isvisible = true;
                SMS2016lvl1.leaf.isvisible = true;
                SMS2016lvl1.fluvu.isAlive = true;
                SMS2016lvl1.fluv.isAlive = true;
                SMS2016lvl1.flav.isAlive = true;
                SMS2016lvl1.flava.isAlive = true;
                break;

            case Input.KEY_2:

                break;

            case Input.KEY_3:

                break;

            default:

                break;

        }

    }

}
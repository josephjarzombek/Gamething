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



public class Win extends BasicGameState {


    


    private StateBasedGame game;
    public Image startimage;

    


     public Win(int xSize, int ySize) {



    }



    


    public void init(GameContainer container, StateBasedGame game)


            throws SlickException {
    	startimage = new Image("res/winscreen.png");


        this.game = game;



// TODO AutoÃ¢â‚¬Âgenerated method stub


    }



   


    public void render(GameContainer container, StateBasedGame game, Graphics g)


            throws SlickException {
    	
    	startimage.draw();



// TODO AutoÃ¢â‚¬Âgenerated method stub


        g.setColor(Color.white);


        //g.drawString("You LOSE!", 450, 200);
        g.drawString("press 1 to try again", 400, 320);


       


    }



    


    public void update(GameContainer container, StateBasedGame game, int delta)


            throws SlickException {


// TODO AutoÃ¢â‚¬Âgenerated method stub


    }



  


    public int getID() {


// TODO AutoÃ¢â‚¬Âgenerated method stub


        return 3;


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
                player.counter=0;
                SMS2016lvl1.prime.isvisible = true;
                SMS2016lvl1.grain.isvisible = true;
                SMS2016lvl1.leaf.isvisible = true;
                SMS2016lvl1.fluvu.isAlive = true;
                SMS2016lvl1.fluv.isAlive = true;
                SMS2016lvl1.flav.isAlive = true;
                SMS2016lvl1.flava.isAlive = true;
                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));


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


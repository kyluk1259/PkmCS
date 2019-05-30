/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import static GameState.GameStateManager.PLAYSTATE;
import Graphics.Background;
import Graphics.Sprite;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import pokemoncs.GamePanel;

/**
 *
 * @author Kyle's PC
 */
public class StartState extends GameState {

    private Background menuBackground, startBackground, currentBackground;
    private float posx, posy;
    private int flash, count;
    private String pressStart;
    private Random rand;
    private int maxA, maxB, maxC, maxD;
    private double multA, multB, multC, multD;

    public StartState(GameStateManager gsm) {
        super(gsm);
        startBackground = new Background("Backgrounds/startscreen.jpg");
        currentBackground = startBackground;

        flash = 0;
        count = 0;

        rand = new Random();
        newRandom();
        pressStart = "PRESS ENTER";
        posx = (int) ((GamePanel.getW() / 2) - (pressStart.length() * 32) / 2.3);
        posy = (int) (GamePanel.getH() - 100);
    }
    
    private void newRandom(){
        maxA = rand.nextInt(2) + 1;
        maxB = rand.nextInt(2) + 1;
        maxC = rand.nextInt(2) + 1;
        maxD = rand.nextInt(2) + 1;
        multA = rand.nextDouble() + maxA;
        multB = rand.nextDouble() + maxB;
        multC = rand.nextDouble() + maxC;
        multD = rand.nextDouble() + maxD;
    }

    @Override
    public void update() {

        if (count != 630) {
            count++;
        } else {
            newRandom();
            count = 0;
        }

        if (flash != 5) {
            flash++;
        } else {
            flash = 0;
        }
    }

    @Override
    public void input(KeyHandler key) {
        if (key.menu.down) {
            System.out.print("pressed");
            try {
                Thread.sleep(1000);
                currentBackground = null;
            } catch (Exception e) {

            }
            gsm.addAndPop(PLAYSTATE);
        }
    }

    public void snow(Graphics2D g) {
        g.fillOval(50, (int) (-5 + multA), 10, 10);
    }

    @Override
    public void render(Graphics2D g) {
        Background.drawImage(g, currentBackground.getBackground(), new Vector2d(0, 0), 0, 0);
        g.setColor(Color.white);
        snow(g);
        if (flash != 0 && flash != 1) {
            Sprite.drawArray(g, font, pressStart, new Vector2d(posx, posy), 32, 32, 24, 0);
        }
    }

}

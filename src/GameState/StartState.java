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
    private int flash;
    private String pressStart;
    private Random rand;
    private double multA, multB, multC, multD;

    public StartState(GameStateManager gsm) {
        super(gsm);
        menuBackground = new Background("Backgrounds/startscreen.jpg");
        currentBackground = menuBackground;

        flash = 0;

        pressStart = "PRESS ENTER";
        posx = (int) ((GamePanel.getW() / 2) - (pressStart.length() * 32) / 2.3);
        posy = (int) (GamePanel.getH() - 100);
    }
    
    @Override
    public void update() {

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

    @Override
    public void render(Graphics2D g) {
        Background.drawImage(g, currentBackground.getBackground(), new Vector2d(0, 0), 0, 0);
        g.setColor(Color.white);
        if (flash != 0 && flash != 1) {

            Sprite.drawArray(g, font, pressStart, new Vector2d(posx, posy), 32, 32, 24, 0);
        }
    }

}

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
    private float multA, multB, multC, multD;

    public StartState(GameStateManager gsm) {
        super(gsm);
        startBackground = new Background("Backgrounds/startscreen.jpg");
        currentBackground = startBackground;

        flash = 0;
        count = 0;
        rand = new Random();
        newRandom();
        pressStart = "PRESS ENTER";
        posx = (int) ((GamePanel.getW() / 2) - (pressStart.length() * 56) / 5.2);
        posy = (int) (GamePanel.getH() - 100);
    }

    private void newRandom() {
        maxA = rand.nextInt(2) + 1;
        maxB = rand.nextInt(2) + 1;
        maxC = rand.nextInt(2) + 1;
        maxD = rand.nextInt(2) + 1;
        multA = rand.nextFloat() + maxA;
        multB = rand.nextFloat() + maxB;
        multC = rand.nextFloat() + maxC;
        multD = rand.nextFloat() + maxD;
    }

    @Override
    public void update() {

        if (count != 500) {
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
                Thread.sleep(800);
                currentBackground = null;
            } catch (Exception e) {

            }
            gsm.addAndPop(PLAYSTATE);
        }
    }

    public void snow(Graphics2D g) {
        g.fillOval(50,  (int) (-10 + count * multA), 10, 10);
        g.fillOval(111, (int) (-26 + count * multB), 10, 10);
        g.fillOval(177, (int) (-35 + count * multC), 10, 10);
        g.fillOval(259, (int) (-24 + count * multD), 10, 10);
        g.fillOval(469, (int) (-10 + count * multC), 10, 10);
        g.fillOval(546, (int) (-35 + count * multB), 10, 10);
        g.fillOval(649, (int) (-36 + count * multD), 10, 10);
        g.fillOval(730, (int) (-5  + count * multC), 10, 10);
        g.fillOval(325, (int) (-16 + count * multB), 10, 10);
        g.fillOval(200, (int) (-14 + count * multA), 10, 10);
        g.fillOval(514, (int) (-36 + count * multB), 10, 10);
        g.fillOval(626, (int) (-43 + count * multD), 10, 10);
        g.fillOval(620, (int) (-17 + count * multD), 10, 10);
        g.fillOval(20,  (int) (-200 + count * multA), 10, 10);
        g.fillOval(505, (int) (-228 + count * multA), 10, 10);
        g.fillOval(111, (int) (-285 + count * multB), 10, 10);
        g.fillOval(177, (int) (-258 + count * multC), 10, 10);
        g.fillOval(259, (int) (-296 + count * multD), 10, 10);
        g.fillOval(469, (int) (-276 + count * multC), 10, 10);
        g.fillOval(546, (int) (-269 + count * multB), 10, 10);
        g.fillOval(649, (int) (-263 + count * multD), 10, 10);
        g.fillOval(638, (int) (-283 + count * multC), 10, 10);
        g.fillOval(325, (int) (-274 + count * multB), 10, 10);
        g.fillOval(200, (int) (-258 + count * multA), 10, 10);
        g.fillOval(514, (int) (-295 + count * multB), 10, 10);
        g.fillOval(736, (int) (-467 + count * multD), 10, 10);
        g.fillOval(620, (int) (-485 + count * multD), 10, 10);
        g.fillOval(20,  (int) (-463 + count * multA), 10, 10);
        g.fillOval(50,  (int) (-428 + count * multA), 10, 10);
        g.fillOval(111, (int) (-485 + count * multB), 10, 10);
        g.fillOval(177, (int) (-458 + count * multC), 10, 10);
        g.fillOval(73,  (int) (-496 + count * multD), 10, 10);
        g.fillOval(193, (int) (-476 + count * multC), 10, 10);
        g.fillOval(546, (int) (-469 + count * multB), 10, 10);
        g.fillOval(649, (int) (-463 + count * multD), 10, 10);
        g.fillOval(727, (int) (-483 + count * multC), 10, 10);
        g.fillOval(325, (int) (-474 + count * multB), 10, 10);
        g.fillOval(67,  (int) (-458 + count * multA), 10, 10);
        g.fillOval(514, (int) (-495 + count * multB), 10, 10);
        g.fillOval(838, (int) (-467 + count * multD), 10, 10);
        g.fillOval(620, (int) (-485 + count * multD), 10, 10);
        g.fillOval(578, (int) (-463 + count * multA), 10, 10);

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

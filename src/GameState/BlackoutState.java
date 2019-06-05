/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import static GameState.GameStateManager.PLAYSTATE;
import Graphics.Sprite;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

public class BlackoutState extends GameState {

    private int color, count, index;
    private boolean renderStop;
    private String name, text;

    public BlackoutState(GameStateManager gsm) {
        super(gsm);
        color = 0;
        count = 255;
        renderStop = false;
        text = "You blacked out and lost *400. You woke up at the nearest pokemon centre fully healed.";
        index = 0;
    }

    @Override
    public void update() {
        if (count != 0) {
            count--;
        } else {
            count = 0;
        }

        color = count;

    }

    public void input(KeyHandler key) {

    }

    public void render(Graphics2D g) {
        if (renderStop != true) {
            g.setColor(new Color(color, color, color));
            g.fillRect(0, 0, 840, 640);
            g.setColor(Color.white);
            g.fillRect(0, 480, 840, 160);
            Sprite.drawText(g, font, text, new Vector2d(25, 510), 24, 24, 20, 0, index);
            if (index == text.length()) {
                index = text.length();
                renderStop = true;
            } else {
                index++;
            }
        } else {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("BlackoutState ERROR: Couldn't load PlayState");
            }
            gsm.addAndPop(PLAYSTATE);
        }

    }

}

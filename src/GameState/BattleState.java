/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Graphics.Background;
import Graphics.Sprite;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Kyle's PC
 */
public class BattleState extends GameState {

    private boolean isStarted, loadBattle;
    private Background battleBackground, currentBackground;
    private int color, count, index, scale;
    private String text;

    public BattleState(GameStateManager gsm) {
        super(gsm);
        isStarted = false;
        scale = 0;
        count = 50;
        battleBackground = new Background("Backgrounds/battlescenes.png", 257, 145, 1, 147);
        currentBackground = battleBackground;
        text = "You are challenged by Kyle.";
    }

    @Override
    public void update() {
        if (count != 255 && isStarted == false) {
            count++;
        } else {
            count = 0;
        }

        color = count;

        if (loadBattle == true) {
            if (scale < 840) {
                scale += 5;
            } else {
                scale = 0;
                isStarted = true;
                loadBattle = false;
            }
        }
    }

    @Override
    public void input(KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g) {

        if (isStarted == false && loadBattle == false) {
            g.setColor(new Color(color, color, color));
            g.fillRect(0, 0, 840, 640);
            g.setColor(Color.white);
            g.fillRect(0, 480, 840, 160);
            Sprite.drawText(g, font, text, new Vector2d(25, 510), 24, 24, 20, 0, index);
            if (index == text.length()) {
                index = text.length();
                loadBattle = true;
            } else {
                index++;
            }
        } else if (isStarted == false && loadBattle == true) {
            g.setColor(Color.black);
            g.fillRect(0, 0, 840, 640);
            g.setColor(Color.white);
            g.fillRect(0 + scale / 2, 0 + scale / 2, 840 - scale, 640 - scale);
        }

        if (isStarted == true) {
            Sprite.drawText(g, font, text, new Vector2d(25, 510), 24, 24, 20, 0, index);
            if (index == text.length()) {
                index = text.length();
            } else {
                index++;
            }
            Sprite.drawImage(g, currentBackground.getBackground(), new Vector2d(0, 0), 840, 640);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Entity.Player;
import Graphics.Background;
import Graphics.Font;
import Graphics.Sprite;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Color;
import java.awt.Graphics2D;
import pokemoncs.GamePanel;

/**
 *
 * @author Kyle's PC
 */
public class PlayState extends GameState {

    public static Player player;
    public static boolean loadText, textComplete, pause;
    public static String text;
    public static int index = 0;
    private float xStart;
    private float x;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        float posx = (int) ((GamePanel.getW() / 2) - (38));
        float posy = (int) ((GamePanel.getH() / 2) - (38));
        player = new Player(new Sprite("Sprites/playerwalking.png", 38, 38), new Vector2d(posx, posy), 80, gsm);
        loadText = false;
        index = 0;
        xStart = 25;
        pause = false;
        textComplete = false;
    }

    public void update() {
        if(pause != true){
        player.update();
        }
    }

    public void input(KeyHandler key) {
        if(pause != true){
        player.input(key);
        }
    }

    public void render(Graphics2D g) {
        if(pause != true){
        player.render(g);
        g.setColor(Color.red);
        g.drawLine(420, 0, 420, 640);
        g.drawLine(0, 320, 840, 320);
        if (loadText == true) {
            Sprite.drawText(g, font, text, new Vector2d(xStart, 400), 32, 32, 24, 0, index);
            if (index == text.length()) {
                index = text.length();
                textComplete = true;
            } else {
                index++;
            }
        } else {
            Sprite.drawArray(g, font, "Press Z to read message", new Vector2d(xStart, 400), 32, 32, 24, 0);
            Sprite.drawArray(g, font, "Hold X when not moving and move in a direction to run", new Vector2d(xStart, 450), 32, 32, 24, 0);
            Sprite.drawArray(g, font, "Press Enter to pause", new Vector2d(xStart, 550), 32, 32, 24, 0);
            Sprite.drawArray(g, font, "Press X to unpause game", new Vector2d(xStart, 600), 32, 32, 24, 0);
        }
    }
    }
}

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

/**
 *
 * @author Kyle's PC
 */
public class PlayState extends GameState {

    private Player player;
    public static boolean loadText;
    public static String text;
    public static int index = 0;
    private float xStart;
    private float x;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        player = new Player(new Sprite("Sprites/playerwalking.png", 38, 38), new Vector2d(300, 300), 80);
        loadText = false;
        index = 0;
        xStart = 50;
        x = xStart;
    }

    public void update() {
        player.update();
    }

    public void input(KeyHandler key) {
        player.input(key);
    }

    public void render(Graphics2D g) {
        player.render(g);
        if (loadText == true) {
            Sprite.drawText(g, font, text, new Vector2d(xStart, 400), 32, 32, 24, 0, index);
            if (index == text.length()) {
                index = text.length();
            } else {
                index++;
            }
        }else{
            Sprite.drawArray(g, font, "Press Z", new Vector2d(xStart, 400), 32, 32, 24, 0);
        }
    }
}

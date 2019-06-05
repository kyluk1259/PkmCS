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

    private Player player;
    private int flash, count;
    private String test;
    private char letter;
    public static boolean loadText, textComplete;
    public static String text;
    public static int index = 0;
    private float xStart;
    private float x;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        flash = 0;
        count = 0;
        test = "test";
        test = test.toUpperCase();
        float posx = (int) ((GamePanel.getW() / 2) - (38));
        float posy = (int) ((GamePanel.getH() / 2) - (38));
        player = new Player(new Sprite("Sprites/playerwalking.png", 38, 38), new Vector2d(posx, posy), 80);
        loadText = false;
        index = 0;
        xStart = 25;
        textComplete = false;
    }

    public void update() {
        test = test.toUpperCase();
        if(flash != 5){
            flash++;
        }else{
            flash = 0;
        }
        
        if(count != test.length()){
            count++;
        }else{
            count = 0;
        }
        player.update();
    }

    public void input(KeyHandler key) {
        player.input(key);
    }

    public void render(Graphics2D g) {
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

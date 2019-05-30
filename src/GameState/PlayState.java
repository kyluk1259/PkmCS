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
    private int flash, count;
    private String test;
    private char letter;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        flash = 0;
        count = 0;
        player = new Player(new Sprite("Sprites/playerwalking.png", 38, 38), new Vector2d(300, 300), 80);
        test = "test";
        test = test.toUpperCase();
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
        letter = test.charAt(count - 1);
    }

    public void input(KeyHandler key) {
        player.input(key);
    }

    public void render(Graphics2D g) {
        Sprite.printLetters(g, font, letter, new Vector2d(400, 50), 32, 32, 24, 0);
        player.render(g);
    }

}

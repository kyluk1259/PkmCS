/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Entity.Player;
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

    private Font font;
    private Player player;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        font = new Font("Font/font.png", 111, 111);
        player = new Player(new Sprite("Sprites/playerwalking.png", 38, 38), new Vector2d(300, 300), 80);
        
    }

    public void update() {
        player.update();
    }

    public void input(KeyHandler key) {
        player.input(key);
    }

    public void render(Graphics2D g) {
        Sprite.drawArray(g, font, "your mom.", new Vector2d(0, 50), 32, 32, 24, 0);
        player.render(g);
    }

}

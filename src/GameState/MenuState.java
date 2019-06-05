/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Graphics.Font;
import Graphics.Sprite;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Kyle's PC
 */
public class MenuState extends GameState {
    
    //private Font font;
    private String pokemon;
    private String playerName;
    private int money;
    private String moneyAmount;
    private Sprite pokeBall;
    private Font Sprites;
    

    public MenuState(GameStateManager gsm) {
        super(gsm);
        //font = new Font("Font/font.png", 111, 111);
        pokemon = "Pokemon";
        pokeBall = new Sprite("Images/pokemonBall.png");
        //JOptionPane.showMessageDialog(null, pokeBall);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void input(KeyHandler key) {
        
    }

    @Override
    public void render(Graphics2D g) {
        //Rectangle
        g.setColor(Color.white);
        g.fillRect(600, 0, 240, 640);
        
        //ICONS
        Sprite.drawImage(g, pokeBall, new Vector2d(760, 168), 24, 24);
        
        //Text        
        Sprite.drawArray(g, font, "Menu", new Vector2d(625, 75), 48, 48, 36, 0);
        Sprite.drawArray(g, font, pokemon, new Vector2d(610, 170), 24, 24, 20, 0);
        Sprite.drawArray(g, font, "Bag", new Vector2d(610, 230), 24, 24, 20, 0);
        Sprite.drawArray(g, font, "Save", new Vector2d(610, 290), 24, 24, 20, 0);
        Sprite.drawArray(g, font, "Exit", new Vector2d(610, 350), 24, 24, 20, 0);
        //Sprite.drawArray(g, font, playerName, new Vector2d(600, 150), 16, 16, 16, 0);
        //Sprite.drawArray(g, font, moneyAmount, new Vector2d(600, 150), 16, 16, 16, 0);
    }
    
}

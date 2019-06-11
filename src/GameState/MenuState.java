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
    private int money, flash, selection;
    private Sprite pokeBall, bag, save,exit;
    private Font Sprites;
    

    public MenuState(GameStateManager gsm) {
        super(gsm);
        
        flash = 0;
        selection = 1;
        
        pokemon = "Pokemon";
        pokeBall = new Sprite("Images/pokemonBall.png");
        bag = new Sprite("Images/bag.png");
        save = new Sprite("Images/save.png");
        exit = new Sprite("Images/exit.png");
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
        
    }

    @Override
    public void render(Graphics2D g) {
        //Rectangle
        g.setColor(Color.white);
        g.fillRect(600, 0, 240, 640);
        
        //ICONS
        Sprite.drawImage(g, pokeBall, new Vector2d(760, 165), 30, 30);
        Sprite.drawImage(g, bag, new Vector2d(680, 225), 35, 30);
        Sprite.drawImage(g, save, new Vector2d(700, 289), 25, 25);
        Sprite.drawImage(g, exit, new Vector2d(700,347), 25, 25);
        
        //Text        
        Sprite.drawArray(g, font, "Menu", new Vector2d(625, 75), 48, 48, 36, 0);
        Sprite.drawArray(g, font, pokemon, new Vector2d(610, 170), 24, 24, 20, 0);
        Sprite.drawArray(g, font, "Bag", new Vector2d(610, 230), 24, 24, 20, 0);
        Sprite.drawArray(g, font, "Save", new Vector2d(610, 290), 24, 24, 20, 0);
        Sprite.drawArray(g, font, "Exit", new Vector2d(610, 350), 24, 24, 20, 0);
      
        
        //Selection
        switch(selection){
            case 1:
                g.setColor(Color.black);
                if (flash != 0 && flash != 1){
                    g.drawLine(610, 200, 800, 200); 
                }
                break;
            case 2:
                if (flash != 0 && flash != 1){
                    g.drawLine(610, 260, 800, 260);
                }
                break;
            case 3:
                if (flash != 0 && flash != 1){
                    g.drawLine(610, 320, 800, 320);
                }
                break;
            case 4:
                if (flash != 0 && flash != 1){
                    g.drawLine(610, 380, 800, 380);
                }
                break;
        }
        //Sprite.drawArray(g, font, playerName, new Vector2d(600, 150), 16, 16, 16, 0);
        //Sprite.drawArray(g, font, moneyAmount, new Vector2d(600, 150), 16, 16, 16, 0);
    }
    
}

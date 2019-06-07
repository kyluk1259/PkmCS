/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import GameState.GameStateManager;
import Graphics.Sprite;
import Utility.Vector2d;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Kyle's PC
 */
public class Trainer extends Entity {

    private Image renderImage;
    private GameStateManager gsm;
    private Sprite battleSprite;
    
    public Trainer(Sprite sprite, Vector2d origin, int size, GameStateManager gs, Sprite bSprite){
        super(sprite, origin, size);
        gsm = gs;
        battleSprite = bSprite;
        
    }
    
    public void update(){
        super.update();
        renderImage = ani.getImage();
        pos.x += dx;
        pos.y += dy;
    }
    
    public void render(Graphics2D g) {
         g.drawImage(renderImage, (int) (pos.x), (int) (pos.y), size, size, null);
    }
    
}

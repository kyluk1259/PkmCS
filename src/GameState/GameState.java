/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Utility.KeyHandler;
import java.awt.Graphics2D;

/**
 *
 * @author Kyle's PC
 */
public abstract class GameState {
    
    protected GameStateManager gsm;
    
    
    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }
    
    public abstract void update();
    public abstract void input(KeyHandler key);
    public abstract void render(Graphics2D g);
    
}

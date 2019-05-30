/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import static GameState.GameStateManager.PLAYSTATE;
import Utility.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Kyle's PC
 */
public class BlackoutState extends GameState {

    private int color, count;
    private boolean renderStop;
    public BlackoutState(GameStateManager gsm) {
        super(gsm);
        color = 0;
        count = 255;
        renderStop = false;
    }

    @Override
    public void update() {
        if(count != 0){
            count --; 
         
        }else {
        renderStop = true;
        }
        
    color = count;
   
    }

    @Override
    public void input(KeyHandler key) {
        
    }

    @Override
    public void render(Graphics2D g) {
        if(renderStop != true){
        g.setColor(new Color (color, color, color));
        g.fillRect(0,0,800,640);
        }else{
            gsm.addAndPop(PLAYSTATE);
        }
        
    }
    
}

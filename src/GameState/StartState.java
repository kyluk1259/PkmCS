/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import static GameState.GameStateManager.*;
import Graphics.Background;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Graphics2D;

/**
 *
 * @author Kyle's PC
 */
public class StartState extends GameState {
    private Background menuBackground, startBackground, currentBackground;
    

    public StartState(GameStateManager gsm) {
        super(gsm);
        menuBackground = new Background("Backgrounds/startscreen.jpg");
        currentBackground = menuBackground;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void input(KeyHandler key) {
        if(key.menu.down){
            System.out.print("pressed");
            gsm.addAndPop(PLAYSTATE);
        }
    }

    @Override
    public void render(Graphics2D g) {
        Background.drawImage(g, currentBackground.getBackground(), new Vector2d(0,0), 0, 0);
    }
    
}

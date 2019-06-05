/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Utility.KeyHandler;
import java.awt.Graphics2D;
import Graphics.Background;
import Utility.Vector2d;

/**
 *
 * @author Kyle's PC
 */
public class BattleState extends GameState {

private Background battleBackground, startBackground, currentBackground;

    public BattleState(GameStateManager gsm) {
        super(gsm);
        startBackground = new Background("Backgrounds/battle.png");
        currentBackground = startBackground;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void input(KeyHandler key) {
        
    }

    @Override
    public void render(Graphics2D g) {
    Background.drawImage(g, currentBackground.getBackground(), new Vector2d(0, 0), 0, 0);
    }
    
}

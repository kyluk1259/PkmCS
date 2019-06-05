/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Graphics2D;
import java.util.ArrayList;
import pokemoncs.GamePanel;

/**
 *
 * @author Kyle's PC
 */
public class GameStateManager {
    
    private ArrayList<GameState> states;
    
    public static Vector2d map;
    public static final int STARTSTATE = 0;
    public static final int PLAYSTATE = 1;
    public static final int MENUSTATE = 2;
    public static final int BATTLESTATE = 3;
    public static final int BLACKOUTSTATE = 4;
    
    
    public GameStateManager(){
        map = new Vector2d(GamePanel.width, GamePanel.height);
        Vector2d.setWorldVar(map.x, map.y);
        
        states = new ArrayList<GameState>();
        
        states.add(new StartState(this));
    }
    
    public void pop(int state){
        states.remove(state);
    }
    
    public void add(int state){
        if(state == STARTSTATE){
            states.add(new StartState(this));
        }
        if(state == PLAYSTATE){
            states.add(new PlayState(this));
        }
        if(state == MENUSTATE){
            states.add(new MenuState(this));
        }
        if(state == BATTLESTATE){
            states.add(new BattleState(this));
        }
        if(state == BLACKOUTSTATE){
            states.add(new BlackoutState(this));
        }
    }
    
    public void addAndPop(int state){
        states.remove(0);
        add(state);
    }
    
    public void update(){
     for(int i = 0; i < states.size(); i++){
         states.get(i).update();
     }   
    }
    
    public void input(KeyHandler key){
         for(int i = 0; i < states.size(); i++){
         states.get(i).input(key);
     }   
    }
    
    public void render(Graphics2D g){
         for(int i = 0; i < states.size(); i++){
         states.get(i).render(g);
     }   
    }
    
}

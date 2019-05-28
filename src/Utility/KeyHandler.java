/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import pokemoncs.GamePanel;
/**
 *
 * @author Kyle's PC
 */
public class KeyHandler implements KeyListener {
    
    public static List<Key> keys = new ArrayList<Key>();
    
    public class Key{
        public int presses, absorbs;
        public boolean down, clicked;
        
        public Key(){
            keys.add(this);
        }
        
        public void togglePress(boolean pressed){
            if(pressed != down){
                down = pressed;
            }
            if(pressed){
                presses++;
            }
        }
        
        public void toggleClick(){ //
            if(absorbs < presses){
                absorbs++;
                clicked = true;
            }else{
                clicked = false;
            }
        }   
    }
    
    public KeyHandler(GamePanel game){
        game.addKeyListener(this);
    }
    
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key sprint = new Key();
    public Key menu = new Key();
    
    public void releaseAll(){
        for(int i = 0; i < keys.size(); i++){
            keys.get(i).down = false;
        }
    }
    
    public void tick(){
        for(int i = 0; i < keys.size(); i++){
            keys.get(i).toggleClick();
        }
    }
    
    public void toggle(KeyEvent e, boolean pressed){        //Handles key inputs coming to game
        if(e.getKeyCode() == KeyEvent.VK_W) up.togglePress(pressed);
        if(e.getKeyCode() == KeyEvent.VK_S) down.togglePress(pressed);
        if(e.getKeyCode() == KeyEvent.VK_A) left.togglePress(pressed);
        if(e.getKeyCode() == KeyEvent.VK_D) right.togglePress(pressed);
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) sprint.togglePress(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ENTER) menu.togglePress(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);        //toggles on when a key is pressed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);       //toggles off when a key is released
    }
    
}

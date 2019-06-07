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
import java.util.concurrent.TimeUnit;
import pokemoncs.GamePanel;

/**
 *
 * @author Kyle's PC
 */
public class KeyHandler implements KeyListener {

    public static List<Key> keys = new ArrayList<Key>();

    public class Key {

        public boolean down, clicked;

        public Key() {
            keys.add(this);
        }

        public void togglePress(boolean pressed) {
            if (pressed != down) {
                down = pressed;
            }
            if (pressed) {

            }
        }

        public void toggleClick(boolean pressed) { //
            if (clicked == false) {
                clicked = true;
                try {
                    TimeUnit.MILLISECONDS.sleep(65);
                    clicked = false;
                } catch (InterruptedException e) {

                }
            } else {
                releaseClicked();
            }
        }
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key A = new Key();
    public Key B = new Key();
    public Key menu = new Key();
    public boolean firstClick, notFirst;
    public KeyEvent pKey;

    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);
        firstClick = true;
        pKey = null;
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).clicked = false;
            keys.get(i).down = false;
        }
    }

    public void releasePressed() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).down = false;
        }
    }

    public void releaseClicked() {
        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).clicked = false;
        }
    }

    public void toggleHeld(KeyEvent e, boolean pressed) {        //Handles key inputs coming to game
        if (e.getKeyCode() == KeyEvent.VK_X) {
            B.togglePress(pressed);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up.togglePress(pressed);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down.togglePress(pressed);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left.togglePress(pressed);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right.togglePress(pressed);
        }
    }

    public void toggleClicked(KeyEvent e, boolean pressed) {        //Handles key inputs coming to game
        if (e.getKeyCode() == KeyEvent.VK_Z && A.clicked != true) {
            A.toggleClick(pressed);
            e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            B.toggleClick(pressed);
            e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            menu.toggleClick(pressed);
            e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up.toggleClick(pressed);
            e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down.toggleClick(pressed);
            e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right.toggleClick(pressed);
            e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left.toggleClick(pressed);
            e.consume();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (firstClick == true) {
            toggleClicked(e, true);
        }
        toggleHeld(e, true);  //toggles on when a key is pressed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggleClicked(e, false);
        toggleHeld(e, false);       //toggles off when a key is released
        firstClick = false;
        pKey = null;
    }

}

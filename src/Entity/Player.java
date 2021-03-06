/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import GameState.PlayState;
import static GameState.PlayState.*;
import Graphics.Sprite;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Kyle's PC
 */
public class Player extends Entity {

    private boolean pause, back;
    private Image renderImage;

    private final int OPENBAG = 0;
    private final int CLOSEBAG = 1;

    public Player(Sprite sprite, Vector2d origin, int size) {
        super(sprite, origin, size);
    }

    public void move() {
        if(sprint){
            sprite = runSprite;
        }
        
        if (up) {
            dy -= moveSpeed;
        } else {
            if (dy < 0) {
                dy += stopSpeed;
                if (dy > 0) {
                    dy = 0;
                }
            }
        }

        if (down) {
            dy += moveSpeed;
        } else {
            if (dy > 0) {
                dy -= stopSpeed;
                if (dy < 0) {
                    dy = 0;
                }
            }
        }

        if (right) {
            dx += moveSpeed;
        } else {
            if (dx > 0) {
                dx -= stopSpeed;
                if (dx < 0) {
                    dx = 0;
                }
            }
        }

        if (left) {
            dx -= moveSpeed;
        } else {
            if (dx < 0) {
                dx += stopSpeed;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }

        //ADD
        if (openBag) {
            pause = true;
            if (ani.hasPlayed(3)) {
                ani.stopAnimating();
                openBag = false;
            }
        }

        if (interact && PlayState.loadText == false) {
            PlayState.index = 0;
            PlayState.text = "Hello and welcome to the world of pokekaune. Maps and Pokemon will be added soon.";
            PlayState.loadText = true;
            interact = false;
        }

        if (back && PlayState.textComplete == true && !pause) {
            PlayState.loadText = false;
            back = false;
        }else if (back && PlayState.textComplete == false && !pause){
            back = false;
        }

        if (back && pause) {

            ani.startAnimating();
            closeBag = true;
            animate();

            if (ani.hasPlayed(2)) {
                pause = false;
                back = false;
                closeBag = false;
                sprite = walkSprite;
            }
        }
    }

    public void update() {
        super.update();
        move();
        renderImage = ani.getImage();
        pos.x += dx;
        pos.y += dy;
    }

    public void input(KeyHandler key) {

        if (key.up.down && !pause) {
            up = true;
        } else {
            up = false;
        }

        if (key.down.down && !pause) {
            down = true;
        } else {
            down = false;
        }

        if (key.right.down && !pause) {
            left = true;
        } else {
            left = false;
        }

        if (key.left.down && !pause) {
            right = true;
        } else {
            right = false;
        }

        if (key.A.clicked && !pause) {
            interact = true;
        }else{
            
        }
        
        if (key.menu.clicked) {
            openBag = true;
        }

        if (key.B.clicked) {
            back = true;
        }

        if (key.B.down && !sprint) {
            sprint = true;
        }
        
        if(!key.B.down && sprint){
            sprint = false;
            sprite = walkSprite;
        }

    }

    public void render(Graphics2D g) {
        g.drawImage(renderImage, (int) (pos.x), (int) (pos.y), size, size, null);
    }
}

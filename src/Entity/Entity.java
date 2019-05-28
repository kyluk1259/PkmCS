/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Graphics.Animation;
import Graphics.Sprite;
import Utility.AABB;
import Utility.KeyHandler;
import Utility.Vector2d;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Kyle's PC
 */
public abstract class Entity {
    
    private final int UP = 0;
    private final int DOWN = 1;
    private final int RIGHT = 2;
    private final int LEFT = 3;
    private final int OPENBAG = 4;
    private final int CLOSEBAG = 5;
    
    protected int currentAnimation;
    
    protected Sprite sprite;
    protected Animation ani;
    protected Vector2d pos;
    protected int size;
    
    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean openBag;
    protected boolean closeBag;
    
    protected float dx;
    protected float dy;
    
    protected int moveSpeed;
    
    protected AABB hitBounds;
    protected AABB bounds;
    
    public Entity(Sprite sprite, Vector2d origin, int size){
        this.sprite = sprite;
        pos = origin;
        this.size = size;
        
        bounds = new AABB(origin, size, size);
        hitBounds = new AABB(new Vector2d(origin.x + (size/2), origin.y), size, size);
        
        ani = new Animation();
        setAnimation(DOWN, sprite.getMainSpriteArray(DOWN), 10);
    }
    
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
    
    public void  setSize(int i){
        size = i;
    }
    
    public void setMoveSpeed(int i){
        moveSpeed = i;
    }
    
    public AABB getBounds(){
        return bounds;
    }
    
    public void setAnimation(int i, BufferedImage[] frames, int delay){
        currentAnimation = i;
        ani.setFrames(frames);
        ani.setDelay(delay);
    }
    
    public int getSize(){
        return size;
    }
    
    public Animation getAnimation(){
        return ani;
    }
    
    public void animate(){
        if(up){
            if(currentAnimation != UP || ani.getDelay() == -1){
                setAnimation(UP, sprite.getMainSpriteArray(UP), 5);
            }
        }
        else if(down){
            if(currentAnimation != DOWN || ani.getDelay() == -1){
                setAnimation(DOWN, sprite.getMainSpriteArray(DOWN), 5);
            }
        }
        else if(right){
            if(currentAnimation != RIGHT || ani.getDelay() == -1){
                setAnimation(RIGHT, sprite.getMainSpriteArray(RIGHT), 5);
            }
        }
        else if(left){
            if(currentAnimation != LEFT || ani.getDelay() == -1){
                setAnimation(LEFT, sprite.getMainSpriteArray(LEFT), 5);
            }
        }else{
            setAnimation(currentAnimation, sprite.getMainSpriteArray(currentAnimation), -1);
        }
    }
    
    private void setInteractDirection(){
        if(up){
            hitBounds.setXOff(-size / 2);
            hitBounds.setYOff(-size / 2);
        }
        else if(down){
            hitBounds.setXOff(-size / 2);
            hitBounds.setYOff(-size / 2);
        }
        else if(right){
            hitBounds.setXOff(0);
            hitBounds.setYOff(0);
        }
        else if(left){
            hitBounds.setXOff(-size);
            hitBounds.setYOff(0);
        }
    }
    
    public void update(){
        animate();
        setInteractDirection();
        ani.update();
    }
    
    public abstract void render(Graphics2D g);
    public void input(KeyHandler key){
        
    }
}

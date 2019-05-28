/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author Kyle's PC
 */
public class Vector2d {
    
    public float x;
    public float y;
    
    public static float worldX;
    public static float worldY;
    
    public Vector2d(){
        x = 0;
        y = 0;
    }
    
    public Vector2d(Vector2d pos){
        new Vector2d(pos.x, pos.y);
    }
    
    public Vector2d(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void addX(float i){
        x += i;
    }
    
    public void addY(float i){
        y += i;
    }
    
    public void setX(float f){
        x = f;
    }
    
    public void setY(float f){
        y = f;
    }
    
    public void setVector(Vector2d vec){
        this.x = vec.x;
        this.y = vec.y;
    }
    
    public void setVector(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public static void setWorldVar(float x, float y){
        worldX = x;
        worldY = y;
    }
    
    public Vector2d getWorldVar(){
        return new Vector2d(x - worldX, y - worldY);
    }
    
    @Override
    public String toString(){
        return x + "," + y;
    }
    
}

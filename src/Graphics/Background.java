/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics;
import Utility.Vector2d;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
/**
 *
 * @author kyluk1259
 */
public class Background {
    
    private BufferedImage background;
    private static int w;
    private static int h;
    private static int sX;
    private static int sY;
    
    public Background(String fileName){
        w = 840;
        h = 640;

        System.out.println("Loading: " + fileName + "...");
        background = loadBackground(fileName);
    }
    
    public Background(String fileName, int width, int height, int x, int y){
        w = width;
        h = height;
      
        System.out.println("Loading: " + fileName + "...");
        background = loadBackground(fileName, x, y);
    }
    
    private BufferedImage loadBackground(String fileName){
         BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            System.out.println("Background '"+ fileName + "' Could Not Be Loaded");
        }
        return image;
    }
    
    private BufferedImage loadBackground(String fileName, int x, int y){
         BufferedImage temp = null;
         BufferedImage image = null;

        try {
            temp = ImageIO.read(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            System.out.println("Background '"+ fileName + "' Could Not Be Loaded");
        }
        image = temp.getSubimage(x, y, w, h);
        return image;
    }
    
    public BufferedImage getBackground(){
        return background;
    }
    
    public static void drawImage(Graphics2D g, BufferedImage image, Vector2d pos,int xOff, int yOff) {
        float x = pos.x;
        float y = pos.y;

                g.drawImage(image, (int) x, (int) y, w, h, null);
                
            x += xOff;
            y += yOff;
        }
    }
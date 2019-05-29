/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 *
 * @author kyluk1259
 */
public class Background {
    
    private BufferedImage background;
    private int w;
    private int h;
    
    
    public Background(String fileName){
        w = 800;
        h = 340;

        System.out.println("Loading: " + fileName + "...");
        background = loadBackground(fileName);
    }
    
    private BufferedImage loadBackground(String fileName){
         BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            System.out.println("Player Sprites Could Not Be Loaded");
        }
        return image;
    }
    
    public BufferedImage getBackground(){
        return background;
    }
}

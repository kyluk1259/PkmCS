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
 * @author Kyle's PC
 */
public class Sprite {

    private BufferedImage PLAYERSHEET = null;
    private BufferedImage[][] playerArray;
    private final int SIZE = 40;
    public int w;
    public int h;
    private int wSprite;
    private int hSprite;

    public Sprite(String fileName) {
        w = SIZE;
        h = SIZE;

        System.out.println("Loading: " + fileName + "...");
        PLAYERSHEET = loadSprite(fileName);

        wSprite = PLAYERSHEET.getWidth() / w;
        hSprite = PLAYERSHEET.getHeight() / h;
        loadPlayerArray();
    }

    public Sprite(String fileName, int w, int h) {
        this.w = w;
        this.h = h;

        System.out.println("Loading: " + fileName + "...");
        PLAYERSHEET = loadSprite(fileName);

        wSprite = PLAYERSHEET.getWidth() / w;
        hSprite = PLAYERSHEET.getHeight() / h;
        loadPlayerArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) {
        w = i;
        wSprite = PLAYERSHEET.getWidth() / w;
    }

    public void setHeight(int i) {
        h = i;
        hSprite = PLAYERSHEET.getWidth() / w;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    private BufferedImage loadSprite(String fileName) {
        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            System.out.println("Player Sprites Could Not Be Loaded");
        }
        return sprite;
    }

    public void loadPlayerArray() {
        playerArray = new BufferedImage[wSprite][hSprite];

        for (int x = 0; x < wSprite; x++) {
            for (int y = 0; y < hSprite; y++) {
                playerArray[x][y] = getSprite(x, y);
            }
        }
    }

    public BufferedImage getSpriteSheet() {
        return PLAYERSHEET;
    }

    public BufferedImage getSprite(int x, int y) {
        return PLAYERSHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage[] getMainSpriteArray(int i) {
        return playerArray[i];
    }

    public BufferedImage[][] getSubSpriteArray(int i) {
        return playerArray;
    }

    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> image, Vector2d pos, int width, int height, int xOff, int yOff) {
        float x = pos.x;
        float y = pos.y;

        for (int i = 0; i < image.size(); i++) {
            if (image.get(i) != null) {
                g.drawImage(image.get(i), (int) x, (int) y, width, height, null);
            }

            x += xOff;
            y += yOff;
        }
    }

    public static void drawArray(Graphics2D g, Font f, String word, Vector2d pos, int width, int height, int xOff, int yOff) {
        float x = pos.x;
        float y = pos.y;
        
        word = word.toUpperCase();

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != 32){
                g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
                x += xOff;
                y += yOff;
            }else{
                x += 10;
            }
        }
    }
} 

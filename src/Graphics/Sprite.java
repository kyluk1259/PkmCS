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
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import static pokemoncs.PokemonCS.game;

/**
 *
 * @author Kyle's PC
 */
public class Sprite {

    private BufferedImage SPRITESHEET = null;
    private BufferedImage[][] spriteArray;
    private final int SIZE = 38;
    public int w;
    public int h;
    private int wSprite;
    private int hSprite;

    public Sprite(String fileName) {
        w = SIZE;
        h = SIZE;

        System.out.println("Loading: " + fileName + "...");
        SPRITESHEET = loadSprite(fileName);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();

    }

    public Sprite(String fileName, int w, int h) {
        this.w = w;
        this.h = h;

        System.out.println("Loading: " + fileName + "...");
        SPRITESHEET = loadSprite(fileName);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) {
        w = i;
        wSprite = SPRITESHEET.getWidth() / w;
    }

    public void setHeight(int i) {
        h = i;
        hSprite = SPRITESHEET.getHeight() / h;
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

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[hSprite][wSprite];

        for (int y = 0; y < hSprite; y++) {
            for (int x = 0; x < wSprite; x++) {
                spriteArray[y][x] = getSprite(x, y);
            }
        }
    }

    public BufferedImage getSpriteSheet() {
        return SPRITESHEET;
    }

    public BufferedImage getSprite(int x, int y) {
        return SPRITESHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage[] getMainSpriteArray(int i) {
        return spriteArray[i];
    }

    public BufferedImage[][] getSubSpriteArray() {
        return spriteArray;
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
            String sub = word.substring(i);
            if (word.charAt(i) != 32) {
                g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
                x += xOff;
                y += yOff;
            } else {
                String space = word.substring(i);
                for (int j = 0; j < sub.length(); j++) {
                    if (space.charAt(j) == 32) {
                        space = space.substring(0, j);
                        int calc = space.length() * (width + xOff);
                        if (x + calc > 720) {
                            x = 25;
                            y += 50;
                        } else {
                            x += 10;
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void drawText(Graphics2D g, Font f, String word, Vector2d pos, int width, int height, int xOff, int yOff, int index) {
        word = word.toUpperCase();
        float x = pos.x;
        float y = pos.y;

        for (int i = 0; i < index; i++) {
            String sub = word.substring(i);
            if (word.charAt(i) != 32) {
                g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
                x += xOff;
                y += yOff;
            } else {
                String space = word.substring(i);
                for (int j = 0; j < sub.length(); j++) {
                    if (space.charAt(j) == 32) {
                        space = space.substring(0, j);
                        int calc = space.length() * (width + xOff);
                        if (x + calc > 720) {
                            x = 25;
                            y += 50;
                        } else {
                            x += 10;
                        }
                        break;
                    }
                }
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("SPRITE ERROR: COULDN'T SEQUENTIALLY PRINT TEXT");
        }
    }

    public static void drawImage(Graphics2D g, Sprite sprite, Vector2d pos, int width, int height) {
        float x = pos.x;
        float y = pos.y;

        if (sprite != null) {
            g.drawImage(sprite.getSpriteSheet(), (int) x, (int) y, width, height, null);
        }
    }
}

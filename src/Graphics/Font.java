/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

/**
 *
 * @author Kyle's PC
 */
import Utility.Vector2d;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Kyle's PC
 */
public class Font {

    private BufferedImage FONTSHEET = null;
    private BufferedImage[][] fontArray;
    private final int SIZE = 100;
    public int w;
    public int h;
    private int wLetter;
    private int hLetter;

    public Font(String fileName) {
        w = SIZE;
        h = SIZE;

        System.out.println("Loading: " + fileName + "...");
        FONTSHEET = loadFont(fileName);

        wLetter = FONTSHEET.getWidth() / w;
        hLetter = FONTSHEET.getHeight() / h;
        loadFontArray();
    }

    public Font(String fileName, int w, int h) {
        this.w = w;
        this.h = h;

        System.out.println("Loading: " + fileName + "...");
        FONTSHEET = loadFont(fileName);

        wLetter = FONTSHEET.getWidth() / w;
        hLetter = FONTSHEET.getHeight() / h;
        loadFontArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) {
        w = i;
        wLetter = FONTSHEET.getWidth() / w;
    }

    public void setHeight(int i) {
        h = i;
        hLetter = FONTSHEET.getWidth() / w;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    private BufferedImage loadFont(String fileName) {
        BufferedImage font = null;

        try {
            font = ImageIO.read(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            System.out.println("Font Could Not Be Loaded");
        }
        return font;
    }

    public void loadFontArray() {
        fontArray = new BufferedImage[wLetter][hLetter];

        for (int x = 0; x < wLetter; x++) {
            for (int y = 0; y < hLetter; y++) {
                fontArray[x][y] = getLetter(x, y);
            }
        }
    }

    public BufferedImage getFontSheet() {
        return FONTSHEET;
    }

    public BufferedImage getLetter(int x, int y) {
        return FONTSHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage getFont(char letter) {
        int value = letter - 65;            //subtract 65 as it corresponds to the array index of the letters
        int x;
        int y;

        if (letter == '.') {
            x = 8;
            y = 2;
        } else if (letter == '?') {
            x = 1;
            y = 4;
        } else if (letter == '!') {
            x = 8;
            y = 4;
        } else if (letter == ',') {
            x = 2;
            y = 4;
        } else if (letter == 39) {
            x = 7;
            y = 4;
        } else if (letter == ':') {
            x = 4;
            y = 4;
        } else if (letter == '*') {
            x = 3;
            y = 4;
        } else {
            x = value % wLetter;
            y = value / wLetter;
        }

        return getLetter(x, y);
    }
}

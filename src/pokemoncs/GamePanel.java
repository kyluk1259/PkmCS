/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemoncs;

import GameState.GameStateManager;
import Utility.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Kyle's PC
 */
public class GamePanel extends JPanel implements Runnable {

    //screen dimensions
    public static int width = 400;
    public static int height = 320;
    public static int scale = 2;

    //game run thread
    public Thread thread;
    private boolean running = false;

    //images
    private BufferedImage image;
    private Graphics2D g;

    //input method
    private KeyHandler key;

    //game state
    private GameStateManager gsm;

    public GamePanel() {
        width = width * scale;
        height = height * scale;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    //Add notifier for JPanel in the window
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    public void init() {
        running = true;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();
        key = new KeyHandler(this); //initialize key handler

        gsm = new GameStateManager();
    }

    public void run() {
        init();

        final double REFRESH = 60; //Refresh rate (FPS = refresh rate / target fps)
        final double UPDATE = 1000000000 / REFRESH; //Time before each update

        final int BEFORERENDER = 5; // force update before render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 12;
        final double TBR = 1000000000 / TARGET_FPS; //Time before render

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int oldFrameCount = 0;

        while (running) {
            double now = System.nanoTime();
            int updateCount = 0;
            while (((now = lastUpdateTime) > UPDATE) && (updateCount < BEFORERENDER)) {
                update();
                input(key);
                lastUpdateTime += UPDATE;
                updateCount++;
            }

            if (now - lastUpdateTime > UPDATE) {
                lastUpdateTime = now - UPDATE;
            }

            input(key);
            render();
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {  //Only update frame count when there is a difference
                    System.out.println("New Time:" + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < TBR && now - lastUpdateTime < UPDATE) {
                Thread.yield();

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("Error with thread yield");
                }
                now = System.nanoTime();
            }

        }
    }

    private int x = 0;

    public void update() {
        gsm.update();
    }

    public void input(KeyHandler key) {
        gsm.input(key);
    }

    public void render() {
        if (g != null) {
            g.setColor(new Color(66, 134, 244));
            g.fillRect(0, 0, width, height);
            gsm.render(g);
        }
    }

    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
    }

    public static int getW() {
        return width;
    }

    public static int getH() {
        return height;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import Graphics.Animation;
import Graphics.Sprite;
import Utility.Vector2d;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Kyle's PC
 */
public class Pokemon {

    private String pokemon;
    private int currentAnimation;
    private int maxHp, hp, att, def, spAtt, spDef, spd, exp, lvl;
    private float evasion, accuracy, captureRate;
    private Move moves[];
    private Type typeA, typeB;
    private Status currentStatus;
    private BufferedImage fSprite, bSprite;
    private Animation ani;

    //One type, no status, remember to add type and moves once implemented
    public Pokemon(String name, int maxHealth, int health, int attack, int defense, int spAttack, int spDefense, int speed, int experience, int level, float capture, Sprite sprite, Sprite backSprite) {
        pokemon = name;
        maxHp = maxHealth;
        hp = health;
        att = attack;
        def = defense;
        spAtt = spAttack;
        spDef = spDefense;
        spd = speed;
        exp = experience;
        lvl = level;
        captureRate = capture;
        fSprite = sprite.getSpriteSheet();
        bSprite = backSprite.getSpriteSheet();
        ani = new Animation();
    }

    //One type, status effect
    public Pokemon(String name, int maxHealth, int health, int attack, int defense, int spAttack, int spDefense, int speed, int experience, int level, float capture, Move moveset[], Type tA, Sprite sprite, Sprite backSprite, Status status) {
        pokemon = name;
        maxHp = maxHealth;
        hp = health;
        att = attack;
        def = defense;
        spAtt = spAttack;
        spDef = spDefense;
        spd = speed;
        exp = experience;
        lvl = level;
        captureRate = capture;
        moves = moveset;
        typeA = tA;
        fSprite = sprite.getSpriteSheet();
        bSprite = backSprite.getSpriteSheet();
        currentStatus = status;
    }

    //Two types, no status
    public Pokemon(String name, int maxHealth, int health, int attack, int defense, int spAttack, int spDefense, int speed, int experience, int level, float capture, Move moveset[], Type tA, Type tB, Sprite sprite, Sprite backSprite) {
        pokemon = name;
        maxHp = maxHealth;
        hp = health;
        att = attack;
        def = defense;
        spAtt = spAttack;
        spDef = spDefense;
        spd = speed;
        exp = experience;
        lvl = level;
        captureRate = capture;
        moves = moveset;
        typeA = tA;
        typeB = tB;
        fSprite = sprite.getSpriteSheet();
        bSprite = backSprite.getSpriteSheet();
    }

    //Two types, status effect
    public Pokemon(String name, int maxHealth, int health, int attack, int defense, int spAttack, int spDefense, int speed, int experience, int level, Move moveset[], float capture, Type tA, Type tB, Sprite frontSprite, Sprite backSprite, Status status) {
        pokemon = name;
        maxHp = maxHealth;
        hp = health;
        att = attack;
        def = defense;
        spAtt = spAttack;
        spDef = spDefense;
        spd = speed;
        exp = experience;
        lvl = level;
        captureRate = capture;
        moves = moveset;
        typeA = tA;
        typeB = tB;
        fSprite = frontSprite.getSpriteSheet();
        bSprite = backSprite.getSpriteSheet();
        currentStatus = status;
    }

    //All getters are below
    public String getName() {
        return pokemon;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAtt() {
        return att;
    }

    public int getDef() {
        return def;
    }

    public int getSpAtt() {
        return spAtt;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getSpd() {
        return spd;
    }

    public int getExp() {
        return exp;
    }

    public int getLvl() {
        return lvl;
    }

    public float getEvasion() {
        return evasion;
    }

    public float getAccuracy() {
        return accuracy;
    }
    
    public float getCaptureRate(){
        return captureRate;
    }

    public Move getMove(int i) {
        return moves[i];
    }

    public Type getTypeA() {
        return typeA;
    }

    public Type getTypeB() {
        return typeB;
    }

    public Status getStatus() {
        return currentStatus;
    }

    public BufferedImage getSprite(int i) {
        if (i == 0) {
            return fSprite;
        } else {
            return bSprite;
        }
    }
    //-------------------------------------------------------------

    //All setters are below
    public void setMaxHp(int diff) {
        maxHp += diff;
    }

    public void setHp(int diff) {
        hp += diff;
    }

    public void setAtt(int diff) {
        att += diff;
    }

    public void setDef(int diff) {
        def += diff;
    }

    public void setSpAtt(int diff) {
        spAtt += diff;
    }

    public void setSpDef(int diff) {
        spDef += diff;
    }

    public void setSpd(int diff) {
        spd += diff;
    }

    public void setExp(int gain) {
        exp += gain;
    }

    public void setLvl(int increase) {
        lvl += increase;
    }

    public void setEvasion(float evas) {
        evasion = evasion * evas;
    }

    public void setAccuracy(float acc) {
        accuracy = accuracy * acc;
    }

    public void setStatus(Status status) {
        currentStatus = status;
    }

    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        ani.setFrames(frames);
        ani.setDelay(delay);
    }
    //------------------------------------------------------

    public void render(Graphics2D g, int i) {
        if (i == 0) {
            Sprite.drawImage(g, this.getSprite(i), new Vector2d(580, 180), 130, 140);
        } else {
            Sprite.drawImage(g, this.getSprite(i), new Vector2d(130, 300), 160, 180);
        }
    }
}

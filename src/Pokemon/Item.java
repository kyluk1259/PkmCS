/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import static GameState.PlayState.player;

/**
 *
 * @author Kyle's PC
 */
public abstract class Item {
    protected String name;
    protected int heal;
    protected Status cure;
    protected float captureChance;
    protected int salePrice;
    protected int purchasePrice;
    
    public Item(String item){
        name = item;
    }
    
    public String getName(){
        return name;
    }
}

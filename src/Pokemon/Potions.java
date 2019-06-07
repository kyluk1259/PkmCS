/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

/**
 *
 * @author Kyle's PC
 */
public class Potions extends Item {
    
    public Potions(String item){
        super(item);
    if(item.equalsIgnoreCase("Hyper Potion")){
            newHyperPotion();
        }else if(item.equalsIgnoreCase("Full Restore")){
            newFullRestore();
        }
    }
    
    private void newHyperPotion(){
        
    }
    
    private void newFullRestore(){
        
    }
}

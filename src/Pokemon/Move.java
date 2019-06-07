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
public class Move {
    private Type type;
    private int power, accuracy;
    private float statusEffect;
    private Status status;
    private String moveName;
    
    public String getName(){
        return moveName;
    }
}

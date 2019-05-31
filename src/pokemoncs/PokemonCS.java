/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemoncs;

import javax.swing.JFrame;

/**
 *
 * @author Kyle's PC
 */
public class PokemonCS {

    /**
     * @param args the command line arguments
     */
    public static GamePanel game;
    
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame gameWindow = new JFrame("Pokemon CS");
        game = new GamePanel();
        gameWindow.add(game);
        gameWindow.setResizable(false);
        gameWindow.setSize(400, 320);
        gameWindow.pack();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }
    
}

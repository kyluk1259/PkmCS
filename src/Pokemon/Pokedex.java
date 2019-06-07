/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import Graphics.Sprite;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kyle's PC
 */
public class Pokedex{
    
    public static List<Pokemon> pokedex = new ArrayList<Pokemon>();
    private int pokemonValue;
    
    public Pokedex(){
        loadPokemon();
    }
    
    public Pokedex(int pkmn){
        pokemonValue = pkmn;
    }
    
    //Add Types and Moves
    private void loadPokemon(){
        

    /*0. Pikachu*/ pokedex.add(new Pokemon("Pikachu", 100, 100, 40, 60, 104, 30, 90, 0, 40, 0.08f, new Sprite("Pokemon/pikachuFront.gif"), new Sprite("Pokemon/pikachuBack.gif")));
    /*1. Charizard*/
    /*2. Weaville*/
    /*3. Scizor*/
    /*4. Tyrannitar*/
    /*5. Gyarados*/
    /*6. Swampert*/
    /*7. Snorlax*/
    /*8. Raichu*/
    /*9.*/
    /*10.*/
    /*11.*/
    /*12.*/
    /*13.*/
    /*14.*/
    /*15.*/
    /*16.*/
    /*17.*/
    /*18.*/
    /*19.*/
    /*20.*/

        
        
    }
}

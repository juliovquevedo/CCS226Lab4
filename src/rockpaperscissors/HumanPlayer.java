/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

/**
 *
 * @author julioquevedo
 */
public class HumanPlayer extends Player {
    //String name;
    
    public HumanPlayer(String name) {
        setName(name);
    }

    @Override
    public int generatePlay() {
        return getChoice();
    }
    
    
}

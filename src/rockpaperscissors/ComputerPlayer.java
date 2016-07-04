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
public class ComputerPlayer extends Player {
    
    public ComputerPlayer(String name) {
        setName(name);
    }

    @Override
    public int generatePlay() {
         return (int)(Math.random() * 3) + 1;
    }
    
}

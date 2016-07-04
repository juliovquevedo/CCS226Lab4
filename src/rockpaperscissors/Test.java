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
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer("Victor");
        Scanner input = new Scanner(System.in);
        Player player2 = new ComputerPlayer("R2D2");
        
        System.out.println(player1.getName());
        player1.setName("Quevedo");
        System.out.println(player1.getName());
        System.out.println("Enter choice 0, 1, 2:");
        player1.setChoice(input.nextInt());
        System.out.println(player1.generatePlay());
        
        for(int i = 0; i < 10; i++) {
            System.out.print(player2.generatePlay() + " ");
        }
    }
    
}

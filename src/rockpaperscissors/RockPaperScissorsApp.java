/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

/**
 *
 * @author julioquevedo
 * 
 * 
 */
import javax.swing.JOptionPane;

public class RockPaperScissorsApp {
    public static void main(String[] args) {
        
        
        int numberOfPlayers = -1;
        String again = "y";
        
        String name1 = "";
        String name2 = "";
        int winner1 = 0;
        int winner2 = 0;
        int ties = 0;
        String name = "";
        
        
        
        // Try catch catches NumberFormatException, do loop lets the user
        // continue without terminating the program and also checks for out of 
        // range input.
        do {
        try{
            numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "ROCK PAPER SCISSORS GAME\n" +
                "1 or 2 players:"));
            if(numberOfPlayers != 1 && numberOfPlayers != 2)
                JOptionPane.showMessageDialog(null, "Only numbers 1 or 2 can be entered.");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Only numbers 1 or 2 can be entered.");
        }
        } while(numberOfPlayers != 1 && numberOfPlayers != 2);
        
        
        
        // No exception handling, since a string can take a null value.  If that
        // string is used anywhere else in the program an exception will be
        // thrown.  Instead keep possible problem at point of input.
        if(numberOfPlayers == 1) {
            do{
            name1 = JOptionPane.showInputDialog(null, "Please enter player's name:");
            }while(name1 == null || name1.equals(""));
            name2 = getComputerName();
        }
        if(numberOfPlayers == 2) {
            do{
            name1 = JOptionPane.showInputDialog(null, "Please enter player 1 name:");
            }while(name1 == null || name1.equals(""));
            do{
            name2 = JOptionPane.showInputDialog(null, "Please enter player 2 name:");
            }while(name2 == null || name2.equals(""));
        }
    
        
        
        // Main body of the program.
        while(again.equalsIgnoreCase("y")) {
            
            if(numberOfPlayers == 1) {
                Player player1 = new HumanPlayer(name1);
                Player player2 = new ComputerPlayer(name2);
               
                
                // try catch catches NumberFormatException, do loop checks for out
                // of range values.
                do{
                try{
                player1.setChoice(Integer.parseInt(JOptionPane.showInputDialog(null,
                       "Please make your choice\n" +
                       "[1]Rock\n[2]Paper\n[3]Scissors\n")));
                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Only numbers 1, 2 or 3 can be entered.");
                }
                }while(player1.getChoice() != 1 && player1.getChoice() != 2 && player1.getChoice() != 3);
                
                
                
                
                // Fun part of the program. If computer is Darth Vader the computer
                // always wins.  Not to worry, Darth Vader only plays 10% of the time.
                if(name2.equals("Darth Vader"))
                    player2.setChoice((player1.getChoice() % 3) + 1);
                else
                    player2.setChoice(player2.generatePlay());
               
                JOptionPane.showMessageDialog(null, showResults(name1, name2, player1.getChoice(), player2.getChoice()));
               
                name = getWinner(name1, name2, player1.getChoice(), player2.getChoice());
               
                
                // Keep track of wins for both players.
                if(name.equals(name1))
                    winner1++;
                else if(name.equals(name2))
                    winner2++;
                else
                    ties++;
               
            }
            
            else if(numberOfPlayers == 2) {
                Player player1 = new HumanPlayer(name1);
                Player player2 = new HumanPlayer(name2);
                
                
                
                // try catch catches NumberFormatException, do loop checks for out
                // of range values.
                do{
                try{
                player1.setChoice(Integer.parseInt(JOptionPane.showInputDialog(null,
                       player1.getName() + " make your choice\n" +
                       "[1]Rock\n[2]Paper\n[3]Scissors\n")));
                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Only numbers 1, 2 or 3 can be entered.");
                }
                }while(player1.getChoice() != 1 && player1.getChoice() != 2 && player1.getChoice() != 3);
                
                
                
                // try catch catches NumberFormatException, do loop checks for out
                // of range values.
                do{
                try{
                player2.setChoice(Integer.parseInt(JOptionPane.showInputDialog(null,
                       player2.getName() + " make your choice\n" +
                       "[1]Rock\n[2]Paper\n[3]Scissors\n")));
                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Only numbers 1, 2 or 3 can be entered.");
                }
                }while(player2.getChoice() != 1 && player2.getChoice() != 2 && player2.getChoice() != 3);
                
                JOptionPane.showMessageDialog(null, showResults(name1, name2, player1.getChoice(), player2.getChoice()));
               
                name = getWinner(name1, name2, player1.getChoice(), player2.getChoice());
               
                
                // Keep track of wins for both players.
                if(name.equals(name1))
                    winner1++;
                else if(name.equals(name2))
                    winner2++;
                else
                    ties++;
            }
            
            // No exception handling. Do loop check for null value or empty string.
            do{
            again = JOptionPane.showInputDialog(null, "Do you want to continue? (Y/N)");
            }while(again == null || again.equals(""));
        }
        
        JOptionPane.showMessageDialog(null,"" + name1 + " " + winner1 + " wins\n" +
                                                name2 + " " + winner2 + " wins\n" +
                                                ties + " ties.");
        if(name2.equals("Darth Vader"))
            JOptionPane.showMessageDialog(null, "Come to the dark side " + name1 +
                    ". You will always win Rock Paper Scissors.");
    }
    
    
    // Instead of naming the computer "Computer" I dedided to have some fun:
    // 90% of the time the user will play R2D2 or C-3PO and 10% of the time
    // Darth Vader
    public static String getComputerName() {
        int name = (int)(Math.random() * 100);
        
        if(name < 45)
            return "R2D2";
        else if (name >= 45 && name < 90)
            return "C-3PO";
        else
            return "Darth Vader";
    }
    
    
    // Send results to JOptionPane
    public static String showResults(String name1, String name2, int choice1, int choice2) {
        String result = name1;
        if(choice1 == 1)
            result = result + ": Rock\n";
        else if(choice1 == 2)
            result = result + ": Paper\n";
        else
            result = result + ": Scissors\n";
        
        result = result + name2;
        if(choice2 == 1)
            result = result + ": Rock\n";
        else if (choice2 == 2)
            result = result + ": Paper\n";
        else
            result = result + ": Scissors\n";
        
        return result + "\nWinner: " + getWinner(name1, name2, choice1, choice2);
    }
    
    
    // Determines winner of each round.
    public static String getWinner(String name1, String name2, int choice1, int choice2) {
        if(choice1 == choice2)
            return "It's a tie.";
        if((choice1 == 1 && choice2 == 3) ||
           (choice1 == 2 && choice2 == 1) ||
           (choice1 == 3 && choice2 == 2))
            return name1;
        else
            return name2;
    }
    
}

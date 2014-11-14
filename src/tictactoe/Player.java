package tictactoe;

import java.util.Scanner;

/**
 * Player class - each player is given a game token.
 * 
 * Configuration for tokens are in TicTacToe.java.
 * 
 * @author Darshan Prasad
 */
public class Player {
    private char token;
    
    public Player() {
        
    }
    
    /**
     * Constructor that accepts player's character token.
     * 
     * @param c 
     */
    public Player(char c) {
        token = c;
    }
    
    public char getToken() {
        return token;
    }
    
    public void setToken(char c) {
        this.token = c;
    }
    
    /**
     * Accept user input for the square that they would like to play.
     * 
     * @return 
     */
    public char selectSquare() {
        System.out.println("Please choose a square to place your token, Player " + token + ": ");
        Scanner b = new Scanner(System.in);
        
        return b.next().charAt(0);
    }
}

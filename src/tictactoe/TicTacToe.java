package tictactoe;

import java.util.Scanner;

/**
 * A simple command line game of TicTacToe!
 * 
 * @author Darshan Prasad
 */
public class TicTacToe {
    
    // The following player tokens are configurable:
    public static final char TOKEN_A = 'X';
    public static final char TOKEN_B = 'O';
    
    private final GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
    
    public TicTacToe() {
       System.out.println("Welcome to TicTacToe!\n");
       
       gameBoard = new GameBoard();
    }
    
    /**
     * Alternate turns until someone wins or the board is full.
     */
    public void playGame() {
       choosePlayerTokens();
       
       currentPlayer = player1;
       
       while (!gameBoard.hasWin() && !gameBoard.isFull()) {
           gameBoard.drawBoard();
           
           char desiredSquare;
           do {
               desiredSquare = currentPlayer.selectSquare();
           } while (!gameBoard.makeMove(desiredSquare, currentPlayer.getToken()));
           
           changePlayers();
       }

       finishGame();
    }
    
    /**
     * Print the result of the game.
     */
    public void finishGame() {        
       if (gameBoard.hasWin()) {
           changePlayers();

            gameBoard.drawBoard();
            if (currentPlayer == player1) {
                System.out.println("\n\nPlayer " + player1.getToken() + " wins!");
            } else {
                System.out.println("\n\nPlayer " + player2.getToken() + " wins!");
            }
       } else {
           System.out.println("\n\nIt's a draw!");
       }
       
    }
    
    /**
     * Accept user input for Player 1's token.  Player 2 is automatically given the remaining token.
     */
    public void choosePlayerTokens() {
        char c = '_';
        
        do {
            System.out.println("Please choose token '" + TOKEN_A + "' or '" + TOKEN_B + "' for Player 1: ");
            Scanner b = new Scanner(System.in);
            c = b.next().charAt(0);
        } while ((c = Character.toUpperCase(c)) != TOKEN_A && c != TOKEN_B);
        
        player1 = new Player(c);
        
        player2 = player1.getToken() == TOKEN_A ? new Player(TOKEN_B) : new Player(TOKEN_A);
        
        System.out.println();
        System.out.println("Player 1 is token: " + player1.getToken());
        System.out.println("Player 2 is token: " + player2.getToken()); 
    }
    
    /**
     * Update currentPlayer reference.
     */
    public void changePlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }  
}

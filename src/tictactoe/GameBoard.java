package tictactoe;

/**
 * GameBoard class to represent the state of the game.
 * 
 * @author Darshan Prasad
 */
public class GameBoard {
    
    private static final int size = 3;
    private final char[][] board;
    
    /**
     * Initialize 2D array with numbers for each square.
     */
    public GameBoard() {
        board = new char[size][size];
        int count = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Character.forDigit(count, 10);
                count++;
            }
        }
    }
    
    /**
     * Print board in a readable format. ASCII art!
     */
    public void drawBoard() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("\t\t");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
                if (j != (size - 1)) {
                    System.out.print(" | ");
                } else {
                    System.out.print("\n");
                }
            }
            
            System.out.println("\t\t----------");
        }
    }
    
    /**
     * Check the board if it is full.
     * 
     * @return Boolean indicating whether there are any squares left to play.
     */
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != TicTacToe.TOKEN_A && board[i][j] != TicTacToe.TOKEN_B) 
                    return false;
            }
        }
        
        return true;
    }
    
    /**
     * Check the board for all possible ways to win the game.
     * 
     * @return Boolean indicating whether the game has been won or not.
     */
    public boolean hasWin() {      
        // Check down
        for (int j = 0; j < size; j++) {
            int i = 0;
            char c = board[i][j];
            boolean downWinPossible = true;
            
            while (i <= (size - 1) && downWinPossible) {
                if (board[i][j] != c) downWinPossible = false;
                i++;
            }
            
            if (downWinPossible) return true;            
        }
        
        // Check across
        for (int i = 0; i < size; i++) {
            int j = 0;
            char c = board[i][j];
            boolean acrossWinPossible = true;
            
            while (j <= (size - 1) && acrossWinPossible) {
                if (board[i][j] != c) acrossWinPossible = false;
                j++;
            }
            
            if (acrossWinPossible) return true;
        }
        
        // Check diagonal
        
        // Check left to right:
        char token = board[0][0];
        int n = 0;
        char current;
        
        boolean leftToRightDiagonalWinPossible = true;
        while (leftToRightDiagonalWinPossible && n < size) {
            current = board[n][n];
            if (current != token) leftToRightDiagonalWinPossible = false;
            n++;
        }
        
        if (leftToRightDiagonalWinPossible) return true;
        
        // Check right to left:
        n = size - 1;
        int r = 0;
        token = board[r][n];
        
        boolean rightToLeftDiagonalWinPossible = true;
        while (rightToLeftDiagonalWinPossible && n >= 0 && r < size) {
            current = board[r][n];
            if (current != token) rightToLeftDiagonalWinPossible = false;
            r++;
            n--;
        }
        
        return rightToLeftDiagonalWinPossible;
    }
    
    /**
     * Accept the number of the square the player wishes to play, and the player's token.
     * Update the board with the player's move.
     * 
     * @param square
     * @param token
     * @return Boolean indicating whether the move was successful.
     */
    public boolean makeMove(char square, char token) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == square) {
                    board[i][j] = token;
                    return true;
                }
            }
        }
        
        return false;
    }
}

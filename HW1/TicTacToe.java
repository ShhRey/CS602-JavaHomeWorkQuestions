import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	// Enum to represent the possible states of each Cell on the Board
	private enum Cell { EMPTY, X, O }
	
	// 2D Array representing the TicTacToe Board
	private Cell[][] board;
	
	// 
	private boolean isSinglePlayer;
	
	// Constructor to initialize the 3x3 Board with Empty Cells
	public TicTacToe(boolean isSinglePlayer) {
		board = new Cell[3][3];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				board[i][j] = Cell.EMPTY;
			}
		}
		this.isSinglePlayer = isSinglePlayer;
	}
	
	// Method to Display the current state of Board
	public void displayBoard() {
	    System.out.println("--------------------------");
	    for (int i = 0; i < 3; i++) {
	        System.out.print(" | ");
	        for (int j = 0; j < 3; j++) {
	            System.out.print(board[i][j] + " | ");
	        }
	        System.out.println("\n--------------------------");
	    }
	}
	
	// Method for New Moves played by Players
    public boolean makeMove(int row, int col, Cell player) {
    	// Check if the specified cell is already occupied
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != Cell.EMPTY) {
            System.out.println("Invalid move. The cell is not empty.");
            return false;
        }
        board[row][col] = player;
        return true;
    }
    
    // Method to Check Rows, Columns or Diagonals for a Winning Condition
    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != Cell.EMPTY) ||
                (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != Cell.EMPTY)) {
                return true;
            }
        }
        // Check for Diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Cell.EMPTY) ||
            (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Cell.EMPTY)) {
            return true;
        }
        return false;
    }
    
    // Method to Check if Winner is decided or not, Otherwise game ends in a Draw !!
    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Make Random Moves to be automatically made by the Computer
    public void computerMove() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (board[row][col] != Cell.EMPTY);
        makeMove(row, col, Cell.O);
        System.out.println("Computer placed an O in position (" + row + ", " + col + ")");
    }
    
    
    // Main Method to play the TicTacToe Game
    public void playGame(int startingPlayer) {
        int player = startingPlayer; 
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        	// Display the Current State of the board
            displayBoard();
            if (isSinglePlayer && player == 2) {
            	computerMove();
            }
            else {
            	System.out.print("Player " + player + "'s turn. Enter Row: ");
            	int row = scanner.nextInt();
            	System.out.print("Player " + player + "'s turn. Enter Column: ");
                int col = scanner.nextInt();
                Cell currentPlayer = (player == 1) ? Cell.X : Cell.O;
                if (!makeMove(row, col, currentPlayer)) {
                    continue;
                }
            }
            if (checkWinner()) {
                displayBoard();
                System.out.println("Player " + player + " wins!");
                break;
            } else if (checkDraw()) {
                displayBoard();
                System.out.println("Oops! It's a draw.");
                break;
            }
            player = (player == 1) ? 2 : 1;
        }
        scanner.close();
    }

	public static void main(String[] args) {
		// Create an instance of the TicTacToe class for starting the Game
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe Game !");
		System.out.println("Choose Game Mode: 1 for v/s Player2, 2 for v/s Computer");
		int gameMode = scanner.nextInt();
		if (gameMode == 1 || gameMode == 2) {
			boolean isSinglePlayer = (gameMode == 2);
			System.out.print("Do you want to go First (1) or Second (2): ");
			int choice = scanner.nextInt();
			if (choice != 1 && choice != 2) {
				System.out.println("Invalid Choice Entered. Please Enter either '1' or '2'.");
				choice = scanner.nextInt();
			}
			
			// Create an Instance of the TicTacToe Game
			TicTacToe game = new TicTacToe(isSinglePlayer);
			game.playGame(choice);
			scanner.close();
		}
		else {
			System.out.println("Invalid Choice Entered. Please Enter either '1' or '2'.");
		}
	}
}

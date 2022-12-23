/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe2;

/**
 *
 * @author mahmo
 */
import java.util.Random;
import java.util.Scanner;

public class TicTacToe2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//lines , + ,- 
		char[][] border = {{' ', ' ', ' '},
				  {' ', ' ', ' '}, 
				  {' ', ' ', ' '}};
		
		printBoard(border);
		
		while (true) {
			playerTurn(border, scanner);
			if (isGameFinished(border)){
				break;
			}
			printBoard(border);
			
			computerTurn(border);
			if (isGameFinished(border)){
				break;
			}
			printBoard(border);
		}
		scanner.close();
	}


	private static boolean isGameFinished(char[][] border) {
		
		if (Wins(border, 'X')) {	
			printBoard(border);
			System.out.println("Player wins!");
			return true;
		}
		
		if (Wins(border, 'O')) {	
			printBoard(border);
			System.out.println("Computer wins!");
			return true;
		}
		
		for (int i = 0; i < border.length; i++) {
			for (int j = 0; j < border[i].length; j++) {
				if (border[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(border);
		System.out.println("The game ended in a tie!");
		return true;
	}


	private static boolean Wins(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}


	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (Computer(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + computerMove);
		placeMove(board, Integer.toString(computerMove), 'O');
	}


	private static boolean Computer (char[][] board, String position) {
		switch(position) {
			case "1":
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void playerTurn(char[][] board, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if (Computer(board, userInput)){
				break;
			} else {
				System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(board, userInput, 'X');
	}


	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	
	
	private static void printBoard(char[][] border) {
		System.out.println(border[0][0] + "|" +  border[0][1] + "|" +  border[0][2] );
		System.out.println("-+-+-");
		System.out.println(border[1][0] + "|" +  border[1][1] + "|" +  border[1][2] );
		System.out.println("-+-+-");
		System.out.println(border[2][0] + "|" +  border[2][1] + "|" +  border[2][2] );
	}
	
}
  
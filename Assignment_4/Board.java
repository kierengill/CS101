import java.util.*;
import java.io.*;

//Create the Board class
public class Board{
	//Instance variables for the Board class
	public String[][] board;
	public int row;
	public int column;
	public String[] keyWords;
	public int numberOfWords;
	public int correctGuesses;
	//Constructor
	public Board(String[][] board, int row, int column, String[] keyWords){
		this.board = board;
		this.row = row;
		this.column = column;
		this.keyWords = keyWords;
		this.numberOfWords = keyWords.length;
		this.correctGuesses = 0;
	}
	//Print the board
	public void printBoard() {
		for (int i = 0; i < row; i ++) {
			horizontalBorder();
			System.out.print(" ");
			for (int j = 0; j < column; j ++) {
				System.out.print("| "+ board[i][j]+" ");
				}
			System.out.println("|");
		}
		horizontalBorder();
	}
	//Method in printBoard
	//Creates horizontal border
	public void horizontalBorder() { 
		System.out.print(" +");
		for (int i = 0; i < row; i ++) {
			System.out.print("---+");
		}
		System.out.println();
	}
	//Checks if player guess is in the keywords
	public boolean checkGuess(String guess){
		//Create a checker and set it to zero
		int checker = 0;
		//Create a for loop
		//If the guess is equal to any of the keywords
			//Remove the keywords from the array
			//Make the checker equal to 1
			//break the loop
		for (int i=0; i < keyWords.length; i ++) {
			if (guess.equals(keyWords[i])){
				keyWords[i] = null;
				checker = 1;
				break;
			}
		}
		//If the checker is equal to 1
			//Add 1 to the correct guesses counter
			//Let user know!
			//Return true
		if (checker == 1){
			correctGuesses ++;
			System.out.println("Word found... Good job!");
			System.out.println();
			return true;
		//Else
			//Return false
		}else{
			System.out.println("Wrong guess!");
			System.out.println();
			return false;
		}
	}
	//Condition for game to end
	public boolean gameOver(){
		//If the number of correct guesses is equal to the initial number of keywords
			//Return true
		if (correctGuesses == numberOfWords){
			return true;
		//Else
			//Return false
		}else{
			return false;
		}
	}
	//Method to capitalize the word
	public void capitalizeWord(String guess){
		//Nested for loops to iterate through all the rows and columns in the board
		for (int r = 0; r < row; r++){
			for (int c = 0; c < column; c++){
				//If the first letter of the user guess is the same as the location on the board
					//Check the direction of the word using callDirection()
				if ((board[r][c].toLowerCase().charAt(0)) == (guess.charAt(0))){
					checkDirection(guess, r , c);
				}
			}
		}
	}
	//Method in capitalizeWord()
	//Method to check the direction of the word and capitalize the word
	public void checkDirection(String guess, int r, int c){
		//Create rowDirArr and colDirArr
		//The combination of these numbers will be the direction in which to search
		//For example:
			//[0,1] means to take the value on the column to the right
			//[-1,-1] means to take the value on the column to the left and the row upwards
		int[] rowDirArr = { 0, 0, 1, -1, 1, 1, -1, -1 };
		int[] colDirArr = { 1, -1, 0, 0, 1, -1, 1, -1 };
		char character;
		int index;
		//Create a for loop
		//rowLoc and colLoc are the locations of the letter from the capitalizedWord function
		//Get the character at that location on the board
		for (int i = 0; i < 8; i++){
			int rowLoc = r;
			int colLoc = c;
			index = 0;
			character = board[rowLoc][colLoc].toLowerCase().charAt(0);
			//While the character is equal to that of its equivalent index position in the guess word
			//Move in the direction determined by the rowDirArr and colDirArr arrays
			while (character == (guess.charAt(index))){
				rowLoc += rowDirArr[i];
				colLoc += colDirArr[i];
				//If the row or column coordinates are out of the grid
					//break
				if ((rowLoc < 0) || (rowLoc >= row) || (colLoc < 0) || (colLoc >= column)){
				break;
				}
				//Get the character on the new location of the board
				//Add 1 to the index and repeat
				character = board[rowLoc][colLoc].toLowerCase().charAt(0);
				index++;
				//If the index is the index length of the guessWord and
				//the character on the board is equal to the last index position of the guessWord
				//Capitalize the whole word
					//Do so by using a while loop and going backwards,
					//turning each letter uppercase as you go backwards
				if ((index == (guess.length() - 1)) && (character == (guess.charAt(index)))){
					while (index >= 0){
						board[rowLoc][colLoc] = board[rowLoc][colLoc].toUpperCase();
						rowLoc -= rowDirArr[i];
						colLoc -= colDirArr[i];
						index--;
					}
					return;
				}
			}
		}
	}
}
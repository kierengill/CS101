import java.util.*;
import java.io.*;

public class wordSearch{
	//Throws keyword to indicate that the following code could
	//throw an exception
	public static void main(String[] args) throws Exception{
		//New scanner instance
		Scanner input = new Scanner(System.in);
		//Call the randomCSVName method to generate a pseudorandom filename
		String fileName = randomCSVName();
		//Reads my file
		BufferedReader myFile = new BufferedReader(new FileReader(fileName));
		//Read the first line, split it by commas and store it in the header array
		String[] header = myFile.readLine().split(",");
		//Create an empty array for keywords
		String [] keywords = new String[header.length - 2];
		//Number of rows for board
	    int row = Integer.parseInt(header[0]);
	    //Number of columns for board
	    int column = Integer.parseInt(header[1]);
	    //Create board with dimensions
	    String[][] board = new String[row][column];
	    //Create an empty string variable to store each line
	    String myLine = "";
	    int i=0;
	    
	    //Entering csv contents into board array
	    //myLine becomes the topmost line of the csv file
	    //the line is split and entered into the corresponding index row in the board
	    //Loop continues until the csv file is fully read
	    while((myLine = myFile.readLine()) != null){
	    	String[] boardLine = myLine.split(",");
	    	board[i]= boardLine;
	    	i++;
	    }

	    //Entering keywords into keyword array
		for (int x = 2; x < header.length; x++) {
 			keywords[x-2] = header[x];
 		}
 		//Initialize myboard! An instance of the Board object
 		Board myBoard = new Board(board, row, column, keywords);

 		//Welcome user and prompt them to enter number of players
 		System.out.println("Welcome to Word Search!");
 		System.out.print("Enter the number of players: ");
 		String numberOfPlayers_str = input.nextLine();
 		int numberOfPlayers = Integer.parseInt(numberOfPlayers_str);
 		//Create an array which makes new Player instances based on player number
 		Player[] players = new Player[numberOfPlayers];
 		//Loop to intialize the players and give them their names
 		for (int n = 0; n < numberOfPlayers; n++){
 			players[n] = new Player(keywords, "Player "+Integer.toString(n));
 		}
 		System.out.println();
 		//Prints the board
		myBoard.printBoard();

		//Choose player to start by using the math random function
		int playerTurn = (int)(Math.random()*numberOfPlayers);
		System.out.println();
		System.out.println(players[playerTurn].name+" goes first!");

		//As long as the game isn't over, run the loop
 		while (!(myBoard.gameOver())){
 			System.out.println();
 			//Prompt player to enter their word
			System.out.print(players[playerTurn].name+", please enter your word: ");
 			String guess = input.nextLine();
 			//Checks if guess is valid
 			//If it is valid, next player's turn
 			//If the playerturn reaches the last player, start from the first player
 			if (! (validGuess(guess))){
 				playerTurn++;

 				 //Print out the score
 				System.out.println();
 				myBoard.printBoard();
 				System.out.println();
 				System.out.println("Score:");
 				//For loop to call each player's score
 				//Calls the showWordsGuessed() method from the Player class
 				for (int z = 0; z < numberOfPlayers; z++){
 					System.out.print(players[z].name+": " + Integer.toString(players[z].score)+" ");
 					players[z].showWordsGuessed();
 					System.out.println();
 				}
 				if (playerTurn == numberOfPlayers){
 					playerTurn = 0;
 				}
 				continue;
 			}
 			//Checks if guess is correct
 			//if it is correct, update score and capitalize word
 			if (myBoard.checkGuess(guess)){
 				players[playerTurn].updateScore(guess);
 				myBoard.capitalizeWord(guess);
 			}
 			myBoard.printBoard();
 			System.out.println();

 			//Print out the score
 			System.out.println("Score:");
 			//For loop to call each player's score
 			//Calls the showWordsGuessed() method from the Player class
 			for (int z = 0; z < numberOfPlayers; z++){
 				System.out.print(players[z].name+": " + Integer.toString(players[z].score)+" ");
 				players[z].showWordsGuessed();
 				System.out.println();

 			}
 			//Next turn
 			 //If the playerturn reaches the last player, start from the first player
 			playerTurn++;
 			if (playerTurn == numberOfPlayers){
 				playerTurn = 0;
 			}

 		}
 		//Game over
 		System.out.println();
 		System.out.println("Game Over!");

 		//Maximum score counter
 		int maxScore = 0;
 		//Make array to store possible winners
 		int[] winner = new int[numberOfPlayers];
 		//Create a for loop
 		//For any player who has a score bigger than the max score
 		//Add 1 to the location in the array that is their index number
 		for (int z = 0; z < numberOfPlayers; z++){
 			if (players[z].score > maxScore){
 				maxScore = players[z].score;
 				winner = new int[numberOfPlayers];
 				winner[z] = 1;
 			}
 			//If a player ties with the current max score
 				//Add 1 to their location in the array too
 			if (players[z].score == maxScore){
 				winner[z] = 1;
 			}
 		}
 		//Print out the winner/winners!
 		System.out.print("Winner(s) is/are: ");
 		for (int z = 0; z < numberOfPlayers; z++){
 			if (winner[z] != 0){
 				System.out.print(players[z].name+ " ");
 			}

 		}
 		System.out.println();
	}
	//Generate the CSV name randomly
	//Use the math random function to pick a number between 1 and 12
	public static String randomCSVName(){
		int fileNumber = (int)(Math.random()*12) + 1;
		String fileName = "board_" + Integer.toString(fileNumber) + ".csv";
		return fileName;
	}
	//Method to check if guesses are valid
	public static boolean validGuess(String guess){
		//If the guess is less than 3 characters
		//Invalid input, let user know
			//Return false
		if ((guess.length()) < 3) {
				System.out.println("Invalid input! Guesses must be at least 3 characters long...");
				return false;
			}
		//Create a for loop
			//iterate through the guessWord and make sure that it is lowercase
			//and doesn't contain numbers or spaces
		//Otherwise return false and let user know input is invalid
		for (int i = 0; i < (guess.length()); i++){
			char character = guess.charAt(i);
			int ascii = (int) character;

			if ((ascii >= 97) && (ascii<=122)){
				continue;
			} else {
				System.out.println("Invalid input! Guesses must consist only of lowercase characters...");
				return false;
			}
		}
		//If the guessWord passes the checks
		//Return true
		return true;
	}
}
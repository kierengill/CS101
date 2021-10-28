// Kieren Singh Gill, Section 3, 31 March 2021
/* 
This program is a battleship game!
The user plays against the computer,
and tries to sink the computer's
battleship in the least amount of
guesses!
*/

//Import scanner element
import java.util.Scanner;


public class Battleships {

	//I declared both the global variables as static so I could access them within methods
	//without having to declare them as inputs
	final static int DIMENSION = 10;
	final static int SHIP_SIZE = 4;
	
	public static void main(String[] args){
		//Create new scanner instance
		Scanner input = new Scanner(System.in);
		//Creating empty matrix of DIMENSION x DIMENSION
		String[][] matrix = new String[DIMENSION][DIMENSION];
		for (int row = 0; row < matrix.length; row ++){
			for (int column = 0; column < matrix.length; column ++){
				matrix[row][column] = (String)(" ");
			}
		}

		//Ship Location 
		//o = orientation, c = column, r = row
		//Orientation: 0 = vertical, 1 = horizontal
		//[o][c][r][r][r][r] or [o][r][c][c][c][c]
		int[] shipLocation = new int[SHIP_SIZE+2];
		//Generate the ship's location using the function shipCoords
		shipCoords(shipLocation);


		//Welcome the user to the program!
		System.out.print("Enter your name Player 1: ");
		String playerName = input.nextLine();
		System.out.println();
		returnArrayContents(matrix);
		System.out.println();
		String shipSize = String.valueOf(SHIP_SIZE);
		System.out.println("Welcome to Battleships! Above is the battlefield grid, where mayhem will ensue...");
		System.out.println("Somewhere in this grid, there is a ship of size "+ shipSize + "." );
		System.out.println("Find the ship to win!");
		System.out.println();

		//Create winning condition for the whiel loop
		int winningCondition = 0;
		//Initialize counter for guesses
		int guesses = 0;
		
		//Create a while loop
		//Loop ends when winningCondition is more than 0
		while (winningCondition == 0){
			//Prompt user to enter coordinate
			System.out.print("Enter coordinate to target (e.g. A1): ");
			String userCoord = input.nextLine();

			//If the coordinate isn't length 2, continue to next iteration of loop
			if (userCoord.length()!=2){
				System.out.println("Invalid input!");
				System.out.println();
				continue;
			}
			//Check if there are 2 characters
			//Convert each character to ASCII value
			try{
				String userColumn_str = userCoord.substring(0,1);
				String userRow_str = userCoord.substring(1,2);
				int userColumnASCII = userColumn_str.charAt(0);
				int userRowASCII = userRow_str.charAt(0);

				//Check if ASCII values fall within A-J and 0-9
				//Check if the square has been guessed before
				if (((userColumnASCII >=65) && (userColumnASCII <(65+DIMENSION))) && ((userRowASCII >=48) && (userRowASCII <(48+DIMENSION)))){
					if (matrix[userRowASCII-48][userColumnASCII-65] == "X" || matrix[userRowASCII-48][userColumnASCII-65] == "#"){
						System.out.println("This coordinate has been guessed before!");
						System.out.println();
						continue;
					}else{
						System.out.println();
					}
				//Let user know that input is invalid
				//Continue to next iteration of the loop
				} else{
					System.out.println("Invalid input!");
					System.out.println();
					continue;
				}
			//Catch the exception so that the error won't end the program
			//Let user know that input is invalid
			//Continue to next iteration of the loop
			} catch (Exception e){
				System.out.println("Invalid input!");
				System.out.println();
				continue;
			}

			//Now that input is valid, we count it as a guess!
			guesses++;

			//Get the ASCII values of the user's coordinates
			String userColumn_str = userCoord.substring(0,1);
			String userRow_str = userCoord.substring(1,2);
			int userColumnASCII = userColumn_str.charAt(0);
			int userRowASCII = userRow_str.charAt(0);

			//ship location [o][r][c][c][c][c] or [o][c][r][r][r][r]
			//Orientation: 0 = vertical, 1 = horizontal

			//ASCII conversion: A = 65, 0 = 48
			//If the ship is vertical | [o][c][r][r][r][r]
			//Get the coordinates
			if (shipLocation[0] == 0){
				int c1 = shipLocation[1];
				int r1 = shipLocation[2];
				int r2 = shipLocation[3];
				int r3 = shipLocation[4];
				int r4 = shipLocation[5];

				//If user column is equal to ship column
				if((userColumnASCII-65) == c1){
					//If user row is equal to any of the rows
					//Mark an X on the grid
					//Send a message to user
					if (((userRowASCII-48) == r1) || ((userRowASCII-48) == r2) || ((userRowASCII-48) == r3) || ((userRowASCII-48) == r4)){
						matrix[userRowASCII-48][userColumnASCII-65] = "X";
						returnArrayContents(matrix);
						System.out.println();
						System.out.println("BOOM! You hit the ship!");
						//If all spots are hit
						//Add 1 to the winningCondition
						if ((matrix[r1][c1] == "X") && (matrix[r2][c1] == "X") && (matrix[r3][c1] == "X") && (matrix[r4][c1] == "X")){
							winningCondition++;
						}
					//If it isn't
					//Let user know!
					}else{
						matrix[userRowASCII-48][userColumnASCII-65] = "#";
						returnArrayContents(matrix);
						System.out.println();
						System.out.println("Oops, you missed... Try again!");
					}
				//If it isn't
				//Let user know!
				}else{
					matrix[userRowASCII-48][userColumnASCII-65] = "#";
					returnArrayContents(matrix);
					System.out.println();
					System.out.println("Oops, you missed... Try again!");
				}

			//If the ship is horizontal | [o][r][c][c][c][c]
			//Get the coordinates
			} else {
				int r1 = shipLocation[1];
				int c1 = shipLocation[2];
				int c2 = shipLocation[3];
				int c3 = shipLocation[4];
				int c4 = shipLocation[5];
				//If user row is equal to ship row
				if((userRowASCII-48) == r1){
					//If user column is equal to any of the columns
					//Mark an X on the grid
					//Send a message to user
					if (((userColumnASCII-65) == c1) || ((userColumnASCII-65) == c2) || ((userColumnASCII-65) == c3) || ((userColumnASCII-65) == c4)){
						matrix[userRowASCII-48][userColumnASCII-65] = "X";
						returnArrayContents(matrix);
						System.out.println();
						System.out.println("BOOM! You hit the ship!");
						//If all spots are hit
						//Add 1 to winningCondition
						if ((matrix[r1][c1] == "X") && (matrix[r1][c2] == "X") && (matrix[r1][c3] == "X") && (matrix[r1][c4] == "X")) {
							winningCondition++;
						}
					//If it isn't
					//Let user know
					}else{
						matrix[userRowASCII-48][userColumnASCII-65] = "#";
						returnArrayContents(matrix);
						System.out.println();
						System.out.println("Oops, you missed... Try again!");
					}
				//If it isn't
				//Let user know
				}else{
					matrix[userRowASCII-48][userColumnASCII-65] = "#";
					returnArrayContents(matrix);
					System.out.println();
					System.out.println("Oops, you missed... Try again!");
				}

			}
			
			System.out.println();
		}
		

		//Convert ship size and guesses to double to calculate user accuracy
		double shipSizeDouble = (SHIP_SIZE);
		double guessesDouble = (guesses);
		double userAccuracy = ((shipSizeDouble/guessesDouble)*100);

		//Let user know that they won!
		//Let user know their score (number of guesses)
		//let user know their accuracy
		System.out.println("Congrats " + playerName + "! You sunk the whole battleship!");
		System.out.println("Score: " + (Integer.toString(guesses)) + " guesses");
		System.out.println("User Accuracy: " + (Double.toString(userAccuracy)) + "%");

	}	


	public static int[] shipCoords(int[] shipLocation){
		//Create battleship
		//Orientation: 0 = vertical, 1 = horizontal
		int orientation = (int)(Math.random() * 2);
		int row = (int)(Math.random()*DIMENSION);
		int column = (int)(Math.random()*DIMENSION);

		//Generate orientation, row and column
		//row and column have to be less then DIMENSION minus SHIP_SIZE so the ship won't go out of bounds
		//Keep generating values until the ship is in bounds
		while (((orientation == 1) && (column > DIMENSION - SHIP_SIZE)) || ((orientation == 0) && (row > DIMENSION - SHIP_SIZE))){
			orientation = (int)(Math.random() * 2);
			row = (int)(Math.random()*DIMENSION);
			column = (int)(Math.random()*DIMENSION);
		}


		//if Vertical then [o[c][r][r][r][r]
		if (orientation == 0){
			shipLocation[0] = orientation;
			shipLocation[1] = column;

			for (int i=2; i <= (SHIP_SIZE+1); i ++){
				shipLocation[i] = (row-2+i);
			}
		//if Horizontal then [o[r][c][c][c][c]
		} else {
			shipLocation[0] = orientation;
			shipLocation[1] = row;

			for (int i=2; i <= (SHIP_SIZE+1); i ++){
				shipLocation[i] = (column-2+i);
			}
		}

		return shipLocation;
	}

	//Creating loop for column numbers
	public static void columnNumbers(){
		for (int i = 65; i < (65+DIMENSION); i ++){
			System.out.print("   " + (char)(i));
		}
		System.out.println();
	}

	//Creating loop for horizontal border
	public static void horizontalBorder(){
		for (int width = 0; width < DIMENSION; width ++){
			if (width == 0){
				System.out.print(" +---");
			}else if (width == (DIMENSION-1)){
				System.out.print("+---+");
			}else{
				System.out.print("+---");
			}
		}
		System.out.println();
	}

	//Print individual matrix row in grid format
	public static void matrixRow(String[][] matrix, int i){
		System.out.print(i);
		for (int k = 0; k < DIMENSION; k++){
			if (k != (DIMENSION - 1)){
				System.out.print("| " + matrix[i][k] + " ");
			} else{
				System.out.print("| " + matrix[i][k] + " |");
			}
		}		
		System.out.println();
	}

	//Print the array contents in grid
	public static void returnArrayContents(String[][] matrix){
		for (int row = 0; row < DIMENSION; row ++){
			if (row==0){
				columnNumbers();
				horizontalBorder();
				matrixRow(matrix,row);
			} else if (row==(DIMENSION-1)){
				horizontalBorder();
				matrixRow(matrix,row);
				horizontalBorder();
			} else{
				horizontalBorder();
				matrixRow(matrix,row);
			}
		}
	}

}
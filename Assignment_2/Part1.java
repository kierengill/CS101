// Kieren Singh Gill, Section 3, 26 February 2021
/* 
This program makes the prettiest 
Kilim carpet you'll ever see.
*/

/*
The rug's dimensions are 33 by 43

I made the rug 33 columns wide because:
1) I wanted it to be a multiple of 3 to fit the checkered squares 
2) I wanted an odd number of columns so that the diamond will be centered

I made the rug 43 rows so:
1) I could play with the triangle method I wrote
2) I could make it aesthetically pleasing by incorporating
triangles on the top to the bottom
*/
public class Part1 {
	public static void main(String[] args) {

		line("=");
		triangles("@");
		checkerboardWide("*"," ");
		checkerboardNarrow("*"," ");
		line("=");
		diamond("$");
		line("=");
		checkerboardNarrow("*"," ");
		checkerboardWide("*"," ");
		inversetriangles("@");
		line("=");

	}
	
	//Method to print a line
	public static String line(String stringCharacter){

		//Create a for loop for the number of columns
		//Print the input stringCharacter for the number of columns
		//Print a new line at the end
		//Return nothing, the function only prints the desired output
		for (int columns = 1; columns <= 33;  columns ++)
			System.out.print(stringCharacter);
		System.out.print("\n");

	return null;

	}

	//Method to print checkerboard with wide edges
	/*
	I specifically added the second parameter so one can
	use different characters to denote the spaces in between
	the checkers
	*/
	public static String checkerboardWide(String stringCharacter, String spaceCharacter){

		//For loop for the number of rows of the checkerboard
		for (int rows = 1; rows <= 2;  rows++)
		{

			//Create a counter and set it to 1
			int counter = 1;

			//One pattern consists of 3 stringCharacter and 3 spaces
			//For loop to repeat the pattern 6 times
			//But the spaces only need to be repeated 5 times, hence the counter
			for (int repetitions = 1; repetitions <= 6; repetitions ++)
			{

				//For loop to repeat the number of stringCharacter 3 times
				for (int numChar = 1; numChar <= 3; numChar ++)
					System.out.print(stringCharacter);

				//When the counter hits 5, don't repeat the spaces
				if (counter <= 5)
					for (int numSpace = 1; numSpace <= 3; numSpace ++)
						System.out.print(spaceCharacter);

			//Add 1 to the counter
			counter += 1;

			}
		
		System.out.print("\n");
		}

	//Return nothing, the function only prints the desired output
	return null;
	}

	//Method to print checkerboard with narrow edges
	/*
	I specifically added the second parameter so one can
	use different characters to denote the spaces in between
	the checkers
	*/
	public static String checkerboardNarrow(String stringCharacter, String spaceCharacter){
		
		//For loop for the number of rows of the checkerboard
		for (int rows = 1; rows <= 2;  rows ++)
		{

			//Create a counter and set it to 1
			int counter = 1;

			//One pattern consists of 3 stringCharacter and 3 spaces
			//For loop to repeat the pattern 6 times
			//But the spaces only need to be repeated 5 times, hence the counter
			for (int repetitions = 1; repetitions <= 6; repetitions ++)
			{

				//For loop to repeat the number of stringCharacter 3 times
				for (int numChar = 1; numChar <= 3; numChar ++)
					System.out.print(spaceCharacter);

				//When the counter hits 5, don't repeat the spaces
				if (counter <= 5)
					for (int numSpace = 1; numSpace <= 3; numSpace ++)
						System.out.print(stringCharacter);

			//Add 1 to the counter
			counter += 1;

			}
		
		System.out.print("\n");
		}

	//Return nothing, the function only prints the desired output
	return null;

	}

	//Method to print a diamond
	public static String diamond(String stringCharacter){

		//Top half of diamond
		//For loop for the number of rows for the top half of the diamond
		for (int rows = 1; rows <= 5; rows ++)
		{

			//For loop for the number of spaces in front of stringCharacter
			//Spaces decrease by 1 for each ascending row
			for (int numSpace = 1; numSpace <= (17 - rows); numSpace ++)
				System.out.print(" ");

			//For loop for the number of stringCharacters in each row
			//Number of stringCharacters increase by 2 for each ascending row
			for (int numChar = 1; numChar <= ((rows * 2) - 1); numChar ++)
				System.out.print(stringCharacter);
			System.out.print("\n");
		}

		//Bottom half of diamond
		for (int rows = 1; rows <= 4; rows++)
		{

			//For loop for the number of spaces in front of stringCharacter
			//Spaces increase by 1 for each ascending row
			for (int numSpace = 1; numSpace <= (12 + rows); numSpace ++)
				System.out.print(" ");

			//For loop for the number of stringCharacters in each row
			//Number of stringCharacters decreases by 2 for each ascending row
			for (int numChar = 1; numChar <= ((-2 * rows) + 9); numChar ++)
				System.out.print(stringCharacter);
			System.out.print("\n");
		}

	//Return nothing, the function only prints the desired output
	return null;

	}

	//Method to print multiple triangles
	public static String triangles(String stringCharacter){

		//Width of triangle
		int size = 11;

		//For loop for the number of rows
		for (int rows = 1; rows <= size; rows++)
		{

			//For loop for the number of pattern repititions
			//One triangle is one pattern
			for (int repetitions = 1; repetitions <= 3; repetitions ++)
			{

				//For loop for the number of spaces before stringCharacter
				for (int numSpace = 1; numSpace <= (size - rows); numSpace ++)
					System.out.print(" ");

				//For loop for the number of stringCharacter characters
				for (int numChar = 1; numChar <= rows; numChar ++)
					System.out.print(stringCharacter);
			}
		System.out.print("\n");
		}

	//Return nothing, the function only prints the desired output
	return null;

	}

	//Method to print multiple inverse triangles
	/*
	Almost the same as the triangle method
	but I changed the length of the loops to
	adjust for formatting. I also siwtched around
	the spaces (" ") with the stringCharacter.
	*/
	public static String inversetriangles(String stringCharacter){

		//Width of triangle
		int size = 11;

		//For loop for the number of rows
		for (int rows = 1; rows <= size; rows++)
		{

			//For loop for the number of pattern repititions
			//One triangle is one pattern
			for (int repetitions = 1; repetitions <= 3; repetitions ++)
			{

				//For loop for the number of stringCharacter characters
				for (int numSpace = 1; numSpace <= (size - rows + 1); numSpace ++)
					System.out.print(stringCharacter);

				//For loop for the number of spaces before stringCharacter
				for (int numChar = 1; numChar <= (rows - 1); numChar ++)
					System.out.print(" ");
			}
		System.out.print("\n");
		}

	//Return nothing, the function only prints the desired output
	return null;

	}

}
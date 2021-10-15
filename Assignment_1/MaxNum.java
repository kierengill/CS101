// Kieren Singh Gill, Section 3, 15 February 2021
/* 
This program reads positive numbers and prints their
maximum. If the user enters a negative number, it 
terminates the program.
*/
import java.util.Scanner;

public class MaxNum {
	public static void main(String[] args) {

		//Create a new scanner instance
		Scanner input = new Scanner(System.in);

		//Prompt the user to enter numbers
		System.out.println("Insert numbers (terminate with negative number):");

		//Create a variable for maxNum and set it to zero
		double maxNum = 0;

		//Create a while loop
		//Each occurence of the while loop prompts the user
		//to enter a number
		while (true) {
			double number = input.nextDouble();

			//Break the loop if the user enters a negative number
			if (number < 0)
				break;

			//If a number is bigger than maxNum, it becomes the new maxNum!
			if (number > maxNum)
				maxNum = number;
		}

		//Display the maximum number!
		System.out.println("Their maximum is " + maxNum);
	}
}
// Kieren Singh Gill, Section 3, 15 February 2021
/* 
This program reads n amount of numbers and prints
their average.
*/
import java.util.Scanner;

public class Avg {
	public static void main(String[] args) {

		//Create a new scanner instance
		Scanner input = new Scanner(System.in);

		//Prompt the user to determine the number of numbers
		System.out.println("How many numbers:");
		int numberOfNumbers = input.nextInt();

		//Display the number of numbers the user needs to enter
		System.out.println("Insert " + numberOfNumbers + " numbers:");

		//Create two counters
		//"counter" is used to track the repetitions of the while loop
		//"total" collects the sum of the numbers entered by the user
		int counter = 0;
		double total = 0;
		
		//Create a while loop
		//Each occurence of the loop prompts the user to enter a number
		//The number is added to the total
		//The counter increases by 1
		while (counter < numberOfNumbers) {
			double numbers = input.nextDouble();
			total += numbers;
			counter++;
		}

		//Display the average of the numbers
		//Format the average to 2 decimal places using string formatting
		System.out.printf("Their average is %.2f\n", (total / numberOfNumbers));
	}
}
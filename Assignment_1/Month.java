// Kieren Singh Gill, Section 3, 15 February 2021
/* 
This program reads an integer input and prints the
corresponding month. If the input is larger than 12 or
smaller than zero, system will display an error message.
*/

import java.util.Scanner;

public class Month {
	public static void main(String[] args) {

		//Create a new scanner instance
		Scanner input = new Scanner(System.in);

		//Prompt the user to input an integer from 1 to 12
		System.out.print("Enter an integer from 1 to 12: ");
		int answer = input.nextInt();

		//Use a switch to the match user input to the corresponding month
		//1 corresponds to January, 2 to February, and so on...
		//Set the default case for all invalid month numbers
		switch (answer) {
			case 1: System.out.println("January"); break;
			case 2: System.out.println("February"); break;
			case 3: System.out.println("March"); break;
			case 4: System.out.println("April"); break;
			case 5: System.out.println("May"); break;
			case 6: System.out.println("June"); break;
			case 7: System.out.println("July"); break;
			case 8: System.out.println("August"); break;
			case 9: System.out.println("September"); break;
			case 10: System.out.println("October"); break;
			case 11: System.out.println("November"); break;
			case 12: System.out.println("December"); break;
			default: System.out.println("Invalid month number");
		}
	}
}
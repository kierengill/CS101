// Kieren Singh Gill, Section 3, 15 February 2021
/* 
This program reads 2 birthday inputs and 2 name
inputs for 2 different people, and determines 
who is older.
*/
import java.util.Scanner;

public class BirthDate {
	public static void main(String[] args) {

		//Create a new scanner instance
		Scanner input = new Scanner(System.in);

		//Prompt the user to enter person 1's birthday
		System.out.print(
			"Enter the birthday in 8-digit format for " + 
			"person # 1: YYYYMMDD): ");
		int birthday1 = input.nextInt();

		//Separate the year, month, and day from birthday1 
		int year1 = birthday1 / 10000;
		int day1 = birthday1 % 100;
		int month1 = birthday1 / 100 % 100;
		
		//Prompt the user to enter person 2's birthday
		System.out.print(
			"Enter the birthday in 8-digit format for " + 
			"person # 2: YYYYMMDD): ");
		int birthday2 = input.nextInt();

		//Separate the year, month and day from birthday 2
		int year2 = birthday2 / 10000;
		int day2 = birthday2 % 100;
		int month2 = birthday2 / 100 % 100;

		//The input.nextInt() function only reads the int value
		//and ignores the \n value when the user presses the Enter
		//key. Hence, the input.nextLine() function is included here
		//to read the \n that was left behind.
		//This allows the next instance of the input.nextLine()
		//function to work smoothly.
		input.nextLine();

		//Prompt the user to enter person 1's name
		System.out.print("Enter name for person #1: ");
		String name1 = input.nextLine();

		//Prompt the user to enter person 2's name
		System.out.print("Enter name for person #2: ");
		String name2 = input.nextLine();

		//Display person 1 and person 2's birthday in MM/DD/YYYY
		System.out.println(
			name1 + "'s birthday is: " + month1 + "/" + 
			day1 + "/" + year1);
		System.out.println(
			name2 + "'s birthday is: " + month2 + "/" + 
			day2 + "/" + year2);

		//Compare the years, months and days to determine who is older
		//Display the result!
		if (year1 < year2)
			System.out.println(name1 + " is older than " + name2 + "!");
		else if (year2 < year1)
			System.out.println(name2 + " is older than " + name1 + "!");
		else if (month1 < month2)
			System.out.println(name1 + " is older than " + name2 + "!");
		else if (month2 < month1)
			System.out.println(name2 + " is older than " + name1 + "!");
		else if (day1 < day2)
			System.out.println(name1 + " is older than " + name2 + "!");
		else if (day2 > day1)
			System.out.println(name2 + " is older than " + name1 + "!");
		else
			System.out.println(name1 + " and " + name2 + " are the same age!");
	}
}
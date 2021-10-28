import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
	public static void main(String[] args) {
	// Create a Scanner Object
	Scanner input = new Scanner(System.in);

	// prompt user to enter a radius
	System.out.print("Enter a number for radius: ");
	double radius = input.nextDouble();

	// compute area
	double area = radius * radius * 3.14159;

	// Display results
	System.out.println("The area of a circle of radius " + 
		radius + " is " + area);
	}
}
// Kieren Singh Gill, Section 3, 27 February 2021
/* 
This program prompts the user to select a number
system, input a number, and convert a number to
the desired number system. This program is not
limited from 1 to 15, but works for all numbers 
that can be stored within the integer range.
*/

//Import scanner element
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {

		//Create a new scanner instance
		Scanner input = new Scanner(System.in);

		//Prompt the user to input the number system to convert from
		System.out.print(
			"Enter the name of the number system to " + 
			"convert from: bin, or dec, or oct or hex: ");
		String convertFrom = input.nextLine();

		//Prompt user to enter number as string
		System.out.print("Enter number as a String: ");
		String number = input.nextLine();

		//Prompt the user to input the number system to conver to
		System.out.print(
			"Enter the name of the number system you " + 
			"want to convert to: bin, or dec, or oct or hex: ");
		String convertTo = input.nextLine();

		//If converting to and from the same system
		//Print the original number.
		if (convertFrom.equals(convertTo)){
			System.out.println(number);
		}
		//If converting from binary
			//Determine the output number system
			//Call the appropriate function and print the output number
		else if (convertFrom.equals("bin")){
			if (convertTo.equals("dec")){
				System.out.println(binaryToDecimal(number));
			}
			else if (convertTo.equals("oct")){
				System.out.println(binaryToOctal(number));
			}
			else if (convertTo.equals("hex")){
				System.out.println(binaryToHex(number));
			}
		}
		//If converting from decimal
			//Determine the output number system
			//Call the appropriate function and print the output number
		else if (convertFrom.equals("dec")){
			if (convertTo.equals("bin")){
				System.out.println(decimalToBinary(number));
			}
			else if (convertTo.equals("oct")){
				System.out.println(decimalToOctal(number));
			}
			else if (convertTo.equals("hex")){
				System.out.println(decimalToHex(number));
			}
		}
		//If converting from octal
			//Determine the output number system
			//Call the appropriate function and print the output number
		else if (convertFrom.equals("oct")){
			if (convertTo.equals("bin")){
				System.out.println(octalToBinary(number));
			}
			else if (convertTo.equals("dec")){
				System.out.println(octalToDecimal(number));
			}
			else if (convertTo.equals("hex")){
				System.out.println(octalToHex(number));
			}
		}
		//If converting from hexadecimal
			//Determine the output number system
			//Call the appropriate function and print the output number
		else if (convertFrom.equals("hex")){
			if (convertTo.equals("bin")){
				System.out.println(hexToBinary(number));
			}
			else if (convertTo.equals("dec")){
				System.out.println(hexToDecimal(number));
			}
			else if (convertTo.equals("oct")){
				System.out.println(hexToOctal(number));
			}
		}
	}

	//Method converting Binary to Decimal
	public static int binaryToDecimal(String binaryNumber){

		//Convert the input from string to integer
		//Initialize variables for the power and the decimal output
		int intBinary = Integer.parseInt(binaryNumber);
		int power = 0;
		int decimal = 0;

		//While the binary number isn't zero, continue the loop
		while (intBinary != 0){

			//Get the right-most digit
			/* 
			Multiply it by 2 to the power as determined by the variable,
			and add it to the decimal variable 
			*/
			//Remove the right-most digit from the binary number
			//Add 1 to the power and repeat the loop
			int lastDigit = intBinary % 10;
			decimal += Math.pow(2, power) * lastDigit;
			intBinary = intBinary / 10;
			power ++;
		}
	//Return the decimal
	return decimal;
	}

	//Method converting Decimal to Binary
	public static String decimalToBinary(String decimalNumber){

		//Convert input from string to integer
		//Initialize variables for the remainder and the binary output
		int intDecimal = Integer.parseInt(decimalNumber);
		int remainder = 0;
		String binary = "";

		//While the decimal is bigger than zero, continue the loop
		while (intDecimal > 0){

			/*
			Following the formula:
			number / 2 = x and remainder
			This remainder becomes the leftmost
			value in the binary number
			Repeat the function until the decimal
			reaches zero, replacing the number with x.
			*/
			//Convert the string to integer using String.valueOf
			remainder = intDecimal % 2;
			intDecimal = intDecimal / 2;
			binary = String.valueOf(remainder) + binary;
		}
	//Return binary output
	return binary;
	}

	//Method converting Octal to Decimal
	public static int octalToDecimal(String octalNumber){

		//Convert input from string to integer
		//Initialize variables for the power and the decimal output
		//Works similar to binaryToDecimal
		int intOctal = Integer.parseInt(octalNumber);
		int power = 0;
		int decimal = 0;
		
		//While the decimal isn't zero, continue the loop
		while (intOctal != 0){

			//Get the right-most digit
			/* 
			Multiply it by 8 to the power as determined by the variable,
			and add it to the decimal variable 
			*/
			//Remove the right-most digit from the octal number
			//Add 1 to the power and repeat the loop
			int lastDigit = intOctal % 10;
			decimal += Math.pow(8, power) * lastDigit;
			intOctal = intOctal / 10;
			power ++;
		}
	//Return decimal output
	return decimal;
	}

	//Method converting Decimal to Octal
	public static String decimalToOctal(String decimalNumber){

		//Convert input from string to integer
		//Initialize variables for the remainder and the octal output
		//Works similar to decimalToBinary
		int intDecimal = Integer.parseInt(decimalNumber);
		int remainder = 0;
		String octal = "";

		//While the decimal is bigger than zero, continue the loop
		while (intDecimal > 0){

			/*
			Following the formula:
			number / 8 = x and remainder
			This remainder becomes the leftmost
			value in the binary number
			Repeat the function until the decimal
			reaches zero, replacing the number with x.
			*/
			//Convert the string to integer using String.valueOf
			remainder = intDecimal % 8;
			intDecimal = intDecimal / 8;
			octal = String.valueOf(remainder) + octal;
		}
	//Return octal output
	return octal;
	}

	//Method converting Binary to Octal
	public static String binaryToOctal(String binaryNumber){
		
		//Call the binaryToDecimal function to convert binary to decimal
		//The rest of the method is identical to the decimalToOctal function
		/*
		I didn't call the decimalToOctal function because it 
		requires a string input, and the binaryToDecimal function
		gives an integer output.
		*/
		int intDecimal = binaryToDecimal(binaryNumber);
		int remainder = 0;
		String octal = "";

		while (intDecimal > 0){

			remainder = intDecimal % 8;
			intDecimal = intDecimal / 8;
			octal = String.valueOf(remainder) + octal;
		}
	//Return octal output
	return octal;
	}

	//Method converting Octal to Binary
	public static String octalToBinary(String octalNumber){

		//Call the octalToDecimal function to convert octal to decimal
		//The rest of the method is identical to the decimalToBinary function
		/*
		I didn't call the decimalToBinary function because it 
		requires a string input, and the binaryToDecimal function
		gives an integer output.
		*/
		int intDecimal = octalToDecimal(octalNumber);
		int remainder = 0;
		String binary = "";

		while (intDecimal > 0){

			remainder = intDecimal % 2;
			intDecimal = intDecimal / 2;
			binary = String.valueOf(remainder) + binary;
		}

	return binary;
	}

	//Method converting Hexadecimal to Decimal
	public static int hexToDecimal(String hexNumber){

		//Declare the hex characters as a constant variable
		String HEX_CHARACTERS = "0123456789ABCDEF";
		String hexString = hexNumber;
		int decimal = 0;

		//Create a for loop
		/*
		Use the "index" to obtain characters
		(so index 0 would obtain the first character, etc)
		Use the hexDigit and cross reference the HEX_CHARACTERS
		to obtain the index value of each character, which corresponds
		to their decimal value.
		Similar to raising each digit to the base power, one
		can achieve a similar result by multiplying the decimal counter
		by base 16 after each iteration, and then adding the additional 
		digitValue gained by each iteration
		*/
		for (int index = 0; index < hexString.length(); index++){
			char hexDigit = hexString.charAt(index);
			int digitValue = HEX_CHARACTERS.indexOf(hexDigit);
			decimal = decimal * 16 + digitValue;
		}

	return decimal;
	}

	//Method converting Decimal to Hexadecimal
	public static String decimalToHex(String decimalNumber){

		//Similar to decimalToBinary and decimalToOctal
		String HEX_CHARACTERS = "0123456789ABCDEF";
		int intDecimal = Integer.parseInt(decimalNumber);
		String hexString = "";
		int remainder = 0;

		/*
		Use the remainder to cross-reference the hex values
		for each decimal value
		*/
		while (intDecimal > 0){

			remainder = intDecimal % 16;
			intDecimal = intDecimal / 16;
			char hexDigit = HEX_CHARACTERS.charAt(remainder);
			hexString = hexDigit + hexString;
		}

	return hexString;
	}

	//Method converting Binary to Hexadecimal
	public static String binaryToHex(String binaryNumber){

		//Call the binaryToDecimal function to convert binary to decimal
		//The rest of the method is identical to the decimalToHex function
		/*
		I didn't call the decimalToHex function because it 
		requires a string input, and the binaryToDecimal function
		gives an integer output.
		*/
		String HEX_CHARACTERS = "0123456789ABCDEF";
		int intDecimal = binaryToDecimal(binaryNumber);
		String hexString = "";
		int remainder = 0;

		while (intDecimal > 0){

			remainder = intDecimal % 16;
			intDecimal = intDecimal / 16;
			char hexDigit = HEX_CHARACTERS.charAt(remainder);
			hexString = hexDigit + hexString;
		}

	return hexString;
	}

	//Method converting Octal to Hexadecimal
	public static String octalToHex(String octalNumber){

		//Call the octalToDecimal function to convert octal to decimal
		//The rest of the method is identical to the decimalToHex function
		/*
		I didn't call the decimalToHex function because it 
		requires a string input, and the octalToDecimal function
		gives an integer output.
		*/
		String HEX_CHARACTERS = "0123456789ABCDEF";
		int intDecimal = octalToDecimal(octalNumber);
		String hexString = "";
		int remainder = 0;

		while (intDecimal > 0){

			remainder = intDecimal % 16;
			intDecimal = intDecimal / 16;
			char hexDigit = HEX_CHARACTERS.charAt(remainder);
			hexString = hexDigit + hexString;
		}

	return hexString;
	}

	//Method converting Hexadecimal to Binary
	public static String hexToBinary(String hexNumber){

		//Call the hexToDecimal function to convert hexadecimal to decimal
		//The rest of the method is identical to the decimalToBinary function
		/*
		I didn't call the decimalToBinary function because it 
		requires a string input, and the hexToDecimal function
		gives an integer output.
		*/
		int intDecimal = hexToDecimal(hexNumber);
		int remainder = 0;
		String binary = "";

		while (intDecimal > 0){

			remainder = intDecimal % 2;
			intDecimal = intDecimal / 2;
			binary = String.valueOf(remainder) + binary;
		}
	return binary;
	}

	//Method converting Hexadecimal to Octal
	public static String hexToOctal(String hexNumber){

		//Call the hexToDecimal function to convert hexadecimal to decimal
		//The rest of the method is identical to the decimalToOctal function
		/*
		I didn't call the decimalToOctal function because it 
		requires a string input, and the hexToDecimal function
		gives an integer output.
		*/
		int intDecimal = hexToDecimal(hexNumber);
		int remainder = 0;
		String octal = "";

		while (intDecimal > 0){

			remainder = intDecimal % 8;
			intDecimal = intDecimal / 8;
			octal = String.valueOf(remainder) + octal;
		}

	return octal;
	}

}
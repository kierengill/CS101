import java.util.*;
import java.io.*;

//Create the Player class
public class Player {
	//Instance variables for the Player class
	public int score;
	public String[] wordsGuessed;
	public String name;
	//Constructor
	public Player(String[] keyWords, String name){
		this.score = 0;
		this.wordsGuessed = new String[keyWords.length];
		this.name = name;
	}
	//Method to update player score
	//Stores the player's guess in their wordsGuessed array
	public void updateScore(String guess){
		wordsGuessed[score] = guess;
		score++;
	}
	//Method to print the wordsGuessed by a player
	//Use a for loop to iterate through the wordsGuessed array
	public void showWordsGuessed(){
		System.out.print("[");
		for (int i = 0; i < score; i++){
			System.out.print("'"+wordsGuessed[i]+"'");

			if (i != score-1){
				System.out.print(" , ");
			}
		}
		System.out.print("]");
	}	 
}
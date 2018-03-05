package Unit7;

import java.util.Scanner;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;

	public GuessingGame(int stop)
	{
		upperBound = stop;

	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		int goal = (int)(Math.random()* upperBound);
		int counter = 0;
		String guess;
		do{
			System.out.println("Guess a number!");
			guess = keyboard.next();
			counter++;
		}while(guess != goal);
			






	}

	public String toString()
	{
		String output="";
		return output;
	}
}
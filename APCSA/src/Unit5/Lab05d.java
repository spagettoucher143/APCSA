package Unit5;

import static java.lang.System.*;
import java.util.Scanner;

import static java.lang.System.*;
import java.util.Scanner;

public class Lab05d
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter a letter :: ");
		char letter = keyboard.next().charAt(0);
		CharacterAnalyzer test = new CharacterAnalyzer(letter);
		out.println(test);
		out.print("Enter a number :: ");
		char letterInt = (char) keyboard.next().charAt(0);
		CharacterAnalyzer test2 = new CharacterAnalyzer(letterInt);
		out.println(test2);
		
		
		
		
		
		

	}
}
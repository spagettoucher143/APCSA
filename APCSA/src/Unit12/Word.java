package Unit12;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;

	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for (int i = 0;i < word.length();i++){
			for (int o = 0;o<vowels.length();o++){
				if (word.charAt(i) == vowels.charAt(o)){
					vowelCount++;
					
				}
			}
		}
		return vowelCount;






	}

	public int compareTo(Word rhs)
	{



	
		return -1;
	}

	public String toString()
	{
		return word;
	}
}
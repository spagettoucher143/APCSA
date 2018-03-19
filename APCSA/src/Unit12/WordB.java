package Unit12;

import static java.lang.System.*;

public class WordB implements Comparable<WordB>
{
	private String word;

	public WordB( String s )
	{
		word = s;

	}

	public int compareTo( WordB rhs )
	{
		if (word.length()>rhs.toString().length()){
			return 1;
		}
		else if(word.length()<rhs.toString().length()){
			return -1;
		}
		return 0;
	}

	public String toString()
	{
		return word;
	}
}
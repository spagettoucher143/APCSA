package Unit12;


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
		Word other = (Word)rhs;
		if(other.numVowels()<numVowels()){
			return 1;
		}
		else if(other.numVowels()>numVowels()){
			return -1;
		}
		for(int i = 0;i <Math.min(other.toString().length(),toString().length());i++){
			if(toString().charAt(i)>other.toString().charAt(i)){
				return 1;
			}
			else if (toString().charAt(i) < other.toString().charAt(i)){
				return -1;
			}
		}
		return toString().length()-other.toString().length();
		
	}

	public String toString()
	{
		return word;
	}
}
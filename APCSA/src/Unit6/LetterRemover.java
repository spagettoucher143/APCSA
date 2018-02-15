package Unit6;

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		sentence = "";
		lookFor = ' ';
	}

	//add in second constructor
	public LetterRemover(String s,char remove)
	{
		setRemover(s,remove);
	}

	public void setRemover(String s, char remove)
	{
		sentence = s;
		lookFor = remove;
	}

	public String removeLetters()
	{
		String cleaned = sentence;
		
		int i = sentence.indexOf(lookFor);
		while (i > -1){
			cleaned = cleaned.substring(0, i) + cleaned.substring(i+1);
			i = cleaned.indexOf(lookFor);
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}
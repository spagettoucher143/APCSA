package Unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay; 

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{	
		wordRay=sentence.split(" ");
	}

	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		for (String i: wordRay){
			if (max<i.length()){
				max=i.length();
			}
		}
		for (int k=0; k<wordRay.length; k++){
			for (int j=wordRay[k].length(); j<=max; j++){
				wordRay[k]=" "+wordRay[k];
			}
			
		}
		for (int i=0; i<= max; i++){
			for (int j=wordRay.length-1; j>=0; j--){
				char[] chararray = wordRay[j].toCharArray();
				output+=chararray[wordRay[j].length()-1-i];
			}
			output+="\n";
		}



		return output+"\n\n";
	}
}
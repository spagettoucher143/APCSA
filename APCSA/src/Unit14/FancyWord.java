package Unit14;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord {
	private char[][] mat;
	
	public FancyWord() {

	}

	public FancyWord(String s) {
		mat = new char[s.length()][s.length()];
		for(int q=0;q<s.length();q++){
			Arrays.fill(mat[q], ' '); 
		}
		for(int q=0;q<s.length();q++){
				mat[0][q]=s.charAt(q);
				mat[s.length()-1][q]=s.charAt(q);
		}
		for(int q=1;q<s.length()-1;q++){
			for(int w=1;w<s.length();w++){
				if(q==w)mat[q][w]=s.charAt(q);
				if(q+w==s.length()-1)mat[q][w]=s.charAt(w);
			}
		}
	}

	public String toString() {
		String output = "";
		for(int q=0;q<mat.length;q++){
			for(int e=0;e<mat[q].length;e++)output+=mat[q][e];
			output+="\n";
		}
		return output + "\n\n";
	}
}
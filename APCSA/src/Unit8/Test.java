package Unit8;
import java.util.Random;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
	    Random randomWord = new Random();
	    Scanner letterGuess = new Scanner(System.in);
	    String wordList[] = {"program","hello","world"};
	    String word = wordList[ randomWord.nextInt(3)];
	    int wordLength = word.length();
	    String star = "";
	    String newStar = star;
	    int counter = 1;
	    for(int o = 0;o < wordLength;o++){
	    	star = star + "*";
	    }
	    
	    
	    for(int i = 0;i < wordLength;i++){
	    	System.out.println("Guess a letter in the word" + star);	
	        String input = letterGuess.next();
	      if(word.contains(input)){
	        newStar = star.substring(i, i+1)+input+star.substring(i+1);
	      }
	      else
	        System.out.println(input+ " is not in the word."+ counter +" mistake(s)");
	    }
	    
	  }
	}


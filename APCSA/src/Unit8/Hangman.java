package Unit8;
import java.util.Scanner;
public class Hangman {

	private static String[] words = {"hello", "world", "program", "computer"};
	private static String word = words[(int) (Math.random() * words.length)];
	private static String lengthWord = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;

	public static void main(String[] args) {
		Scanner guesser = new Scanner(System.in);

		while (count < 7 && lengthWord.contains("*")) {
			System.out.println("Guess any letter in the word");
			System.out.println(lengthWord);
			String guess = guesser.next();
			hangman(guess);
		}
	}

	public static void hangman(String guess) {
		String guessrightdisplay = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				guessrightdisplay += guess.charAt(0);
			} else if (lengthWord.charAt(i) != '*') {
				guessrightdisplay += word.charAt(i);
			} else {
				guessrightdisplay += "*";
			}
		}

		if (lengthWord.equals(guessrightdisplay)) {
			count++;
		} else {
			lengthWord = guessrightdisplay;
	
		}
		if(count >= 1){
			System.out.println(guess+ " is not in the word");
		}
		if (lengthWord.equals(word)) {
			System.out.println("The word was " + word +". You missed " + count);
			System.out.println("Do you want to guess another word? Enter y or n>");
		}
		
		
	}
}
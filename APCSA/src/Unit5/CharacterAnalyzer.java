package Unit5;

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer {
    private char theChar;
    public CharacterAnalyzer() {
        theChar = '0';
    }
    public CharacterAnalyzer(char c) {
    	theChar = c;
    }
    public void setChar(char c) {
    	theChar = c;
    }
    public char getChar() {
        return theChar;
    }
    public boolean isUpper() {
        return (getASCII() > 64 && getASCII() < 91);
    }
    public boolean isLower() {
        return (getASCII() > 96 && getASCII() < 123);
    }
    public boolean isNumber() {
        return (getASCII() > 48 && getASCII() < 58);
    }
    public int getASCII() {
        return theChar;
    }
    public String toString() {
    	if (isLower() == true){
    		return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
    	}
    	if (isUpper() == true){
    		return ""+getChar() + " is a uppercase character. ASCII == " + getASCII() + "\n";
    	}
    	else
    		return ""+getChar() + " is a number. ASCII == " + getASCII() + "\n";
    	
    		
    	}
    	
    }

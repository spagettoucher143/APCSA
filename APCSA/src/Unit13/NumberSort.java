package Unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		while(number>0){
			number= number/10;
			count+=1;
		}
		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{	
		int k = getNumDigits(number);
		int[] sorted = new int[k];
		for(int i =0;i<k;i++){
			sorted[i]=number%10;
			number = number/10;
		}
		Arrays.sort(sorted);

		return sorted;
	}
}
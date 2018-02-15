package Unit6;

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{
		number = 0;
	}

	public Prime(int num)
	{
		setPrime(num);
	}

	public void setPrime(int num)
	{
		number = num;
	}

	public boolean isPrime()
	{	
		for (int i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public String toString()
	{
		if (isPrime()==true){
			String output = number + " is prime";
			return output;
		}
		else{
			String output1 = number + " is not prime";
			return output1;
		}
	}
}
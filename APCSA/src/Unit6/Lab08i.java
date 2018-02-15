package Unit6;

import static java.lang.System.*;
import java.lang.Math;

import static java.lang.System.*;
import java.lang.Math;
import java.util.Scanner;

public class Lab08i
{
	public static void main ( String[] args )
	{
		Prime p = new Prime();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number :: ");
		int x = 0;
		while(x < 5) {
			p.setPrime(sc.nextInt());
			System.out.println(p);
		}
		sc.close();
	}	
}
package Unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Lab16e
{
	public static void main( String args[] ) throws IOException
	{
		Histogram test = new Histogram(new char[]{'a','b','c'},"lab16e1.dat");
		test.loadAndAnalyzeFile();
		System.out.println("Letter occurring most : "+test.mostFrequent());
		System.out.println("Letter occurring least : "+test.leastFrequent());
		System.out.println(test);
		
		Histogram test2 = new Histogram(new char[]{'d','e','a'},"lab16e2.dat");
		test2.loadAndAnalyzeFile();
		System.out.println("Letter occurring most : "+test2.mostFrequent());
		System.out.println("Letter occurring least : "+test2.leastFrequent());
		System.out.println(test2);
		
		Histogram test3 = new Histogram(new char[]{'x','a','r','g'},"lab16e3.dat");
		test3.loadAndAnalyzeFile();
		System.out.println("Letter occurring most : "+test3.mostFrequent());
		System.out.println("Letter occurring least : "+test3.leastFrequent());
		System.out.println(test3);



		//more test cases
	}
}
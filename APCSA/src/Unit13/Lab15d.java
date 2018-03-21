package Unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

import java.util.*;
import java.io.*;

import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader ok = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\Unit13\\lab15d.dat"));
		int n = Integer.parseInt(ok.readLine());
		for(int i =0;i<3;i++){
			FancyWords op = new FancyWords(ok.readLine());
			System.out.println(op);
		}





	}
}
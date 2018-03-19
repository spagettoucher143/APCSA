package Unit12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\unit12\\lab18d.dat"));
		int n = Integer.parseInt(br.readLine());
		WordB[] myWords = new WordB[n];
		for(int i =0;i<n;i++) myWords[i]=new WordB(br.readLine());
		Arrays.sort(myWords);
		for(int i =0;i<myWords.length;i++)out.println(myWords[i]);
		











	}
}
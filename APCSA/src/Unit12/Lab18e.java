package Unit12;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\unit12\\lab18e.dat"));
		int n =Integer.parseInt(br.readLine());
		Word[] myWords = new Word[n];
		for(int i =0;i<n;i++){
			myWords[i]=new Word(br.readLine());
		}
		Arrays.sort(myWords);
		for(Word i :myWords)out.println(i);
	}
}
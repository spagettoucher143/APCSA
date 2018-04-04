package Unit14;

import java.util.*;
import java.io.*;
public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\unit14\\lab24d.dat"));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			System.out.println(new TicTacToe(br.readLine()));
		}
	}
}

package Unit14;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class Lab21i {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(System.getProperty("user.dir") + "\\src\\unit14\\lab21i.dat"));
		for (int i = 0; i < 6; i++) {
			int numLines1 = Integer.parseInt(br.readLine());
			String Line1 = br.readLine();
			Maze adam = new Maze(numLines1, Line1);
			
			System.out.println(adam);
		}
	}
}

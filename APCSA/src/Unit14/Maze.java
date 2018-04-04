package Unit14;

import java.util.Scanner;
import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Maze
{
   private boolean[][] maze;
   private boolean[][] check;
   private int smax;
	public Maze()
	{


	}

	public Maze(int size, String line)
	{
		smax =size;
		Scanner scanmaze = new Scanner(line);
		maze=new boolean[size+2][size+2];
		check = new boolean[size+2][size+2];
		for(int i =1;i<=size;i++){
			for(int j=1;j<=size;j++){
				int sub = scanmaze.nextInt();
				if(sub==1){
					maze[i][j]=true;
					System.out.print(1);
				}
				else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
		scanmaze.close();
		
	}

	public boolean hasExitPath(int r, int c)
	{
		if(c==smax) {
			return true;
		}
		if(!check[r+1][c+1]&&maze[r+1][c+1]){
			check[r+1][c+1]=true;
			if(hasExitPath(r+1,c)){
					return true;
			}
			if(hasExitPath(r+1,c-1)){
					return true;
			}
			if(hasExitPath(r,c+1)){
					return true;
			}
			if(hasExitPath(r,c-1)){
					return true;
			}
			
		}
		return false;
	}

	public String toString()
	{
		String output="";
		if(hasExitPath(0,0)){
			output+="exit found\n";
		}
		else{ 
			output+="exit not found\n";
		}




		return output;
	}
}
package Unit14;

import static java.lang.System.*;

import java.util.Arrays;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   private boolean[][] check1;
   private boolean[][] check2;
   private int rows;
   private int columns;
	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{		{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
		check2=new boolean[atMat[0].length+2][atMat[1].length+2];
		check1=new boolean[atMat[0].length+2][atMat[1].length+2];
		for(int i =0;i<atMat[0].length;i++){
			for(int k =0;k<atMat[1].length;k++){
				if(atMat[i][k]=='@') 
					check2[i+1][k+1]=true;
			}
		}
	}

	public int countAts(int r, int c)
	{
		int row = r;
		int column = c;
		atCount=0;
		if(!check1[r+1][c+1]&&check2[r+1][c+1]){
			atCount+=1;
			check1[r+1][c+1]=true;
			atCount+=countAts(r+1,c);
			atCount+=countAts(r,c+1);
			atCount+=countAts(r-1,c);
			atCount+=countAts(r,c-1);
		}
		rows=row;
		columns=column;
		return atCount;
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output=rows+" "+columns+" has ";
		output+=getAtCount()+" @s connected.";
		return output;
	}
}
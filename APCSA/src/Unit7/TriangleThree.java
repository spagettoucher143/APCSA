package Unit7;

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		size = 1;
		letter = "hello";
	}

	public TriangleThree(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle( String let, int sz )
	{
		letter = let;
		size = sz;
		}

	public String getLetter()
	{
		return "#";
	}

	public String toString()
	{
		String output="";
		for(int i = 0;i <= size;i++){
			for(int c = size;c >=0;c++){
				output = output + " ";
			}
			for(int c = size;c >=0;c++){
				output = output + letter;
			}
			
		}
		return output+"\n";
		
		

	}
}
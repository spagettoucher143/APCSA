package Unit6;

import static java.lang.System.*;

public class LoopStats
{
	private int start, stop;

	public LoopStats()
	{
		start = 0;
		stop = 0;

	}

	public LoopStats(int beg, int end)
	{
		start = 0;
		stop = 0;
		

	}

	public void setNums(int beg, int end)
	{
		start = beg;
		stop = end;

	}

	public int getEvenCount()
	{
		int evenCount=0;
		for(int i = 0;i <= stop;i++){
			if(i%2 == 0){
				evenCount = evenCount+1;
			}
			else{
				evenCount = evenCount+0;
				
			}
		}

		return evenCount;
	}

	public int getOddCount()
	{
		int oddCount=0;
		for(int o = 0;o <= stop;o++){
			if(o%2 != 0){
				oddCount = oddCount+1;
			}
			else{
				oddCount = oddCount+0;
				
			}
		}
		return oddCount;
	}

	public int getTotal()
	{
		int total=0;
		for(int e = 0;e < stop;e++){
			total = total + e;
		}

		return total;
	}
	
	public String toString()
	{
		return start + " " + stop;
	}
}
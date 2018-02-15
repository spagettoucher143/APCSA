package Unit6;


import static java.lang.System.*;

public class Lab08g
{
	public static void main ( String[] args )
	{
		LoopStats loopStats = new LoopStats();
		loopStats.setNums(1, 5);
		System.out.println(loopStats);
		loopStats.setNums(2, 8);
		System.out.println(loopStats);
		loopStats.setNums(5, 15);
		System.out.println(loopStats);
					
	}
}

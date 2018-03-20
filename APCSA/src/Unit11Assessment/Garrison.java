package Unit11Assessment;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
public class Garrison {
	private Knight[]knights;
	
	public Garrison(){
		setGarrison("");
	}
	public Garrison(String knightList){
		setGarrison(knightList);
	}
	public void setGarrison(String knightList){
		Scanner stringScan = new Scanner(knightList);
		int number = (stringScan.nextInt());
		String namex = stringScan.next();
		knights = new Knight[number];
		for (int i = 0; i<number;i++)
			knights[i] = new Knight(stringScan.next());
		
		
	}
	public void setKnight(int pos, String name){
		knights[pos] = new Knight(name);
	}
	public int getNobleKnight(){
		int knightsnoble = 0;
		for (int i = 0;i<knights.length;i++){
			if (knights[i] == new Knight("Stark")){
				knightsnoble++;
			if (knights[i] == new Knight("Lannister")){
				knightsnoble++;
			}
			else{
				knightsnoble = knightsnoble + 0;
			}
			}
		}
		return knightsnoble;
	}
	

}

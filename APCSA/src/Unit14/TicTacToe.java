package Unit14;

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;
	private String pWin;
	private String type;
	public TicTacToe()
	{


	}

	public TicTacToe(String game)
	{
		mat=new char[3][3];
		for(int i=0;i<9;i++){
			mat[i/3][i%3] = game.charAt(i);
			System.out.print(game.charAt(i));
			if(i%3==2){
				System.out.println();
			}
		}
		for(int i=0;i<3;i++)
			if(mat[i][0]==mat[i][1]&&mat[i][1]==mat[i][2]){
				pWin=String.valueOf(mat[i][0]);
				type="Horizontal!";
				return;
		}
		for(int i=0;i<3;i++)
			if(mat[0][i]==mat[1][i]&&mat[1][i]==mat[2][i]){
				pWin=String.valueOf(mat[0][i]);
				type="Vertical!";
				return;
		}
		if(mat[0][0]==mat[1][1]&&mat[1][1]==mat[2][2]||mat[2][0]==mat[1][1]&&mat[1][1]==mat[0][2]){
			pWin=String.valueOf(mat[1][1]);
			type="Diagnol!";
			return;
		}
		pWin="Draw";
		
	}

	public String getWinner()
	{
		

		return pWin;
	}

	public String toString()
	{
		String output="";
		if(pWin.equals("Draw")){
			output+="Cat's game - No winner";
		}
		else {
			output+=pWin+" wins "+type;
		}
		return output+"\n\n";
	}
}
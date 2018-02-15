package Unit6;


import static java.lang.System.*;

public class Lab09f
{
	public static void main( String args[] )
	{
		LetterRemover removeL = new LetterRemover("OWOWOWOWOWOW",'O');
		out.println(removeL);
		out.println();
		
		removeL.setRemover("HELLO OLLEH HOW ARE YOU", 'L');
		out.println(removeL);											
	}
}
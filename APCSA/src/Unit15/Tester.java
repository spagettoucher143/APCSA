package Unit15;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Component;

import javax.swing.JFrame;

public class Tester extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Tester()
	{
		super("PONG TESTER");
		setSize(WIDTH,HEIGHT);
		
		//getContentPane().add(new BlockTestTwo());		
		
		//uncomment when you are ready to test the Ball
		//getContentPane().add(new BallTestTwo());		
		
		//PaddleTestTwo padTest = new PaddleTestTwo();
		//((Component)padTest).setFocusable(true);			
		//getContentPane().add(padTest);
		
		getContentPane().add(new Pong());
		//getContentPane().add(new BreakOut());
		//getContentPane().add(new AirHockey());
		
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Tester run = new Tester();
	}
}
package Unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.Random;

public class BreakOut extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private int rightscore;
	private int leftscore;
	private Wall up, down, left, right;
	
	private Block blocka;
	
	Random rand = new Random();

	public BreakOut()
	{
		//set up all variables related to the game
		
		
		ball = new Ball(600,200,10,10,Color.BLUE,3,2);
		paddle = new Paddle(400,500,100,20,Color.BLUE,7);
		
		blocka = new Block(100,100,100,20,Color.RED);
		
		up = new Wall(0,0,800,10,Color.GRAY);
		down = new Wall(0,551,800,10,Color.GRAY);
		left = new Wall(0,10,10,541,Color.GRAY);
		right = new Wall(774,10,10,541,Color.GRAY);

		keys = new boolean[2];
		
		
		
    	setBackground(Color.WHITE);
		setVisible(true);
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);
		up.draw(graphToBack);
		down.draw(graphToBack);
		left.draw(graphToBack);
		right.draw(graphToBack);
		blocka.draw(graphToBack);

		graphToBack.setColor(Color.BLUE);
		
		if (ball.CollideBottom(down))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			
			ball.draw(graphToBack,Color.WHITE);
			ball.setX(400);
			ball.setY(300);
			ball.setXSpeed(2);
			ball.setYSpeed(3);
			ball.setColor(Color.BLUE);
		}
		
		if(ball.CollideBottom(blocka)||ball.CollideLeft(blocka)||ball.CollideRight(blocka)||ball.CollideTop(blocka)){
			if (ball.CollideBottom(blocka)||ball.CollideTop(blocka)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.CollideLeft(blocka)||ball.CollideRight(blocka)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blocka.setColor(Color.WHITE);
			blocka.draw(graphToBack);
			blocka.setWidth(0);
			blocka.setHeight(0);
		}
		
		if (ball.CollideTop(paddle) || ball.CollideBottom(paddle)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.CollideLeft(paddle) || ball.CollideRight(paddle)){
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.CollideLeft(left)|| ball.CollideRight(right)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		if (ball.CollideTop(up)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		//see if the paddles need to be moved

		if(keys[0] == true)
		{
			paddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			paddle.moveRightAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=true; break;
			case 'D' : keys[1]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=false; break;
			case 'D' : keys[1]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}
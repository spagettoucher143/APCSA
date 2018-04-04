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

public class AirHockey extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int rightscore;
	private int leftscore;
	private Wall up, down, left, right;
	private Wall leftg, rightg;
	Random rand = new Random();

	public AirHockey()
	{
		ball = new Ball(600,200,10,10,Color.BLACK,3,2);

		leftPaddle = new Paddle(50,250,20,60,Color.RED,5);
		rightPaddle = new Paddle(700,250,20,60,Color.BLUE,5);
		
		up = new Wall(0,0,800,10,Color.GRAY);
		down = new Wall(0,551,800,10,Color.GRAY);
		left = new Wall(0,10,10,541,Color.GRAY);
		right = new Wall(774,10,10,541,Color.GRAY);
		
		leftg = new Wall(20,200,10,150,Color.CYAN);
		rightg = new Wall(750,200,10,150,Color.CYAN);
		
		rightscore = 0;
		leftscore = 0;

		keys = new boolean[8];

    
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
		Graphics2D twoDGraph = (Graphics2D)window;

		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		up.draw(graphToBack);
		down.draw(graphToBack);
		left.draw(graphToBack);
		right.draw(graphToBack);
		leftg.draw(graphToBack);
		rightg.draw(graphToBack);


		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("SCOREBOARD",350,80);
		
		if (ball.getX() >776 || ball.getY()>556){
			ball.draw(graphToBack,Color.WHITE);
			ball.setX(400);
			ball.setY(300);
			ball.setColor(Color.BLUE);
			int dir = rand.nextInt(2);
			if (dir == 0){
				ball.setXSpeed(-(int)(Math.random() * 3 + 2));
			}
			else{
				ball.setXSpeed((int)(Math.random() * 3 + 2));
			}
			int ranspeed = (int)(Math.random() * 3);
			int direction = rand.nextInt(2);
			if (ranspeed == 0){
				if (direction == 0){
					ball.setYSpeed(-(ranspeed+1));
				}
				else{
					ball.setYSpeed((ranspeed+1));
				}
			}
			else{
				if (direction == 0){
					ball.setYSpeed(-ranspeed);
				}
				else{
					ball.setYSpeed(ranspeed);
				}
			}
		}
		if (ball.CollideLeft(leftg) || ball.CollideRight(rightg))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			
			if (ball.CollideLeft(leftg)){
				rightscore = rightscore + 1;
			}
			if (ball.CollideRight(rightg)){
				leftscore = leftscore + 1;
			}
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("Left: " + (leftscore-1), 350, 100);
			graphToBack.drawString("Right: " + (rightscore-1), 350, 120);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Left: " + leftscore, 350, 100);
			graphToBack.drawString("Right: " + rightscore, 350, 120);
			
			ball.draw(graphToBack,Color.WHITE);
			ball.setX(400);
			ball.setY(300);
			ball.setColor(Color.BLUE);
			int dir = rand.nextInt(2);
			if (dir == 0){
				ball.setXSpeed(-(int)(Math.random() * 3 + 2));
			}
			else{
				ball.setXSpeed((int)(Math.random() * 3 + 2));
			}
			int ranspeed = (int)(Math.random() * 3);
			int direction = rand.nextInt(2);
			if (ranspeed == 0){
				if (direction == 0){
					ball.setYSpeed(-(ranspeed+1));
				}
				else{
					ball.setYSpeed((ranspeed+1));
				}
			}
			else{
				if (direction == 0){
					ball.setYSpeed(-ranspeed);
				}
				else{
					ball.setYSpeed(ranspeed);
				}
			}
		}
		if(ball.CollideRight(leftg)||ball.CollideLeft(rightg)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.CollideTop(up) || ball.CollideBottom(down)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.CollideLeft(left) || ball.CollideRight(right)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.CollideLeft(leftPaddle)|| ball.CollideRight(rightPaddle)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.CollideTop(leftPaddle) || ball.CollideBottom(leftPaddle)||ball.CollideTop(rightPaddle) || ball.CollideBottom(rightPaddle)){
			ball.setYSpeed(-ball.getYSpeed());
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[2] == true)
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			leftPaddle.moveRightAndDraw(graphToBack);
		}
		if(keys[4] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[5] == true)
		{
			rightPaddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[6] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[7] == true)
		{
			rightPaddle.moveRightAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'A' : keys[1]=true; break;
			case 'S' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
			case 'I' : keys[4]=true; break;
			case 'J' : keys[5]=true; break;
			case 'K' : keys[6]=true; break;
			case 'L' : keys[7]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'A' : keys[1]=false; break;
			case 'S' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
			case 'I' : keys[4]=false; break;
			case 'J' : keys[5]=false; break;
			case 'K' : keys[6]=false; break;
			case 'L' : keys[7]=false; break;
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
package PONGBREAKOUTTESTER;

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
	private int score = 0;
	
	private Wall up, down, left, right;
	
	private Block blocka,blockb,blockc,blockd,blocke,blockf,blockg,blockh,blocki,blockj,blockk,blockl,blockm,blockn,blocko,blockp,blockq,blockr,blocks,blockt;
	Random rand = new Random();

	public BreakOut()
	{
		//set up all variables related to the game
		
		
		ball = new Ball(400,200,10,10,Color.BLUE,-2,2);
		paddle = new Paddle(10,400,20,100,Color.BLUE,7);
		
		blocka = new Block(600,30,10,80,Color.RED);
		blockb = new Block(600,130,10,80,Color.RED);
		blockc = new Block(600,230,10,80,Color.RED);
		blockd = new Block(600,330,10,80,Color.RED);
		blocke = new Block(600,430,10,80,Color.RED);
		blockf = new Block(620,30,10,80,Color.RED);
		blockg = new Block(620,130,10,80,Color.RED);
		blockh = new Block(620,230,10,80,Color.RED);
		blocki = new Block(620,330,10,80,Color.RED);
		blockj = new Block(620,430,10,80,Color.RED);
		blockk = new Block(640,30,10,80,Color.RED);
		blockl = new Block(640,130,10,80,Color.RED);
		blockm = new Block(640,230,10,80,Color.RED);
		blockn = new Block(640,330,10,80,Color.RED);
		blocko = new Block(640,430,10,80,Color.RED);
		blockp = new Block(660,30,10,80,Color.RED);
		blockq = new Block(660,130,10,80,Color.RED);
		blockr = new Block(660,230,10,80,Color.RED);
		blocks = new Block(660,330,10,80,Color.RED);
		blockt = new Block(660,430,10,80,Color.RED);
		
		System.out.println("Derek Nakanishi,Period 4,Computer 25");
		
		
		
		
		
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
		blockb.draw(graphToBack);
		blockc.draw(graphToBack);
		blockd.draw(graphToBack);
		blocke.draw(graphToBack);
		blockf.draw(graphToBack);
		blockg.draw(graphToBack);
		blockh.draw(graphToBack);
		blocki.draw(graphToBack);
		blockj.draw(graphToBack);
		blockk.draw(graphToBack);
		blockl.draw(graphToBack);
		blockm.draw(graphToBack);
		blockn.draw(graphToBack);
		blocko.draw(graphToBack);
		blockp.draw(graphToBack);
		blockq.draw(graphToBack);
		blockr.draw(graphToBack);
		blocks.draw(graphToBack);
		blockt.draw(graphToBack);
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("SCOREBOARD",350,80);
		graphToBack.drawString("Score:",350,100);
		if (ball.didCollideLeft(left))
		{
			
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("Score: " + (score), 350, 100);
			score = 0;
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			
			ball.draw(graphToBack,Color.WHITE);
			ball.setX(400);
			ball.setY(300);
			ball.setXSpeed(-(int)(Math.random() * 3 +2));
			ball.setYSpeed(((int)(Math.random() * 4 +3)));
			ball.setColor(Color.BLUE);
		}
		
		if(ball.didCollideBottom(blocka)||ball.didCollideLeft(blocka)||ball.didCollideRight(blocka)||ball.didCollideTop(blocka)){
			if (ball.didCollideBottom(blocka)||ball.didCollideTop(blocka)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blocka)||ball.didCollideRight(blocka)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blocka.setColor(Color.WHITE);
			blocka.draw(graphToBack);
			blocka.setWidth(0);
			blocka.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockb)||ball.didCollideLeft(blockb)||ball.didCollideRight(blockb)||ball.didCollideTop(blockb)){
			if (ball.didCollideBottom(blockb)||ball.didCollideTop(blockb)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockb)||ball.didCollideRight(blockb)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			
			blockb.setColor(Color.WHITE);
			blockb.draw(graphToBack);
			blockb.setWidth(0);
			blockb.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockc)||ball.didCollideLeft(blockc)||ball.didCollideRight(blockc)||ball.didCollideTop(blockc)){
			if (ball.didCollideBottom(blockc)||ball.didCollideTop(blockc)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockc)||ball.didCollideRight(blockc)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			
			blockc.setColor(Color.WHITE);
			blockc.draw(graphToBack);
			blockc.setWidth(0);
			blockc.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockd)||ball.didCollideLeft(blockd)||ball.didCollideRight(blockd)||ball.didCollideTop(blockd)){
			if (ball.didCollideBottom(blockd)||ball.didCollideTop(blockd)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockd)||ball.didCollideRight(blockd)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockd.setColor(Color.WHITE);
			blockd.draw(graphToBack);
			blockd.setWidth(0);
			blockd.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blocke)||ball.didCollideLeft(blocke)||ball.didCollideRight(blocke)||ball.didCollideTop(blocke)){
			if (ball.didCollideBottom(blocke)||ball.didCollideTop(blocke)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blocke)||ball.didCollideRight(blocke)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blocke.setColor(Color.WHITE);
			blocke.draw(graphToBack);
			blocke.setWidth(0);
			blocke.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockf)||ball.didCollideLeft(blockf)||ball.didCollideRight(blockf)||ball.didCollideTop(blockf)){
			if (ball.didCollideBottom(blockf)||ball.didCollideTop(blockf)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockf)||ball.didCollideRight(blockf)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockf.setColor(Color.WHITE);
			blockf.draw(graphToBack);
			blockf.setWidth(0);
			blockf.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockg)||ball.didCollideLeft(blockg)||ball.didCollideRight(blockg)||ball.didCollideTop(blockg)){
			if (ball.didCollideBottom(blockg)||ball.didCollideTop(blockg)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockg)||ball.didCollideRight(blockg)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockg.setColor(Color.WHITE);
			blockg.draw(graphToBack);
			blockg.setWidth(0);
			blockg.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockh)||ball.didCollideLeft(blockh)||ball.didCollideRight(blockh)||ball.didCollideTop(blockh)){
			if (ball.didCollideBottom(blockh)||ball.didCollideTop(blockh)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockh)||ball.didCollideRight(blockh)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockh.setColor(Color.WHITE);
			blockh.draw(graphToBack);
			blockh.setWidth(0);
			blockh.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blocki)||ball.didCollideLeft(blocki)||ball.didCollideRight(blocki)||ball.didCollideTop(blocki)){
			if (ball.didCollideBottom(blocki)||ball.didCollideTop(blocki)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blocki)||ball.didCollideRight(blocki)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blocki.setColor(Color.WHITE);
			blocki.draw(graphToBack);
			blocki.setWidth(0);
			blocki.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockj)||ball.didCollideLeft(blockj)||ball.didCollideRight(blockj)||ball.didCollideTop(blockj)){
			if (ball.didCollideBottom(blockj)||ball.didCollideTop(blockj)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockj)||ball.didCollideRight(blockj)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockj.setColor(Color.WHITE);
			blockj.draw(graphToBack);
			blockj.setWidth(0);
			blockj.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockk)||ball.didCollideLeft(blockk)||ball.didCollideRight(blockk)||ball.didCollideTop(blockk)){
			if (ball.didCollideBottom(blockk)||ball.didCollideTop(blockk)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockk)||ball.didCollideRight(blockk)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockk.setColor(Color.WHITE);
			blockk.draw(graphToBack);
			blockk.setWidth(0);
			blockk.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockl)||ball.didCollideLeft(blockl)||ball.didCollideRight(blockl)||ball.didCollideTop(blockl)){
			if (ball.didCollideBottom(blockl)||ball.didCollideTop(blockl)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockl)||ball.didCollideRight(blockl)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockl.setColor(Color.WHITE);
			blockl.draw(graphToBack);
			blockl.setWidth(0);
			blockl.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockm)||ball.didCollideLeft(blockm)||ball.didCollideRight(blockm)||ball.didCollideTop(blockm)){
			if (ball.didCollideBottom(blockm)||ball.didCollideTop(blockm)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockm)||ball.didCollideRight(blockm)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockm.setColor(Color.WHITE);
			blockm.draw(graphToBack);
			blockm.setWidth(0);
			blockm.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockn)||ball.didCollideLeft(blockn)||ball.didCollideRight(blockn)||ball.didCollideTop(blockn)){
			if (ball.didCollideBottom(blockn)||ball.didCollideTop(blockn)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockn)||ball.didCollideRight(blockn)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockn.setColor(Color.WHITE);
			blockn.draw(graphToBack);
			blockn.setWidth(0);
			blockn.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blocko)||ball.didCollideLeft(blocko)||ball.didCollideRight(blocko)||ball.didCollideTop(blocko)){
			if (ball.didCollideBottom(blocko)||ball.didCollideTop(blocko)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blocko)||ball.didCollideRight(blocko)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blocko.setColor(Color.WHITE);
			blocko.draw(graphToBack);
			blocko.setWidth(0);
			blocko.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockp)||ball.didCollideLeft(blockp)||ball.didCollideRight(blockp)||ball.didCollideTop(blockp)){
			if (ball.didCollideBottom(blockp)||ball.didCollideTop(blockp)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockp)||ball.didCollideRight(blockp)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockp.setColor(Color.WHITE);
			blockp.draw(graphToBack);
			blockp.setWidth(0);
			blockp.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockq)||ball.didCollideLeft(blockq)||ball.didCollideRight(blockq)||ball.didCollideTop(blockq)){
			if (ball.didCollideBottom(blockq)||ball.didCollideTop(blockq)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockq)||ball.didCollideRight(blockq)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockq.setColor(Color.WHITE);
			blockq.draw(graphToBack);
			blockq.setWidth(0);
			blockq.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockr)||ball.didCollideLeft(blockr)||ball.didCollideRight(blockr)||ball.didCollideTop(blockr)){
			if (ball.didCollideBottom(blockr)||ball.didCollideTop(blockr)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockr)||ball.didCollideRight(blockr)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockr.setColor(Color.WHITE);
			blockr.draw(graphToBack);
			blockr.setWidth(0);
			blockr.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blocks)||ball.didCollideLeft(blocks)||ball.didCollideRight(blocks)||ball.didCollideTop(blocks)){
			if (ball.didCollideBottom(blocks)||ball.didCollideTop(blocks)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blocks)||ball.didCollideRight(blocks)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blocks.setColor(Color.WHITE);
			blocks.draw(graphToBack);
			blocks.setWidth(0);
			blocks.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if(ball.didCollideBottom(blockt)||ball.didCollideLeft(blockt)||ball.didCollideRight(blockt)||ball.didCollideTop(blockt)){
			if (ball.didCollideBottom(blockt)||ball.didCollideTop(blockt)){
				ball.setYSpeed(-ball.getYSpeed());
			}
			if(ball.didCollideLeft(blockt)||ball.didCollideRight(blockt)){
				ball.setXSpeed(-ball.getXSpeed());
			}
			blockt.setColor(Color.WHITE);
			blockt.draw(graphToBack);
			blockt.setWidth(0);
			blockt.setHeight(0);
			score = score+1;
			graphToBack.drawString("Score: " + (score-1), 350, 100);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("Score: " + score, 350, 100);
		}
		if (ball.didCollideTop(paddle) || ball.didCollideBottom(paddle)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideLeft(paddle) || ball.didCollideRight(paddle)){
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideRight(right)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		if (ball.didCollideTop(up)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideBottom(down)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		//see if the paddles need to be moved

		if(keys[0] == true)
		{
			paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			paddle.moveDownAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
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
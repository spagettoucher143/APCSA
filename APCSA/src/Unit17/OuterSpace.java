package Unit17;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

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
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
//	private Alien alienOne;
//	private Alien alienTwo;
	private Ship ship;
	private Ammo ammo;	
//	private ArrayList<Alien> aliens;
	private Aliens aliens;
	private ArrayList<Ammo> shots;
	private Alien[][] aa;
	

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(500,400,3);

//		aliens = new ArrayList<Alien>();
		
		//matrix of aliens
		aliens = new Aliens(10,10,2);
		
		aa = aliens.amat();
		
//		int spacing = 100;
//		
//		for(int i = 0; i < 2; i++){
//			if (i == 0){
//				aliens.add(new Alien (80,80,2));
//			}
//			if (i == 1){
//				aliens.add(new Alien (200,80,2));
//			}
//		}
		
		ammo = new Ammo(ship.getX(), ship.getY(), 3);
		
		shots = new ArrayList<Ammo>();
		//instantiate done
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
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

		//background stuff
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		
		//draw components
		ship.draw(graphToBack);
		
		//alien movement		
		
//		for(int a = 0; a < aliens.size(); a++){
//			aliens.get(a).move("RIGHT");
//			aliens.get(a).draw(graphToBack);
//		}
		
//		for(Alien a : aliens){
//		if (!(a.getX() >= 0 && a.getX() <= 720)){
//			a.setSpeed(-a.getSpeed());
//		}
//	}
		
		//alien movement
		for(int i = 0; i < aa.length; i++){
			for(int j = 0; j < aa.length; j++){
				aa[i][j].move("RIGHT");
				aa[i][j].draw(graphToBack);
			}
		}
		
		//alien collide with wall
		for(int i = 0; i < aa.length; i++){
			for(int j = 0; j < aa.length; j++){
				if (!(aa[i][j].getX() >= 0 && aa[i][j].getX() <= 720)){
					aa[i][j].setSpeed(-aa[i][j].getSpeed());
				}
			}
		}

		//ammo placement
		ammo.setPos(ship.getX() + 35, ship.getY());

		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
		
		if(keys[4] == true)
		{
			Ammo a = new Ammo(ship.getX() + 35, ship.getY(), 3);
			shots.add(a);
			keys[4] = false;
		}
		
		for(Ammo a : shots){
			a.draw(graphToBack);
			
//			for(int x = 0; x < aliens.size(); x++){				
//				if (a.getY() <= aliens.get(x).getY()+70 && a.getY()+10 > aliens.get(x).getY() && (a.getX()>=aliens.get(x).getX() + 10 && a.getX()+10<=aliens.get(x).getX()+75)){
//					a.setPos(2000,2000);
//					aliens.get(x).setPos(1000,1000);
//				}
//			}
			
			for(int i = 0; i < aa.length; i++){
				for(int j = 0; j < aa.length; j++){
					if (a.getY() <= aa[i][j].getY()+70 && a.getY()+10 > aa[i][j].getY() 
							&& (a.getX()>=aa[i][j].getX() + 10 && a.getX()+10<=aa[i][j].getX()+75)){
						a.setPos(2000,2000);
						aa[i][j].setPos(1000,1000);
					}
				}
			}
		}		
		

		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) { }
	

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}


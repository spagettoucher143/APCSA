package Unit17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class PowerUp extends MovingThing
{
	private int speed =0;
	private Image image;

	public PowerUp()
	{
		this(0,0,0);
	}

	public PowerUp(int x, int y)
	{
		this(x,y,0);
	}

	public PowerUp(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\Unit17\\pu.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}
	}
	public void setSpeed(int s)
	{
	   //add more code
		speed = 0;
	}

	public int getSpeed()
	{
	   return 0;
	}
	
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
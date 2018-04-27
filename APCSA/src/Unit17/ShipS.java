package Unit17;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class ShipS extends MovingThing
{
	private int speed;
	private Image image;

	public ShipS()
	{
		this(0,0,0);
	}

	public ShipS(int x, int y)
	{
		this(x,y,0);
	}

	public ShipS(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\Unit17\\ship.jpgWithShield.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}
	}


	public void setSpeed(int s)
	{
	   //add more code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,70,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
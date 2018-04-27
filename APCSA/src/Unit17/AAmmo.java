package Unit17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class AAmmo extends MovingThing
{
	private int speed;

	public AAmmo()
	{
		this(0,0,0);
	}

	public AAmmo(int x, int y)
	{
		//add code
		this(x,y,0);
	}

	public AAmmo(int x, int y, int s)
	{
		//add code
		super(x,y);
		speed = s;
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), 10, 10);

		this.move("DOWN");
	}

	public String toString()
	{
		return "";
	}
}
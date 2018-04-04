package Unit15;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
		xSpeed = 3;
	}
	
	//add the other Ball constructors
	public Ball (int x, int y){
		super(x,y);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h){
		super(x,y,w,h);
		setColor(Color.BLACK);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball (int x, int y, int w, int h, Color c){
		super(x,y,w,h,c);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball (int x, int y, int w, int h, Color c, int xs, int ys){
		super(x,y,w,h,c);
		setXSpeed(xs);
		setYSpeed(ys);
	}
   //add the set methods
   public void setXSpeed(int xs){
	   xSpeed = xs;
   }
   public void setYSpeed(int ys){
	   ySpeed = ys;
   }

   public void moveAndDraw(Graphics window)
   {
   		//draw a white ball at old ball location
	  draw(window, Color.WHITE);
	  	//setX
      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      draw(window);
   }
   
	public boolean equals(Object obj)
	{
		if (getX() != ((Block) obj).getX() || getY() != ((Block)obj).getY() || getWidth() != ((Block)obj).getWidth() || getHeight() != ((Block)obj).getHeight() || getColor() != ((Block)obj).getColor()){
			if (getXSpeed() != ((Ball) obj).getXSpeed() || getYSpeed() != ((Ball) obj).getYSpeed()){
				return false;
			}
		}
		return true;
	}   

   //add the get methods
	public int getXSpeed(){
		return xSpeed;
	}
	public int getYSpeed(){
		return ySpeed;
	}
   //add a toString() method
	public String toString(){
		String output = "";
		output += getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getXSpeed() + " " + getYSpeed();
		return output;
	}
	
	//collidable methods
	
	public boolean didCollideLeft(Object obj){
		Block b = (Block)obj;
		if (getX() > b.getX() && getX() <= b.getX()+b.getWidth() && (getY() >= b.getY() && getY()+getHeight() <= b.getY()+b.getHeight())){
			return true;
		}
		return false;
	}
	public boolean didCollideRight(Object obj){
		Block b = (Block)obj;
		if (getX()<b.getX() && getX()+getWidth()>=b.getX() && (getY() >= b.getY() && getY()+getHeight() <= b.getY()+b.getHeight())){
			return true;
		}
		return false;
	}
	public boolean didCollideTop(Object obj){
		Block b = (Block)obj;
		if (getY()+getHeight() >= b.getY() && getY() < b.getY()+b.getHeight() && (getX()>=b.getX() && getX()+getWidth()<=b.getX()+b.getWidth())){
			return true;
		}
		return false;
	}
	public boolean didCollideBottom(Object obj){
		Block b = (Block)obj;
		if (getY() <= b.getY()+b.getHeight() && getY()+getHeight() > b.getY() && (getX()>=b.getX() && getX()+getWidth()<=b.getX()+b.getWidth())){
			return true;
		}
		return false;
	}
}
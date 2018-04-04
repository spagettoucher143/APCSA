package Unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class InvisibleBall extends Ball
{

   //constructors
   public InvisibleBall()
   {
		super();
   }

   public InvisibleBall(int x, int y)
   {
	   super(x,y);
   }

   public InvisibleBall(int x, int y, int wid, int ht)
   {
	   super(x,y,wid,ht);
   }

   public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
   }

   public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
   }

   public int turnInvis()
   {
	   int rn = (int)Math.random() * 10;
	   return rn;
   }
   @Override
   public void moveAndDraw(Graphics window){
	   draw(window, Color.WHITE);
	   
	   setX(getX() + getXSpeed());
	   setY(getY() + getYSpeed());
	   
	   if (turnInvis() > 5){
		   draw(window,Color.WHITE);
	   }
	   else{
		   draw(window);
	   }
   }
}
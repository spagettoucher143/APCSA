package Unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();
   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x,y);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
   }

   public void setXSpeed( int xSpd )
   {
	   if (xSpd > 0){
		   super.setXSpeed(xSpd + 1);
	   }
	   else{
		   super.setXSpeed(xSpd - 1);
	   }
   }

   public void setYSpeed( int ySpd )
   {
	   if (ySpd > 0){
		   super.setYSpeed(ySpd + 1);
	   }
	   else{
		   super.setYSpeed(ySpd - 1);
	   }
   }
}
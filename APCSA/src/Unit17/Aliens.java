package Unit17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Aliens extends Alien
{
	private Alien[][] alien;
	
	public Aliens(int x, int y, int s){
		alien = new Alien[3][3];
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				alien[i][j] = new Alien(x,y,2);
				x = x + 80;
			}
			y = y + 80;
		}
	}
	
	public Alien[][] amat (){
		return alien;
	}
}
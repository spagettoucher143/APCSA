package Unit2;
import java.lang.Math;

public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
		radius = rad;
	}

	public void calculateArea( )
	{
		area = radius*radius*Math.PI;
	}

	public void print( )
	{
		System.out.println("The area of the circle is " + area);
	}
}
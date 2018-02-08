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

	public void calculateArea()
	{
		area = Math.pow(radius, 2)*Math.PI;
	}

	public void print()
	{
		System.out.printf("The area is :: %.4f\n",area);
	}
}
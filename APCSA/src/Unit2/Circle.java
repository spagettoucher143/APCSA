package Unit2;
import java.lang.Math;
public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
		rad = radius;
	}

	public void calculateArea()
	{
		area = Math.pow(radius, 2)*Math.PI;
	}

	public void print()
	{
		System.out.println(area);
	}
}
package Unit2;

public class lab02f {
	public static void main( String[] args ){
		Line line = new Line(1, 9, 14, 2);
		line.setCoordinates(1, 9, 14, 2);
		line.calculateSlope();
		line.print();
	}
}

package Unit3;

public class lab03d {


		public static void main(String[] args)
		{
			Distance length = new Distance(1, 2, 1, 1);
			length.calcDistance();
			length.print();
			
			length.setCoordinates(1, 1, -2, 2);
			length.calcDistance();
			length.print();
			
			length.setCoordinates(1, 1, 0, 0);
			length.calcDistance();
			length.print();
			
			
			Distance lengthInput = new Distance();
			lengthInput.calcDistance();
			lengthInput.print();
		}

	}

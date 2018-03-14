package Unit12;


import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster(){
		
	}



	//write an initialization constructor with an int parameter ht
	public Monster(int ht){
		setHeight(ht);
		getHeight();
	}



	//write an initialization constructor with int parameters ht and wt
	public Monster(int ht, int wt){
		
		setHeight(ht);
		setWeight(wt);
		getHeight();
		getWeight();
	}




	//write an initialization constructor with int parameters ht, wt, and age
	public Monster(int ht,int wt,int age){
		setHeight(ht);
		setWeight(wt);
		setAge(age);
		getHeight();
		getWeight();
		getAge();
		
	}



	//modifiers - write set methods for height, weight, and age
	public void setHeight(int htv){
		myHeight = htv;
	}
	public void setWeight(int wtv){
		myWeight = wtv;
	}
	public void setAge(int agev){
		myAge = agev;
	}

	
	
	//accessors - write get methods for height, weight, and age
	public int getHeight(){
		return myHeight;
	}
	public int getWeight(){
		return myWeight;
	}
	public int getAge(){
		return myAge;
	}

	
	//creates a new copy of this Object
	public Object clone()
	{
	
	   return new Monster();
	}

	public boolean equals( Object obj )
	{
		


		return false;
	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;

		return -1;
	}

	//write a toString() method
	
	
}
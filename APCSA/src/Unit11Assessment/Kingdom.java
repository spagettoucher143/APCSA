package Unit11Assessment;

public class Kingdom {
	private String surName;
	private Garrison surGarrison;
	
	public Kingdom(){
		setName("");
		setGarrison("");
	}
	public Kingdom(String name, String knightList){
		setName(surName);
		setGarrison(knightList);
	}
	public void setName(String name){
		surName = name;
	}
	public void setGarrison(String knightList){
		surGarrison = setGarrison(knightList);
	}
	public void setKnight(){
		surGarrison.setKnight()
	}

}

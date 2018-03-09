package Unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	String op;
	public MadLib()
	{
		String mlib="";
		loadNouns();
		loadAdjectives();
		loadVerbs();
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\story.dat"));
			while(file.hasNextLine()){
				mlib= file.nextLine();		
			}		

		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		String ans ="";
		for(int i =0; i < mlib.length();i++){
			if (mlib.charAt(i)=='#'){ 
				ans+=getRandomNoun();
			}
			else if(mlib.charAt(i)=='@'){
				ans+=getRandomVerb();
			}
			else if(mlib.charAt(i)=='&'){
				ans+=getRandomAdjective();
			}
			else{
				ans+=mlib.charAt(i);
			}
		}
		op=ans;

	}

	public MadLib(String fileName)
	{

		String mlib="";
		
		try{
			Scanner file = new Scanner(new File(fileName));
			mlib= file.nextLine();		
			file.close();
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		loadNouns();
		loadAdjectives();
		loadVerbs();
		String ans ="";
		for(int i =0; i < mlib.length();i++){
			if (mlib.charAt(i)=='#') 
				ans+=getRandomNoun();
			else if(mlib.charAt(i)=='@')
				ans+=getRandomVerb();
			else if(mlib.charAt(i)=='&') 
				ans+=getRandomAdjective();
			else 
				ans+=mlib.charAt(i);
		}
		op=ans;
		
	}

	public void loadNouns()
	{
		nouns = new ArrayList<String>();
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\nouns.dat"));
			while(file.hasNextLine()){
				String x=file.nextLine();
				nouns.add(x);
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}	
		
	}
	
	public void loadVerbs()
	{
		verbs = new ArrayList<String>();
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\verbs.dat"));
			while(file.hasNextLine()){
				verbs.add(file.nextLine());
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	public void loadAdjectives()
	{
		adjectives = new ArrayList<String>();
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\adjectives.dat"));
			while(file.hasNextLine()){
				adjectives.add(file.nextLine());
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	public String getRandomVerb()
	{
		return verbs.get((new Random()).nextInt(verbs.size()));
	}
	
	public String getRandomNoun()
	{
		
		return nouns.get((new Random()).nextInt(nouns.size()));
	}
	
	public String getRandomAdjective()
	{
		
		return adjectives.get((new Random()).nextInt(adjectives.size()));
	}		

	public String toString()
	{
	   return op+"\n\n\n";
	}
}
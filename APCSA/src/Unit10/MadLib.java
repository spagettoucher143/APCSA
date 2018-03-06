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
	String myans;
	public MadLib()
	{
		String mb="";
		loadNouns();
		loadAdjectives();
		loadVerbs();
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\story.dat"));
			mb= file.nextLine();		

		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		String ans ="";
		for(int i =0; i < mb.length();i++){
			if (mb.charAt(i)=='#') ans+=getRandomNoun();
			else if(mb.charAt(i)=='@') ans+=getRandomVerb();
			else if(mb.charAt(i)=='&') ans+=getRandomAdjective();
			else ans+=mb.charAt(i);
		}
		myans=ans;

	}

	public MadLib(String fileName)
	{
		//load stuff
		
		String mb="";
		
		try{
			Scanner file = new Scanner(new File(fileName));
			mb= file.nextLine();		
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
		for(int i =0; i < mb.length();i++){
			if (mb.charAt(i)=='#') ans+=getRandomNoun();
			else if(mb.charAt(i)=='@') ans+=getRandomVerb();
			else if(mb.charAt(i)=='&') ans+=getRandomAdjective();
			else ans+=mb.charAt(i);
		}
		myans=ans;
		
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
	   return myans+"\n\n\n";
	}
}
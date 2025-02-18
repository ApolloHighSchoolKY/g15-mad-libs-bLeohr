//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Walmart");
		adjectives.add("massive");
		story="I punched Walmart in a massive way";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadAdjectives();
		loadNouns();
		loadVerbs();

		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			String storyString = "";
			Scanner storyReader = new Scanner(new File("story.dat"));

			while(storyReader.hasNext())
				storyString+=(storyReader.next());

			Scanner storyChop = new Scanner(storyString);

			while(storyChop.hasNext())
				if(storyChop.next().equals("&"))
					story+=(getRandomAdjective());

				else if(storyChop.next().equals("#"))
					story+=(getRandomNoun());

				else if(storyChop.next().equals("@"))
					story+=(getRandomVerb());

				else 
					story+=(storyChop.next());

			//While there is more of the story, read in the word/symbol

				//If what was read in is one of the symbols, find a random
				//word to replace it.
			


		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));

			while(reader.hasNext())
			nouns.add(reader.next());

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner reader = new Scanner(new File("verbs.dat"));
			while(reader.hasNext())
			verbs.add(reader.next());

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner reader = new Scanner(new File("adjectives.dat"));
			while(reader.hasNext())
			adjectives.add(reader.next());

			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		int chooseVerb = (int)(Math.random()*verbs.size());
		String chosenVerb = verbs.get(chooseVerb);

		return "" + chosenVerb;
	}

	public String getRandomNoun()
	{
		int chooseNoun = (int)(Math.random()*nouns.size());
		return "" + nouns.get(chooseNoun);
	}

	public String getRandomAdjective()
	{
		int chooseAdjective = (int)(Math.random()*adjectives.size());
		return "" + (String)(adjectives.get(chooseAdjective));
	}

	public String toString()
	{
		return "" + story;
	}
}
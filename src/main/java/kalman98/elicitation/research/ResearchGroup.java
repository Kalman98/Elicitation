package kalman98.elicitation.research;

import java.util.ArrayList;

public class ResearchGroup
{
	public String name = "";
	public String properName = "";
	public ArrayList<Research> researches = new ArrayList<Research>();
	
	public ResearchGroup(String name, String properName)
	{
		this.name = name;
		this.properName = properName;
	}
	
	public ResearchGroup addResearch(Research research)
	{
		researches.add(research);
		return this;
	}
}
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
	
	/**
	 * Adds the given research to the group.
	 * @param research
	 * @return
	 */
	public ResearchGroup addResearch(Research research)
	{
		research.setGroup(this.name);
		researches.add(research);
		return this;
	}
	
	/**
	 * Gets the requested research by name, returns null if not found.
	 * @param name
	 * @return
	 */
	public Research getResearch(String name)
	{
		for (int i = 0; i < researches.size(); i ++)
			if (researches.get(i).name == name)
				return researches.get(i);
		return null;
	}
}
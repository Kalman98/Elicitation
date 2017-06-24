package kalman98.elicitation.research;

import java.util.ArrayList;

public class ResearchManager
{
	public static ArrayList<ResearchGroup> globalResearches = new ArrayList<ResearchGroup>();
	
	public static void init()
	{
	// json loading code here to create a gigantic research group
	}
	public static Research getResearch(String groupName, String researchName)
	{
		for (int i = 0; i < globalResearches.size(); i ++)
			if (globalResearches.get(i).name == groupName)
				for (int j = 0; j < globalResearches.get(i).researches.size(); j ++)
					if (globalResearches.get(i).researches.get(j).name == researchName)
						return globalResearches.get(i).researches.get(j);
		return null;
	}
	public static ResearchGroup getResearchGroup(String groupName)
	{
		for (int i = 0; i < globalResearches.size(); i ++)
			if (globalResearches.get(i).name == groupName)
				return globalResearches.get(i);
		return null;
	}
}

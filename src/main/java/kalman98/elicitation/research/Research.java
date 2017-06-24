package kalman98.elicitation.research;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class Research {
	
	public ArrayList<ResearchPage> info = new ArrayList<ResearchPage>();
	public ArrayList<Research> parents = new ArrayList<Research>();
	public String name = "";
	public ItemStack icon = null;
	
	public Research(String name, ItemStack icon)
	{
		this.name = name;
		this.icon = icon;
	}
	
	public Research addPage(ResearchPage page)
	{
		info.add(page);
		return this;
	}
	
	/**
	 * Accepts a long string of text (e.g. the json asset text for the research)
	 * and formats it according to the width of the GUI page, splitting it into
	 * separate lines that are of the proper length, and creating multiple pages
	 * if necessary.
	 * @param text
	 * @return list
	 */
	public Research addInfo(String text)
	{
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		String temp = "";
		int counter = 0;
		// for every character in s
		for (int i = 0; i < text.length(); i ++)
		{
			// add character to temp
			temp += text.charAt(i);
			// if temp is a complete word
			if (text.charAt(i) == ' ')
			{
				// add temp to word list and reset temp
				words.add(temp);
				temp = "";
			}
		}
		// catch the last word and add it to temp, because the string doesn't end with a space
		words.add(temp);
		temp = "";
		// for every word in words
		for (int i = 0; i < words.size(); i ++)
		{
			// add the width of the word (in pixels) to counter
			counter += Minecraft.getMinecraft().fontRendererObj.getStringWidth(words.get(i));
			// if counter times 0.6 (the text is shrunk when drawn) is greater than 160 (width of the page)
			if (counter > 100)
			{
				// dump words into the list as a string, *without* the current word
				list.add(temp);
				System.out.println(list.size());
				if (list.size() > 14) {
					this.info.add(new ResearchPage().setInfo(list));
					list = new ArrayList<String>();
				}
				// *now* set temp to the current word
				temp = words.get(i);
				// and set the width of the word to counter again
				counter = Minecraft.getMinecraft().fontRendererObj.getStringWidth(words.get(i));
			}
			else
			{
				// if there is still space for the word on the line, add it to temp
				temp += words.get(i);
			}
		}
		// catch the last string and add it to the list
		list.add(temp);
		this.info.add(new ResearchPage().setInfo(list));
		return this;
	}
	
	public Research addCraftingRecipe(Object[] recipe, ItemStack result)
	{
		info.add(new ResearchPage().setCraftingRecipe(recipe, result));
		return this;
	}
	
	public ResearchPage getPage(int i)
	{
		return info.get(i);
	}
	
	public int getPageCount()
	{
		return info.size();
	}
}

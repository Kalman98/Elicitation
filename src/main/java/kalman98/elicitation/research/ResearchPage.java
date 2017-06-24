package kalman98.elicitation.research;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class ResearchPage
{	
	public ArrayList<ItemStack> craftingRecipe = new ArrayList<ItemStack>();
	public ArrayList<ItemStack> smeltingRecipe = new ArrayList<ItemStack>();
	public ArrayList<String> info = new ArrayList<String>();
	public ItemStack displayItem = null;
	public EnumPageType type = EnumPageType.TYPE_NULL;
	public String title = "";
	
	public ResearchPage()
	{
		
	}
	
	/**
	 * Turns this page into an info page. Pass in a String array.
	 * @param info
	 * @return
	 */
	public ResearchPage setInfo(ArrayList<String> info)
	{
		type = EnumPageType.TYPE_INFO;
		this.info = info;
		return this;
	}
	
	/**
	 * Turns this page into a crafting recipe page. Pass in a 3x3 array
	 * of items along with the output of the recipe.
	 * @param recipe
	 * @param output
	 * @return
	 */
	public ResearchPage setCraftingRecipe(Object[] recipe, ItemStack output)
	{
		type = EnumPageType.TYPE_CRAFTING;
		for (int i = 0; i < 9; i++)
		{
			craftingRecipe.add((ItemStack) recipe[i]);
		}
		craftingRecipe.add(output);
		return this;
	}
	
	/**
	 * Turns this page into a smelting recipe page. Pass in an input
	 * and an output item.
	 * @param input
	 * @param output
	 * @return
	 */
	public ResearchPage addSmeltingRecipe(ItemStack input, ItemStack output)
	{
		type = EnumPageType.TYPE_SMELTING;
		smeltingRecipe.add(input);
		smeltingRecipe.add(output);
		return this;
	}
}

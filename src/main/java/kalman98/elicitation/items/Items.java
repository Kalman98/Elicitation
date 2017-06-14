package kalman98.elicitation.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Items
{
	// please keep all items in alphabetical order
	public static Item guidebook;
	
	/**
	 * Initializes and registers all items from the mod, including ItemBlocks.
	 */
	public static void setup()
	{
		initializeItems();
		registerItems();
	}
	
	/**
	 * Initializes all items from the mod.
	 */
	public static void initializeItems()
	{
		// please keep all items in alphabetical order
    	guidebook = new ItemGuidebook().setUnlocalizedName("guidebook");
 
	}
	
	/**
	 * Registers all items from the mod.
	 */
	public static void registerItems() {
		
		//Please keep all items in alphabetical order!
 		GameRegistry.register(guidebook.setRegistryName("guidebook"));
	}
}

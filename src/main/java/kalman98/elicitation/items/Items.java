package kalman98.elicitation.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
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
		registerRendering();
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
	public static void registerItems()
	{	
		//Please keep all items in alphabetical order!
 		GameRegistry.register(guidebook.setRegistryName("guidebook"));
	}
	
	/**
	 * Registers rendering for all items from the mod.
	 */
	private static void registerRendering()
	{
		registerItemRendering("guidebook");
	}
	
	/**
	 * Registers a new ItemModel.
	 * 
	 * Will only work if the itemModel json
	 * file has the same name as the registered
	 * blocks/items id.
	 * 
	 * @param name The itemModel/block name
	 */
	private static void registerItemRendering(String name)
	{
		ModelLoader.setCustomModelResourceLocation(Item.REGISTRY.getObject(new ResourceLocation("elicitation", name)), 0, new ModelResourceLocation("elicitation:" + name, "inventory"));
	}
}

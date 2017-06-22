package kalman98.elicitation.items;

import kalman98.elicitation.Elicitation;
import kalman98.elicitation.gui.GuiGuidebook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ItemGuidebook extends Item
{
	public ItemGuidebook()
	{
		
	}
	
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {	
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //FMLCommonHandler.instance().showGuiScreen(new GuiGuidebook(playerIn));
        playerIn.openGui(Elicitation.MODID, 0, worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}

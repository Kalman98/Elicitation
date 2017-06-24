package kalman98.elicitation.gui;

import kalman98.elicitation.items.Items;
import kalman98.elicitation.research.Research;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiGuidebook extends GuiScreen
{
	public static final ResourceLocation GUIDEBOOK_GUI_TEXTURE = new ResourceLocation("elicitation:textures/gui/guidebook_gui.png"); 
	public static final int LETTER_WIDTH = 5;
	
	public GuiGuidebook(EntityPlayer player)
	{ }

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.disableLighting();
		RenderHelper.disableStandardItemLighting();
		RenderHelper.enableGUIStandardItemLighting();
		GlStateManager.enableAlpha();
		Minecraft.getMinecraft().getTextureManager().bindTexture(GUIDEBOOK_GUI_TEXTURE);

		// draw the background texture
        int i = (width - 256) / 2;
        int j = (height - 192) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, 256, 192);
//        this.itemRender.renderItemIntoGUI(new ItemStack(Items.WRITABLE_BOOK), (width / 2) - 100, (height / 2) - 85);
        
        // creates a new generic research with a lot of text inside
        Research research = new Research("", new ItemStack(Items.guidebook)).addInfo("Hello, this is Kalman. How are you doing? Hello, this is Kalman. How are you doing? Hello, this is Kalman. How are you doing? Hello, this is Kalman. How are you doing? Hello, this is Kalman. How are you doing? Hello, this is Kalman. How are you doing? Hello, this is Kalman. How are you doing? Hello, this is Kalman. How are you doing?");
        int index = 0;
        // render the first page of text
        for (int line = 0; line < research.getPage(index).info.size(); line ++)
        	this.fontRendererObj.drawString(research.getPage(index).info.get(line), (int)((width / 2) - 100), (int)(((height / 2) - 80) + (11 * line)), 0);
        // if available, render the second page of text
    	if (index + 1 < research.info.size())
    		for (int line = 0; line < research.getPage(index + 1).info.size(); line ++)
        		this.fontRendererObj.drawString(research.getPage(index + 1).info.get(line), (int)((width / 2) + 10), (int)(((height / 2) - 80) + (11 * line)), 0);
    }
}
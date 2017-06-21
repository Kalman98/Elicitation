package kalman98.elicitation.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
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

        int i = (width - 256) / 2;
        int j = (height - 192) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, 256, 192);
        this.itemRender.renderItemIntoGUI(new ItemStack(Items.WRITABLE_BOOK), (width / 2) - 100, (height / 2) - 85);
        //String text = "test tset";
        //this.fontRendererObj.drawString(text, (width / 2) - ((text.length() * 5) / 2), (height / 2) - 30, TextFormatting.GRAY.getColorIndex());
	}
}
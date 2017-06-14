package kalman98.elicitation.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiGuidebook extends GuiScreen
{
	public static final ResourceLocation GUIDEBOOK_GUI_TEXTURE = new ResourceLocation("elicitation:textures/gui/guidebook_gui.png"); 

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

        int i = (width - 192) / 2;
        int j = (height - 192) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, 192, 192);
	}
}
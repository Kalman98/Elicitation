package kalman98.elicitation.gui;

import kalman98.elicitation.research.EnumPageType;
import kalman98.elicitation.research.Research;
import kalman98.elicitation.research.ResearchGroup;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiGuidebook extends GuiScreen
{
	public static final ResourceLocation GUIDEBOOK_GUI_TEXTURE = new ResourceLocation("elicitation:textures/gui/guidebook_gui.png");
	public static final int LETTER_WIDTH = 5;
	public Research research;
	public int index = 0;
	public GuiGuidebook(EntityPlayer player)
	{
		
	}

	@Override
	public void initGui()
	{
		super.initGui();
		// arguments are: buttonID, x, y, width, height, textureX, textureY, clickedOffset, texture
		this.addButton(new GuiButtonImage(0, width / 2 - 105, height / 2 + 75, 16, 16, 0, 192, 1, GUIDEBOOK_GUI_TEXTURE));
		this.addButton(new GuiButtonImage(1, width / 2 + 92, height / 2 + 75, 16, 16, 16, 192, 2, GUIDEBOOK_GUI_TEXTURE));
	}
	
	/**
	 * Okay, this method looks really complicated, but it's really simple. Based on the index of
	 * which pages are open in the book, it renders the left and then the right page onto the
	 * GUI image. It has checks for crafting recipes, smelting recipes, plain text, and null.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.disableLighting();
		RenderHelper.disableStandardItemLighting();
		RenderHelper.enableGUIStandardItemLighting();
		GlStateManager.enableAlpha();
		Minecraft.getMinecraft().getTextureManager().bindTexture(GUIDEBOOK_GUI_TEXTURE);
		//-----Begin Test Code-----\\
		ItemStack is = new ItemStack(Items.GLOWSTONE_DUST);
		ResearchGroup group = new ResearchGroup("alchemy", "Alchemy");
		research = new Research("everglow", new ItemStack(net.minecraft.init.Items.GLOWSTONE_DUST)).addInfo(I18n.format("elicitation.research.everglow")).addCraftingRecipe(is, is, is, is, is, is, is, is, is, new ItemStack(Items.LAVA_BUCKET));
		group.addResearch(research);
		research = null;
		//-----End Test Code-----//
		// draw the background texture
        int i = (width - 256) / 2;
        int j = (height - 192) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, 256, 192);
//        this.itemRender.renderItemIntoGUI(new ItemStack(Items.WRITABLE_BOOK), (width / 2) - 100, (height / 2) - 85);
        research = group.getResearch("everglow");
        //-----Page 1: Info-----\\
        if (research.getPage(index).type == EnumPageType.TYPE_INFO)
        	for (int line = 0; line < research.getPage(index).info.size(); line ++)
        		this.fontRendererObj.drawString(research.getPage(index).info.get(line), (int)((width / 2) - 100), (int)(((height / 2) - 80) + (11 * line)), 0);
        //-----Page 1: Crafting-----\\
        else if (research.getPage(index).type == EnumPageType.TYPE_CRAFTING)
        {
        	int count = 0;
        	for (int x = 0; x <= 48; x += 24)
        		for (int y = 0; y <= 48; y += 24)
        		{
        			this.itemRender.renderItemIntoGUI(research.getPage(index).craftingRecipe.get(count), x + (width / 2) - 90, y + (height / 2) - 10);
        			count++;
        		}
        	this.itemRender.renderItemIntoGUI(research.getPage(index).craftingRecipe.get(9), (width / 2) - 65, (height / 2) - 45);
        	this.fontRendererObj.drawString(research.getPage(index).craftingRecipe.get(9).getDisplayName(), (width / 2) - 58 - (fontRendererObj.getStringWidth(research.getPage(index).craftingRecipe.get(9).getDisplayName()) / 2), (height / 2) - 70, 1);
        }
        	// if available, render the second page of text
        int index2 = index + 1;
        //-----Page 2: Info-----\\
        if (index2 < research.info.size())
        	if (research.getPage(index2).type == EnumPageType.TYPE_INFO)
        		for (int line = 0; line < research.getPage(index2).info.size(); line ++)
        			this.fontRendererObj.drawString(research.getPage(index2).info.get(line), (int)((width / 2) + 10), (int)(((height / 2) - 80) + (11 * line)), 0);
        //-----Page 2: Crafting-----\\
	        else if (research.getPage(index2).type == EnumPageType.TYPE_CRAFTING)
	        {
	        	int count = 0;
	        	for (int x = 0; x <= 48; x += 24)
	        		for (int y = 0; y <= 48; y += 24)
	        		{
	        			this.itemRender.renderItemIntoGUI(research.getPage(index2).craftingRecipe.get(count), x + (width / 2) + 26, y + (height / 2) - 10);
	        			count++;
	        		}
	        	this.itemRender.renderItemIntoGUI(research.getPage(index2).craftingRecipe.get(9), (width / 2) + 50, (height / 2) - 45);
	        	this.fontRendererObj.drawString(research.getPage(index2).craftingRecipe.get(9).getDisplayName(), (width / 2) + 58 - (fontRendererObj.getStringWidth(research.getPage(index).craftingRecipe.get(9).getDisplayName()) / 2), (height / 2) - 70, 1);
	        }
        super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	public void actionPerformed(GuiButton button)
	{
		System.out.println(index + ", " + (index - 2));
		System.out.println(button.id);
		switch(button.id)
		{
		case 0: if (index - 2 >= 0) index -= 2;
				break;
		case 1: if (index + 2 <= research.info.size()) index += 2;
				break;
		}
	}
}
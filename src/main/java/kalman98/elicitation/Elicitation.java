package kalman98.elicitation;

import kalman98.elicitation.gui.GuiHandler;
import kalman98.elicitation.items.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Elicitation.MODID, version = Elicitation.VERSION)
public class Elicitation
{
	//---------------- Mod Constants ----------------\\
    public static final String MODID = "elicitation";
    public static final String VERSION = "0.0.1";
    
	@Mod.Instance(Elicitation.MODID)
	public static Elicitation instance;
	
    //------------- Initialization -------------\\ 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    
		NetworkRegistry.INSTANCE.registerGuiHandler(Elicitation.instance, new GuiHandler());
		Items.setup();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
}

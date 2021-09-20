package ink.ikx.rt;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Main.MODID,
        name = Main.NAME,
        version = Main.VERSION,
        dependencies = Main.DESPENDENCIES
)
public class Main {

    public static final String MODID = "randomtweaker";
    public static final String NAME = "RandomTweaker";
    public static final String VERSION = "2.0";
    public static final String DESPENDENCIES = "required-after:crafttweaker;after:contenttweaker";

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) {
    }

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {

    }

}

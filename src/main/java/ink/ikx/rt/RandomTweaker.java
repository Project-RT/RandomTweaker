package ink.ikx.rt;

import com.google.common.collect.BiMap;
import ink.ikx.rt.api.instance.file.Prop;
import ink.ikx.rt.api.instance.jei.interfaces.JEIPanel;
import ink.ikx.rt.api.instance.player.IPlayerExpansionFTBU;
import ink.ikx.rt.api.instance.player.IPlayerExpansionSanity;
import ink.ikx.rt.api.instance.utils.RTGlobal;
import ink.ikx.rt.impl.botania.subtitle.SubTileHydroangeasModified;
import ink.ikx.rt.impl.client.capability.PlayerSanityCapabilityHandler;
import ink.ikx.rt.impl.client.network.PlayerSanityNetWork;
import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.events.DreamJournal;
import ink.ikx.rt.impl.item.SanityGem;
import ink.ikx.rt.impl.utils.ItemDs;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.player.IPlayer;
import crafttweaker.zenscript.GlobalRegistry;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.lib.LibBlockNames;

@Mod(
    modid = RandomTweaker.MODID,
    name = RandomTweaker.NAME,
    version = RandomTweaker.VERSION,
    guiFactory = RandomTweaker.GUI_FACTORY,
    dependencies = RandomTweaker.DESPENDENCIES
)
public class RandomTweaker {

    public static final String MODID = "randomtweaker";
    public static final String NAME = "RandomTweaker";
    public static final String VERSION = "1.0.0";
    public static final String GUI_FACTORY = "com.ikexing.randomtweaker.impl.config.RTConfigGuiFactory";
    public static final String DESPENDENCIES = "required-after:crafttweaker;after:contenttweaker;";

    public static final String THAUMCRAFT = "thaumcraft";
    public static final SanityGem SANITY_GEM = new SanityGem();
    public static final SoundEvent SOUND_SAN = new SoundEvent(
        new ResourceLocation(RandomTweaker.MODID, "san"))
        .setRegistryName(new ResourceLocation(RandomTweaker.MODID, "san"));

    public static Logger logger;
    public static Set<ItemDs> itemDsSet = new HashSet<>();
    public static Map<String, Potion> potionRegList = new HashMap<>();
    public static Map<String, PotionType> potionTypeList = new HashMap<>();
    public static List<JEIPanel> JEIPanel = new ArrayList<>();

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) throws IOException {
        if (Loader.isModLoaded(THAUMCRAFT)) {
            if (RTConfig.Thaumcraft.DreamJournal) {
                MinecraftForge.EVENT_BUS.register(DreamJournal.class);
            }
            GlobalRegistry.registerGlobal("giverDreamJournl", GlobalRegistry
                .getStaticFunction(RTGlobal.class, "giverDreamJournl", IPlayer.class));
        }
        if (RTConfig.RandomTweaker.PlayerSanity) {
            CraftTweakerAPI.registerClass(IPlayerExpansionSanity.class);
        }
        if (RTConfig.FTBUltimine.AllowCrTControl) {
            CraftTweakerAPI.registerClass(IPlayerExpansionFTBU.class);
        }
        if (Prop.createOrDelete(RTConfig.RandomTweaker.Prop)) {
            CraftTweakerAPI.registerClass(Prop.class);
        }
    }

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        PlayerSanityNetWork.register();
        PlayerSanityCapabilityHandler.register();
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        if (!RTConfig.Botania.HydroangeasModified) {
            registryHydroangeasModified();
//            Hydroangeas.init();
        }
    }

    private void registryHydroangeasModified() {
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        try {
            Field field = BotaniaAPI.class.getDeclaredField("subTiles");
            field.setAccessible(true);
            //noinspection unchecked
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) field.get(null);

            if (subTiles != null) {
                subTiles
                    .forcePut(LibBlockNames.SUBTILE_HYDROANGEAS, SubTileHydroangeasModified.class);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

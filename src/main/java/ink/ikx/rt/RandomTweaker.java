package ink.ikx.rt;

import cn.hutool.core.lang.Pair;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.mc1120.CraftTweaker;
import ink.ikx.rt.api.instance.file.Prop;
import ink.ikx.rt.api.instance.player.IPlayerExpansionSanity;
import ink.ikx.rt.api.mods.botania.Hydroangeas;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.api.mods.cote.potion.PotionContent;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIRecipe;
import ink.ikx.rt.api.mods.player.IPlayerExpansionFTBU;
import ink.ikx.rt.impl.botania.subtitle.SubTileHydroangeasModified;
import ink.ikx.rt.impl.client.capability.PlayerSanityCapabilityHandler;
import ink.ikx.rt.impl.client.network.PlayerSanityNetWork;
import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.events.DreamJournal;
import ink.ikx.rt.impl.events.ManaBaubleEvent;
import ink.ikx.rt.impl.item.SanityGem;
import ink.ikx.rt.impl.jei.HydroangeasJEI;
import ink.ikx.rt.impl.proxy.IProxy;
import ink.ikx.rt.impl.utils.ItemDs;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.lib.LibBlockNames;

@SuppressWarnings("unchecked")
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
    public static final String GUI_FACTORY = "ink.ikx.rt.impl.config.RTConfigGuiFactory";
    public static final String DESPENDENCIES = "required-after:crafttweaker;required-after:mixinbooter;after:contenttweaker;";

    public static final SanityGem SANITY_GEM = new SanityGem();
    public static final SoundEvent SOUND_SAN = new SoundEvent(
            new ResourceLocation(RandomTweaker.MODID, "san"))
            .setRegistryName(new ResourceLocation(RandomTweaker.MODID, "san"));

    public static Logger logger;
    public static Set<ItemDs> itemDsSet = new HashSet<>();
    public static Set<JEIPanel> JEIPanelList = new HashSet<>();
    public static List<JEIRecipe> JEIRecipeList = new ArrayList<>();
    public static Map<String, PotionContent> potionRegMap = new HashMap<>();
    public static Map<String, PotionType> potionTypeMap = new HashMap<>();
    public static BiMap<String, Pair<String, SubTileRepresentation>> subTileGeneratingMap = HashBiMap.create();
    @SidedProxy(clientSide = "ink.ikx.rt.impl.proxy.ClientProxy", serverSide = "ink.ikx.rt.impl.proxy.SeverProxy")
    public static IProxy proxy;

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        PlayerSanityNetWork.register();
        PlayerSanityCapabilityHandler.register();
        for (ASMDataTable.ASMData asmData : event.getAsmData().getAll(RTRegisterClass.class.getCanonicalName())) {
            List<String> modids = (List<String>) asmData.getAnnotationInfo().get("value");
            if (modids.stream().allMatch(Loader::isModLoaded)) {
                try {
                    CraftTweakerAPI.registerClass(Class.forName(asmData.getClassName(), false, CraftTweaker.class.getClassLoader()));
                } catch (ClassNotFoundException e) {
                    CraftTweaker.LOG.catching(e);
                }
            }
        }
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        if (RTConfig.Botania.HydroangeasModified && Loader.isModLoaded("botania")) {
            registryHydroangeasModified();
            HydroangeasJEI.init();
        }
    }

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) {
        try {
            registerOtherClass();
        } catch (IOException e) {
            CraftTweakerAPI.logError("The fail occurs inside RT, see latest.log and report it.");
            e.printStackTrace();
        }
    }


    private void registryHydroangeasModified() {
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        try {
            Field field = BotaniaAPI.class.getDeclaredField("subTiles");
            field.setAccessible(true);
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) field.get(null);

            if (subTiles != null) {
                subTiles.forcePut(LibBlockNames.SUBTILE_HYDROANGEAS, SubTileHydroangeasModified.class);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void registerOtherClass() throws IOException {
        if (Loader.isModLoaded("thaumcraft")) {
            if (RTConfig.Thaumcraft.DreamJournal) {
                MinecraftForge.EVENT_BUS.register(DreamJournal.class);
            }
        }
        if (Loader.isModLoaded("botania") && Loader.isModLoaded("contenttweaker")) {
            MinecraftForge.EVENT_BUS.register(ManaBaubleEvent.class);
        }
        if (RTConfig.Botania.HydroangeasModified && Loader.isModLoaded("botania")) {
            CraftTweakerAPI.registerClass(Hydroangeas.class);
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
}

package ink.ikx.rt;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ReflectUtil;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.mods.jei.JEI;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.api.mods.cote.potion.PotionContent;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIRecipe;
import ink.ikx.rt.impl.botania.module.SubTileOrechidManager;
import ink.ikx.rt.impl.botania.subtitle.SubTileHydroangeasModified;
import ink.ikx.rt.impl.botania.subtitle.SubTileOrechidModified;
import ink.ikx.rt.impl.client.capability.PlayerSanityCapabilityHandler;
import ink.ikx.rt.impl.client.network.PlayerSanityNetWork;
import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.item.SanityGem;
import ink.ikx.rt.impl.jei.HydroangeasJEI;
import ink.ikx.rt.impl.jei.OrechidJEI;
import ink.ikx.rt.impl.proxy.IProxy;
import ink.ikx.rt.impl.utils.ItemDs;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.lib.LibBlockNames;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@SuppressWarnings("all")
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
    public static final String VERSION = "1.1.13";
    public static final String GUI_FACTORY = "ink.ikx.rt.impl.config.RTConfigGuiFactory";
    public static final String DESPENDENCIES = "required-after:crafttweaker;after:contenttweaker";

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
        if (Loader.isModLoaded("botania")
                && RTConfig.Botania.OrechidHasDefault
                && RTConfig.Botania.OrechidModified)
            SubTileOrechidManager.oreWeights.put(Blocks.STONE.getDefaultState(), (HashMap<String, Integer>) BotaniaAPI.oreWeights);
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        if (Loader.isModLoaded("botania")) {
            registryFlowerModified();
        }
    }

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) {
        try {
            CrTSupport.registerClass();
            CrTSupport.registerOtherClass();
        } catch (IOException e) {
            CraftTweakerAPI.logError("The fail occurs inside RT, see latest.log and report it.");
            e.printStackTrace();
        }
    }

    private void registryFlowerModified() {
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        Field field = ReflectUtil.getField(BotaniaAPI.class, "subTiles");
        try {
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) ReflectUtil.setAccessible(field).get(null);
            if (Objects.nonNull(subTiles)) {
                if (RTConfig.Botania.HydroangeasModified) {
                    HydroangeasJEI.init();
                    subTiles.forcePut(LibBlockNames.SUBTILE_HYDROANGEAS, SubTileHydroangeasModified.class);
                }
                if (RTConfig.Botania.OrechidModified) {
                    JEI.hideCategory("botania.orechid");
                    subTiles.forcePut(LibBlockNames.SUBTILE_ORECHID, SubTileOrechidModified.class);
                    OrechidJEI.init();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

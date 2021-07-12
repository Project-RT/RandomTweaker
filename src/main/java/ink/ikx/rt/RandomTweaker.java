package ink.ikx.rt;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.api.instance.file.Prop;
import ink.ikx.rt.api.instance.item.ManaBauble;
import ink.ikx.rt.api.instance.item.ManaHelper;
import ink.ikx.rt.api.instance.item.ManaItem;
import ink.ikx.rt.api.instance.player.IPlayerExpansionSanity;
import ink.ikx.rt.api.mods.botania.Hydroangeas;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunction;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunctionWithReturn;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleRender;
import ink.ikx.rt.api.mods.cote.function.mana.ManaItemForItemFunction;
import ink.ikx.rt.api.mods.cote.function.mana.ManaItemForPoolFunction;
import ink.ikx.rt.api.mods.cote.item.ManaBaubleRepresentation;
import ink.ikx.rt.api.mods.cote.item.ManaItemRepresentation;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIRecipe;
import ink.ikx.rt.api.mods.player.IPlayerExpansionFTBU;
import ink.ikx.rt.api.mods.render.BaubleRenderHelper;
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
import net.minecraftforge.fml.common.SidedProxy;
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
    public static Map<String, Potion> potionRegList = new HashMap<>();
    public static Map<String, PotionType> potionTypeList = new HashMap<>();
    public static BiMap<String, SubTileGeneratingRepresentation> subTileGeneratingMap = HashBiMap.create();
    @SidedProxy(clientSide = "ink.ikx.rt.impl.proxy.ClientProxy", serverSide = "ink.ikx.rt.impl.proxy.SeverProxy")
    public static IProxy proxy;

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        PlayerSanityNetWork.register();
        PlayerSanityCapabilityHandler.register();
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        if (RTConfig.Botania.HydroangeasModified && Loader.isModLoaded("botania")) {
            registryHydroangeasModified();
            HydroangeasJEI.init();
        }
    }

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) throws IOException {
        if (Loader.isModLoaded("thaumcraft")) {
            if (RTConfig.Thaumcraft.DreamJournal) {
                MinecraftForge.EVENT_BUS.register(DreamJournal.class);
            }
        }

        if (Loader.isModLoaded("botania") && Loader.isModLoaded("contenttweaker")) {
            CraftTweakerAPI.registerClass(ManaItem.class);
            CraftTweakerAPI.registerClass(ManaBauble.class);
            CraftTweakerAPI.registerClass(ManaHelper.class);
            CraftTweakerAPI.registerClass(BaubleRender.class);
            CraftTweakerAPI.registerClass(BaubleFunction.class);
            CraftTweakerAPI.registerClass(BaubleRenderHelper.class);
            CraftTweakerAPI.registerClass(ManaItemRepresentation.class);
            CraftTweakerAPI.registerClass(ManaItemForPoolFunction.class);
            CraftTweakerAPI.registerClass(ManaItemForItemFunction.class);
            CraftTweakerAPI.registerClass(ManaBaubleRepresentation.class);
            CraftTweakerAPI.registerClass(BaubleFunctionWithReturn.class);

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


    private void registryHydroangeasModified() {
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        try {
            Field field = BotaniaAPI.class.getDeclaredField("subTiles");
            field.setAccessible(true);
            //noinspection unchecked
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) field.get(null);

            if (subTiles != null) {
                subTiles.forcePut(LibBlockNames.SUBTILE_HYDROANGEAS, SubTileHydroangeasModified.class);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

package ink.ikx.rt;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import crafttweaker.mods.jei.JEI;
import ink.ikx.rt.api.mods.astralsorcery.event.CTEventManagerAS;
import ink.ikx.rt.api.mods.botania.ICocoon;
import ink.ikx.rt.api.mods.botania.event.CTEventManager;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import ink.ikx.rt.api.mods.jei.core.IJeiPanel;
import ink.ikx.rt.api.mods.jei.core.IJeiRecipe;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler;
import ink.ikx.rt.impl.internal.config.RTConfig;
import ink.ikx.rt.impl.internal.network.NetworkManager;
import ink.ikx.rt.impl.internal.proxy.IProxy;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import ink.ikx.rt.impl.mods.botania.module.SubTileOrechidManager;
import ink.ikx.rt.impl.mods.botania.subtile.SubTileHydroangeasModified;
import ink.ikx.rt.impl.mods.botania.subtile.SubTileOrechidModified;
import ink.ikx.rt.impl.mods.contenttweaker.MCBotaniaContentEvent;
import ink.ikx.rt.impl.mods.crafttweaker.CraftTweakerExtension;
import ink.ikx.rt.impl.mods.jei.JeiAttunements;
import ink.ikx.rt.impl.mods.jei.JeiHydroangeas;
import ink.ikx.rt.impl.mods.jei.JeiOrechid;
import ink.ikx.rt.impl.mods.thaumcraft.DreamJournalEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.lang3.tuple.Pair;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.lib.LibBlockNames;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Mod(
        modid = Main.MODID,
        name = Main.NAME,
        version = Main.VERSION,
        dependencies = Main.DESPENDENCIES
)
public class Main {

    public static final String MODID = "randomtweaker";
    public static final String NAME = "RandomTweaker";
    public static final String VERSION = "1.2.10";
    public static final String DESPENDENCIES = "required-after:crafttweaker;after:contenttweaker;";

    public static final Set<IJeiPanel> JEI_PANEL_SET = Sets.newHashSet();
    public static final Set<IJeiRecipe> JEI_RECIPE_SET = Sets.newHashSet();
    public static final Map<String, ICocoon> CUSTOM_COCOONS_SPAWN = Maps.newHashMap();
    public static final BiMap<String, Pair<String, ISubTileEntityRepresentation>> SUB_TILE_GENERATING_MAP = HashBiMap.create();

    @SidedProxy(clientSide = "ink.ikx.rt.impl.internal.proxy.ClientProxy", serverSide = "ink.ikx.rt.impl.internal.proxy.ServerProxy")
    public static IProxy proxy;

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) {
        CraftTweakerExtension.registerAllClass(event.getASMHarvestedData());
        if (Loader.isModLoaded("astralsorcery"))
            MinecraftForge.EVENT_BUS.register(CTEventManagerAS.Handler.class);
        if (Loader.isModLoaded("botania")) {
            MinecraftForge.EVENT_BUS.register(CTEventManager.Handler.class);
            if (Loader.isModLoaded("contenttweaker")) {
                MinecraftForge.EVENT_BUS.register(MCBotaniaContentEvent.class);
            }
        }
    }

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        if (RTConfig.Botania.OrechidHasDefault && Loader.isModLoaded("botania")) {
            SubTileOrechidManager.oreWeights.put(Blocks.STONE.getDefaultState(), BotaniaAPI.oreWeights);
        }
        if (Loader.isModLoaded("thaumcraft")) {
            MinecraftForge.EVENT_BUS.register(DreamJournalEvent.class);
        }
        if (InternalUtils.isOpenFtbultimineControl()) {
            NetworkManager.registerFTBUltimineTag();
            CapabilityRegistryHandler.registerFTBUltimineTag();
        }
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        registryFlowerModified();
        registerAttuAltarRecipe();
    }

    @SuppressWarnings("unchecked")
    private void registryFlowerModified() {
        if (!Loader.isModLoaded("botania")) return;
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        try {
            Field field = BotaniaAPI.class.getDeclaredField("subTiles");
            field.setAccessible(true);
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) field.get(null);
            if (Objects.nonNull(subTiles)) {
                if (RTConfig.Botania.OrechidModified) {
                    if (Loader.isModLoaded("jei")) {
                        JeiOrechid.init();
                        JEI.hideCategory("botania.orechid");
                    }
                    subTiles.forcePut(LibBlockNames.SUBTILE_ORECHID, SubTileOrechidModified.class);
                }
                if (RTConfig.Botania.HydroangeasModified) {
                    if (Loader.isModLoaded("jei")) {
                        JeiHydroangeas.init();
                    }
                    subTiles.forcePut(LibBlockNames.SUBTILE_HYDROANGEAS, SubTileHydroangeasModified.class);
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void registerAttuAltarRecipe() {
        if (Loader.isModLoaded("astralsorcery") && Loader.isModLoaded("jei")) {
            JeiAttunements.init();
        }
    }

}

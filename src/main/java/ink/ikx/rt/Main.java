package ink.ikx.rt;

import cn.hutool.core.util.ReflectUtil;
import com.google.common.collect.BiMap;
import com.google.common.collect.Sets;
import crafttweaker.mods.jei.JEI;
import ink.ikx.rt.api.mods.jei.core.IJeiPanel;
import ink.ikx.rt.api.mods.jei.core.IJeiRecipe;
import ink.ikx.rt.impl.internal.config.RTConfig;
import ink.ikx.rt.impl.mods.botania.module.SubTileOrechidManager;
import ink.ikx.rt.impl.mods.botania.subtile.SubTileOrechidModified;
import ink.ikx.rt.impl.mods.crafttweaker.CraftTweakerExtension;
import ink.ikx.rt.impl.mods.thaumcraft.DreamJournalEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.lib.LibBlockNames;

import java.lang.reflect.Field;
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
    public static final String VERSION = "2.0";
    public static final String DESPENDENCIES = "required-after:crafttweaker;after:contenttweaker;";

    public static final Set<IJeiPanel> JEI_PANEL_SET = Sets.newHashSet();
    public static final Set<IJeiRecipe> JEI_RECIPE_SET = Sets.newHashSet();

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) {
        CraftTweakerExtension.registerAllClass();
    }

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        if (RTConfig.Botania.OrechidHasDefault)
            SubTileOrechidManager.oreWeights.put(Blocks.STONE.getDefaultState(), BotaniaAPI.oreWeights);
        if (Loader.isModLoaded("thaumcraft"))
            MinecraftForge.EVENT_BUS.register(DreamJournalEvent.class);
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        registryFlowerModified();
    }

    @SuppressWarnings("unchecked")
    private void registryFlowerModified() {
        if (!Loader.isModLoaded("botania")) return;
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        Field field = ReflectUtil.getField(BotaniaAPI.class, "subTiles");
        try {
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) ReflectUtil.setAccessible(field).get(null);
            if (Objects.nonNull(subTiles)) {
                if (RTConfig.Botania.OrechidModified) {
                    JEI.hideCategory("botania.orechid");
                    subTiles.forcePut(LibBlockNames.SUBTILE_ORECHID, SubTileOrechidModified.class);
//                    OrechidJEI.init(); todo
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

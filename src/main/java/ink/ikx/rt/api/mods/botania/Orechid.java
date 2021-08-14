package ink.ikx.rt.api.mods.botania;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import crafttweaker.mc1120.brackets.BracketHandlerOre;
import ink.ikx.rt.impl.botania.module.SubTileOrechidManager;
import java.util.Arrays;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.randomtweaker.botania.Orechid")
public class Orechid {

    @ZenMethod
    public static void addOreWeight(IItemStack block, IOreDictEntry ore, int weight) {
        if (ore.isEmpty()) {
            CraftTweakerAPI.logError("This ore was empty!");
            return;
        }
        if (Objects.nonNull(getState(block))) {
            SubTileOrechidManager.addOreWeight(getState(block), ore.getName(), weight);
        }
    }

    @ZenMethod
    public static void addOreWeight(crafttweaker.api.block.IBlockState block, IOreDictEntry ore, int weight) {
        if (ore.isEmpty()) {
            CraftTweakerAPI.logError("This ore was empty!");
            return;
        }
        SubTileOrechidManager.addOreWeight(CraftTweakerMC.getBlockState(block), ore.getName(), weight);
    }

    @ZenMethod
    public static void delOreWeight(IItemStack block) {
        if (Objects.nonNull(getState(block)))
            SubTileOrechidManager.delOreWeight(getState(block), "", true);

    }

    @ZenMethod
    public static void delOreWeight(crafttweaker.api.block.IBlockState block) {
        SubTileOrechidManager.delOreWeight(CraftTweakerMC.getBlockState(block), "", true);
    }

    @ZenMethod
    public static void delOreWeight(IItemStack block, String oreName) {
        if (Objects.nonNull(getState(block)))
            SubTileOrechidManager.delOreWeight(getState(block), oreName, false);

    }

    @ZenMethod
    public static void delOreWeight(IItemStack block, IOreDictEntry ore) {
        if (Objects.nonNull(getState(block)))
            SubTileOrechidManager.delOreWeight(getState(block), ore.getName(), false);

    }

    @ZenMethod
    public static void delOreWeight(crafttweaker.api.block.IBlockState block, String oreName) {
        SubTileOrechidManager.delOreWeight(CraftTweakerMC.getBlockState(block), oreName, false);
    }

    @ZenMethod
    public static void delOreWeight(crafttweaker.api.block.IBlockState block, IOreDictEntry ore) {
        SubTileOrechidManager.delOreWeight(CraftTweakerMC.getBlockState(block), ore.getName(), false);
    }

    @ZenMethod
    public static IOreDictEntry[] getOreWeight(IItemStack block) {
        if (Objects.nonNull(getState(block))) {
            return Arrays.stream(SubTileOrechidManager.getOreWeight(getState(block)))
                .map(BracketHandlerOre::getOre)
                .toArray(IOreDictEntry[]::new);
        }
        return null;
    }


    @ZenMethod
    public static IOreDictEntry[] getOreWeight(crafttweaker.api.block.IBlockState block) {
        if (Objects.nonNull(block)) {
            return Arrays.stream(SubTileOrechidManager.getOreWeight(CraftTweakerMC.getBlockState(block)))
                .map(BracketHandlerOre::getOre)
                .toArray(IOreDictEntry[]::new);
        }
        return null;
    }

    private static boolean isItemBlock(IItemStack block) {
        if (!block.isItemBlock()) {
            CraftTweakerAPI.logError("This is not ItemBlock");
            return false;
        }
        return true;
    }

    private static IBlockState getState(IItemStack block) {
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            return mcBlock.getStateFromMeta(block.getMetadata());
        }
        return null;
    }
}

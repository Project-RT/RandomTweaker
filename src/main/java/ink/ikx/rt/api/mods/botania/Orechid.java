package ink.ikx.rt.api.mods.botania;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import crafttweaker.mc1120.brackets.BracketHandlerOre;
import ink.ikx.rt.impl.botania.module.SubTileOrechidManager;
import java.util.Arrays;
import net.minecraft.block.Block;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.atutils.Orechid")
public class Orechid {

    @ZenMethod
    public static void addOreWeight(IItemStack block, IOreDictEntry ore, int weight) {
        if (!ore.isEmpty()) {
            CraftTweakerAPI.logError("This ore was empty");
            return;
        }
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            SubTileOrechidManager.addOreWeight(mcBlock.getStateFromMeta(block.getMetadata()), ore.getName(), weight);
        }
    }

    @ZenMethod
    public static boolean delOreWeight(IItemStack block) {
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            return SubTileOrechidManager.delOreWeight(mcBlock.getStateFromMeta(block.getMetadata()), "", true);
        }
        return false;
    }

    @ZenMethod
    public static boolean delOreWeight(IItemStack block, String oreName) {
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            return SubTileOrechidManager.delOreWeight(mcBlock.getStateFromMeta(block.getMetadata()), oreName, false);
        }
        return false;
    }

    @ZenMethod
    public static IOreDictEntry[] getOreWeight(IItemStack block) {
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            return Arrays.stream(SubTileOrechidManager.getOreWeight(mcBlock.getStateFromMeta(block.getMetadata())))
                .map(BracketHandlerOre::getOre).toArray(IOreDictEntry[]::new);
        }
        return null;
    }

    private static boolean isItemBlock(IItemStack block) {
        if (!block.isItemBlock()) {
            CraftTweakerAPI.logError("This is not ItemBlock");
            return true;
        }
        return false;
    }
}

package ink.ikx.rt.impl.internal.utils;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class Utils {

    public static boolean isItemBlock(IItemStack block) {
        if (!block.isItemBlock()) {
            CraftTweakerAPI.logError("This is not ItemBlock");
            return false;
        }
        return true;
    }

    public static IBlockState getState(IItemStack block) {
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            return mcBlock.getStateFromMeta(block.getMetadata());
        }
        return null;
    }

}

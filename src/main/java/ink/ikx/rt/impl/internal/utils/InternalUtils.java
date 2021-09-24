package ink.ikx.rt.impl.internal.utils;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.stream.Collectors;

public class InternalUtils {

    public static boolean isItemBlock(IItemStack block) {
        return block.isItemBlock();
    }

    public static IBlockState getState(IItemStack block) {
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            return mcBlock.getStateFromMeta(block.getMetadata());
        }
        return null;
    }

    public static List<ItemStack> getItemStacks(List<IItemStack> stacks) {
        return stacks.stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
    }

    public static List<FluidStack> getFluidStacks(List<ILiquidStack> stacks) {
        return stacks.stream().map(CraftTweakerMC::getLiquidStack).collect(Collectors.toList());
    }

}

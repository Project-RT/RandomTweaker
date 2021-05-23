package com.ikexing.randomtweaker.api.tbl;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.item.IItemDefinition;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import thebetweenlands.api.item.CorrosionHelper;

import java.util.List;

/**
 * @author ikexing
 */
@ZenRegister
@ModOnly("thebetweenlands")
@ZenClass("mods.randomtweaker.BLItem")
public class BLItemHandler {
    @ZenMethod
    public static void addCorrosionPropertyOverrides(IItemDefinition item) {
        CorrosionHelper.addCorrosionPropertyOverrides(CraftTweakerMC.getItem(item));
    }

    @ZenMethod
    public static void getModifier(IItemStack item) {
        CorrosionHelper.getModifier(CraftTweakerMC.getItemStack(item));
    }

    @ZenMethod
    public static void getDestroySpeed(IItemStack item, float normalStrength, IBlockState blockState) {
        CorrosionHelper.getDestroySpeed(normalStrength, CraftTweakerMC.getItemStack(item), CraftTweakerMC.getBlockState(blockState));
    }

    @ZenMethod
    public static boolean shouldCauseBlockBreakReset(IItemStack oldStack, IItemStack newStack) {
        return CorrosionHelper.shouldCauseBlockBreakReset(CraftTweakerMC.getItemStack(oldStack), CraftTweakerMC.getItemStack(newStack));
    }

    @ZenMethod
    public static boolean shouldCauseReequipAnimation(IItemStack oldStack, IItemStack newStack, boolean slotChanged) {
        return CorrosionHelper.shouldCauseReequipAnimation(CraftTweakerMC.getItemStack(oldStack), CraftTweakerMC.getItemStack(newStack), slotChanged);
    }

    @ZenMethod
    public static boolean areItemStackTagsEqual(IItemStack oldStack, IItemStack newStack) {
        return CorrosionHelper.areItemStackTagsEqual(CraftTweakerMC.getItemStack(oldStack), CraftTweakerMC.getItemStack(newStack));
    }

    @ZenMethod
    public static void addCorrosionTooltips(IItemStack stack, List<String> lines, boolean advancedItemTooltips) {
        CorrosionHelper.addCorrosionTooltips(CraftTweakerMC.getItemStack(stack), lines, advancedItemTooltips);
    }

    @ZenMethod
    public static int getCoatingStage(IItemStack stack) {
        return CorrosionHelper.getCoatingStage(CraftTweakerMC.getItemStack(stack));
    }

    @ZenMethod
    public static int getCorrosionStage(IItemStack stack) {
        return CorrosionHelper.getCorrosionStage(CraftTweakerMC.getItemStack(stack));
    }
}

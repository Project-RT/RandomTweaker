package ink.ikx.rt.api.mods.item;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import java.util.List;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;
import thebetweenlands.api.item.CorrosionHelper;

@ZenRegister
@ModOnly("thebetweenlands")
@ZenExpansion("crafttweaker.item.IItemStack")
public class IItemStackExpansionTBL {

    @ZenMethod
    public static float getModifier(IItemStack item) {
        return CorrosionHelper.getModifier(CraftTweakerMC.getItemStack(item));
    }

    @ZenMethod
    public static float getDestroySpeed(IItemStack item, float normalStrength,
        IBlockState blockState) {
        return CorrosionHelper.getDestroySpeed(normalStrength, CraftTweakerMC.getItemStack(item), CraftTweakerMC.getBlockState(blockState));
    }

    @ZenMethod
    public static void addCorrosionTooltips(IItemStack stack, List<String> lines,
        boolean advancedItemTooltips) {
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

    @ZenMethodStatic
    public static void addCorrosionPropertyOverrides(IItemStack stack) {
        CorrosionHelper.addCorrosionPropertyOverrides(CraftTweakerMC.getItem(stack.getDefinition()));
    }

    @ZenMethodStatic
    public static boolean shouldCauseBlockBreakReset(IItemStack oldStack, IItemStack newStack) {
        return CorrosionHelper.shouldCauseBlockBreakReset(CraftTweakerMC.getItemStack(oldStack),
            CraftTweakerMC.getItemStack(newStack));
    }

    @ZenMethodStatic
    public static boolean shouldCauseReequipAnimation(IItemStack oldStack, IItemStack newStack,
        boolean slotChanged) {
        return CorrosionHelper.shouldCauseReequipAnimation(CraftTweakerMC.getItemStack(oldStack), CraftTweakerMC.getItemStack(newStack), slotChanged);
    }

    @ZenMethodStatic
    public static boolean areItemStackTagsEqual(IItemStack oldStack, IItemStack newStack) {
        return CorrosionHelper.areItemStackTagsEqual(CraftTweakerMC.getItemStack(oldStack), CraftTweakerMC.getItemStack(newStack));
    }
}

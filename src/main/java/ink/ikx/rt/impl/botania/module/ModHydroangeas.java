package ink.ikx.rt.impl.botania.module;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;

/**
 * @author niyan
 */
public class ModHydroangeas {

    public static List<HydroangeasHandler> handlerList = new ArrayList<>();
    public static Map<IItemStack, Double> blockFactorList = new HashMap<>();
    public static Map<ILiquidStack, Double> fluidFactorList = new HashMap<>();

    public static void setBlockBelowFactor(IItemStack block, double factor) {
        if (block.isItemBlock()) {
            blockFactorList.put(block, factor);
        } else {
            CraftTweakerAPI.getLogger().logError(block + " is not a block.");
        }
    }

    public static void setFluidFactor(ILiquidStack inputFluid, double factor) {
        fluidFactorList.put(inputFluid, factor);
    }

    public static class HydroangeasHandler {

        ILiquidStack liquidConsume;
        int manaGen;

        public HydroangeasHandler(ILiquidStack input, int manaGen, double factor) {
            this.liquidConsume = input;
            this.manaGen = manaGen;
        }

        public Block getBlockLiquid() {
            return getBlock(liquidConsume);
        }

        public int getManaGen() {
            return this.manaGen;
        }

    }

    public static Block getBlock(ILiquidStack inputFluid) {
        return CraftTweakerMC.getLiquidStack(inputFluid).getFluid().getBlock();
    }
}

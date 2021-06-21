package ink.ikx.rt.api.mods.botania;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import ink.ikx.rt.impl.botania.module.ModHydroangeas;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author niyan
 */
@ZenRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.Hydroangeas")
public class Hydroangeas {

    @ZenMethod
    public static void addManaRecipe(ILiquidStack inputFluid, int mana, double factor) {
        ModHydroangeas.handlerList.add(new ModHydroangeas.HydroangeasHandler(inputFluid, mana, factor));
    }

    @ZenMethod
    public static void addManaRecipe(ILiquidStack inputFluid, int mana) {
        addManaRecipe(inputFluid, mana, 2.0D);
    }

    @ZenMethod
    public static void setFactor(ILiquidStack inputFluid) {
        ModHydroangeas.setFluidFactor(inputFluid);
    }

    @ZenMethod
    public static void setBlockBelowFactor(IItemStack block, double factor) {
        ModHydroangeas.setBlockBelowFactor(block, factor);
    }

    @ZenMethod
    public static void setBlockBelowFactor(IItemStack block) {
        setBlockBelowFactor(block, 2.0D);
    }
}

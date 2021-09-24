package ink.ikx.rt.api.mods.botania;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.mods.jei.JEI;
import ink.ikx.rt.impl.mods.botania.module.HydroangeasManager;
import net.minecraft.client.resources.I18n;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.IHydroangeas")
public abstract class IHydroangeas {

    @ZenMethod
    public static void addManaRecipe(ILiquidStack inputFluid, int mana, ILiquidStack liquidCat, double factor) {
        HydroangeasManager.handlerList.add(new HydroangeasManager.HydroangeasHandler(inputFluid, mana, liquidCat, factor));
    }

    @ZenMethod
    public static void addManaRecipe(ILiquidStack inputFluid, int mana) {
        addManaRecipe(inputFluid, mana, null, 1.0D);
    }

    @ZenMethod
    public static void setFactor(ILiquidStack inputFluid, ILiquidStack liquidCat, double factor) {
        HydroangeasManager.setFluidFactor(inputFluid, liquidCat, factor);
    }

    @ZenMethod
    public static void setBlockBelowFactor(IItemStack block, double factor) {
        HydroangeasManager.setBlockBelowFactor(block, factor);
        String desc = I18n.format("text.randomtweaker.hydroangeas_factorblock_description");
        String s_factor = I18n.format("text.randomtweaker.factor") + factor;
        String[] str = {desc, s_factor};
        JEI.addDescription((IIngredient) block, str);
    }

    @ZenMethod
    public static void setBlockBelowFactor(IItemStack block) {
        setBlockBelowFactor(block, 2.0D);
    }

}

package ink.ikx.rt.api.mods.botania.subtile;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import youyihj.zenutils.api.zenscript.SidedZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.mods.jei.JEI;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import ink.ikx.rt.impl.mods.botania.module.SubTileHydroangeasManager;
import net.minecraft.client.resources.I18n;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Objects;

@SidedZenRegister(modDeps = "botania")
@ZenClass("mods.randomtweaker.botania.IHydroangeas")
public abstract class IHydroangeas {

    @ZenMethod
    public static void addManaRecipe(ILiquidStack inputFluid, int mana) {
        addManaRecipe(inputFluid, mana, null, 1.0D);
    }

    @ZenMethod
    public static void addManaRecipe(ILiquidStack inputFluid, int mana, ILiquidStack liquidCatalyst, double factor) {
        CraftTweakerAPI.apply(new ActionAddManaRecipe(mana, factor, inputFluid, liquidCatalyst));
    }

    @ZenMethod
    public static void setBlockBelowFactor(IItemStack block, @Optional(valueDouble = 2.0D) double factor) {
        CraftTweakerAPI.apply(new ActionBlockBelowFactor(block, factor));
    }

    public static class ActionAddManaRecipe implements IAction {

        int mana;
        double factor;
        ILiquidStack inputFluid;
        ILiquidStack liquidCatalyst;

        public ActionAddManaRecipe(int mana, double factor, ILiquidStack inputFluid, ILiquidStack liquidCatalyst) {
            this.mana = mana;
            this.factor = factor;
            this.inputFluid = inputFluid;
            this.liquidCatalyst = liquidCatalyst;
        }

        @Override
        public void apply() {
            SubTileHydroangeasManager.handlerList.add(new SubTileHydroangeasManager.HydroangeasHandler(inputFluid, mana, liquidCatalyst, factor));
        }

        @Override
        public String describe() {
            if (Objects.isNull(liquidCatalyst))
                return "Adding IHydroangeas Recipes for input -> " + inputFluid.toCommandString() + " : " + mana;
            return "Adding IHydroangeas Recipes for input -> " + inputFluid.toCommandString() + " : " + mana +
                    ", liquidCatalyst -> " + liquidCatalyst.toCommandString() + ":" + factor;
        }

    }

    public static class ActionBlockBelowFactor implements IAction {

        private final double factor;
        private final IItemStack block;

        public ActionBlockBelowFactor(IItemStack block, double factor) {
            this.block = block;
            this.factor = factor;
        }

        @Override
        public void apply() {
            SubTileHydroangeasManager.setBlockBelowFactor(block, factor);
            String desc = I18n.format("text.randomtweaker.hydroangeas_factorblock_description");
            String s_factor = I18n.format("text.randomtweaker.factor") + factor;
            String[] str = {desc, s_factor};
            JEI.addDescription((IIngredient) block, str);
        }

        @Override
        public String describe() {
            return "Setting IHydroangeas Block Below Factor is " + block.toCommandString() + ", factor: " + factor;
        }

        @Override
        public boolean validate() {
            return InternalUtils.isItemBlock(block);
        }

        @Override
        public String describeInvalid() {
            return "The IItemStack is not ItemBlock";
        }

    }

}

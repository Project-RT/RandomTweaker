package ink.ikx.rt.api.mods.thaumicadditions;

import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import org.zeith.thaumicadditions.api.RecipesFluxConcentrator;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

@RTRegister
@ModOnly("thaumadditions")
@ZenClass("mods.randomtweaker.thaumadditions.IFluxConcentrator")
public abstract class IFluxConcentrator {

    public static final List<IBlockState> LATE_REMOVES = Lists.newArrayList();

    @ZenMethod
    public static void addRecipes(IIngredient input, IItemStack output) {
        if (input == null || output == null) {
            CraftTweakerAPI.logError("input or output can't be null!!");
        } else if (!input.getItems().stream().allMatch(IItemStack::isItemBlock) || !output.isItemBlock()) {
            CraftTweakerAPI.logError("input or output is not a block!");
        } else {
            CraftTweakerAPI.apply(new AddRecipeAction(input, CraftTweakerMC.getBlockState(InternalUtils.getStateFromStack(output))));
        }
    }

    @ZenMethod
    public static void addRecipes(IBlockState input, IBlockState output) {
        if (input == null || output == null) {
            CraftTweakerAPI.logError("input or output can't be null!!");
        } else {
            CraftTweakerAPI.apply(new AddRecipeAction(input, output));
        }
    }

    @ZenMethod
    public static void removeRecipes(IItemStack input) {
        if (input == null) {
            CraftTweakerAPI.logError("input can't be null!");
        } else if (!input.isItemBlock()) {
            CraftTweakerAPI.logError("input is not a block!");
        } else {
            IFluxConcentrator.removeRecipes(CraftTweakerMC.getBlockState(InternalUtils.getStateFromStack(input)));
        }
    }

    @ZenMethod
    public static void removeRecipes(IBlockState output) {
        if (output == null) {
            CraftTweakerAPI.logError("output can't be null!");
        } else {
            CraftTweakerAPI.apply(new RemoveRecipeAction(output));
        }
    }

    public static class AddRecipeAction implements IAction {

        private final IBlockState output;
        private IIngredient input;
        private IBlockState input_;

        public AddRecipeAction(IIngredient input, IBlockState output) {
            this.input = input;
            this.output = output;
        }

        public AddRecipeAction(IBlockState input_, IBlockState output) {
            this.input_ = input_;
            this.output = output;
        }

        @Override
        public void apply() {
            if (input_ != null) {
                RecipesFluxConcentrator.handle(CraftTweakerMC.getBlockState(input_),
                        RecipesFluxConcentrator.output(CraftTweakerMC.getBlockState(output)));
            } else {
                for (IItemStack item : input.getItems()) {
                    if (item.getMetadata() == 32767) {
                        for (IItemStack subItem : item.getDefinition().getSubItems()) {
                            RecipesFluxConcentrator.handle(InternalUtils.getStateFromStack(subItem),
                                    RecipesFluxConcentrator.output(CraftTweakerMC.getBlockState(output)));
                        }
                    } else {
                        RecipesFluxConcentrator.handle(InternalUtils.getStateFromStack(item),
                                RecipesFluxConcentrator.output(CraftTweakerMC.getBlockState(output)));
                    }
                }
            }
        }

        @Override
        public String describe() {
            return "Adding flux concentrator recipe for " + (input == null ? input_.toCommandString() : input.toCommandString()) + " -> " + output.toCommandString();
        }

    }

    public static class RemoveRecipeAction implements IAction {

        private final IBlockState output;

        public RemoveRecipeAction(IBlockState output) {
            this.output = output;
        }

        @Override
        public void apply() {
            IFluxConcentrator.LATE_REMOVES.add(output);
        }

        @Override
        public String describe() {
            return "Removing flux concentrator recipe for input -> " + output.toCommandString();
        }

    }

}

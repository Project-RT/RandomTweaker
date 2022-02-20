package ink.ikx.rt.api.mods.thaumicadditions;

import com.zeitheron.thaumicadditions.api.RecipesFluxConcentrator;
import com.zeitheron.thaumicadditions.api.RecipesFluxConcentrator.FluxConcentratorOutput;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.lang.reflect.Field;
import java.util.Map;

@RTRegister
@ModOnly("thaumadditions")
@ZenClass("mods.randomtweaker.thaumadditions.IFluxConcentrator")
public abstract class IFluxConcentrator {

    @ZenMethod
    public static void addRecipes(IItemStack input, IItemStack output) {
        if (input == null || output == null) {
            CraftTweakerAPI.logError("input or output can't be null!!");
        } else if (!input.isItemBlock() || !output.isItemBlock()) {
            CraftTweakerAPI.logError("input or output is not a block!");
        } else {
            IFluxConcentrator.addRecipes(CraftTweakerMC.getBlockState(InternalUtils.getStateFromStack(input)),
                    CraftTweakerMC.getBlockState(InternalUtils.getStateFromStack(output)));
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
    public static void removeRecipes(IBlockState input) {
        if (input == null) {
            CraftTweakerAPI.logError("Source can't be null!");
        } else {
            CraftTweakerAPI.apply(new RemoveRecipeAction(input));
        }
    }

    public static class AddRecipeAction implements IAction {

        private final IBlockState src;
        private final IBlockState target;

        public AddRecipeAction(IBlockState src, IBlockState target) {
            this.src = src;
            this.target = target;
        }

        @Override
        public void apply() {
            RecipesFluxConcentrator.handle(CraftTweakerMC.getBlockState(src), RecipesFluxConcentrator.output(CraftTweakerMC.getBlockState(target)));
        }

        @Override
        public String describe() {
            return "Adding flux concentrator recipe for " + src.getBlock().getDisplayName() + " -> " + target.getBlock().getDisplayName();
        }

    }

    public static class RemoveRecipeAction implements IAction {

        private final IBlockState input;

        public RemoveRecipeAction(IBlockState input) {
            this.input = input;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void apply() {
            try {
                Field field = RecipesFluxConcentrator.class.getDeclaredField("HANDLERS");
                field.setAccessible(true);
                Map<net.minecraft.block.state.IBlockState, FluxConcentratorOutput> handlers =
                        (Map<net.minecraft.block.state.IBlockState, FluxConcentratorOutput>) field.get(RecipesFluxConcentrator.class);
                handlers.remove(CraftTweakerMC.getBlockState(input));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String describe() {
            return "Removing flux concentrator recipe for input -> " + input.getBlock().getDisplayName();
        }

    }

}

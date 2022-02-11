package ink.ikx.rt.api.mods.botania.subtile;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.oredict.IOreDictEntry;
import crafttweaker.mc1120.brackets.BracketHandlerOre;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import ink.ikx.rt.impl.mods.botania.module.SubTileOrechidManager;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Objects;

@RTRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.IOrechid")
public abstract class IOrechid {

    @ZenMethod
    public static void addOreRecipe(IItemStack block, IOreDictEntry ore, int weight) {
        CraftTweakerAPI.apply(new ActionAddOrechidRecipe(block, ore, weight));
    }

    @ZenMethod
    public static void delOreRecipe(IItemStack block) {
        for (IOreDictEntry ore : getOreRecipes(block)) {
            delOreRecipe(block, ore);
        }
    }

    @ZenMethod
    public static void delOreRecipe(IItemStack block, IOreDictEntry ore) {
        CraftTweakerAPI.apply(new ActionRemoveOrechidRecipe(block, ore));
    }

    @ZenMethod
    public static IOreDictEntry[] getOreRecipes(IItemStack block) {
        return Arrays.stream(SubTileOrechidManager.getOres(InternalUtils.getState(block)))
                .map(BracketHandlerOre::getOre)
                .filter(o -> !o.isEmpty())
                .toArray(IOreDictEntry[]::new);
    }

    private static class ActionAddOrechidRecipe implements IAction {

        private final int weight;
        private final IItemStack block;
        private final IOreDictEntry ore;

        public ActionAddOrechidRecipe(IItemStack block, IOreDictEntry ore, int weight) {
            this.ore = ore;
            this.block = block;
            this.weight = weight;
        }

        @Override
        public void apply() {
            SubTileOrechidManager.addOreWeight(InternalUtils.getState(block), ore.getName(), weight);
        }

        @Override
        public String describe() {
            return "Adding Orechid Recipe for block: " + block.getDisplayName() + " -> " + ore.getName() + ", weight: " + weight;
        }

        @Override
        public boolean validate() {
            return Objects.nonNull(InternalUtils.getState(block)) && !ore.isEmpty();
        }

        @Override
        public String describeInvalid() {
            return "The IItemStack in Orechid recipe is not a block, or the IOreDictEntry is empty.";
        }

    }

    private static class ActionRemoveOrechidRecipe implements IAction {

        private final IItemStack block;
        private final IOreDictEntry ore;
        private String describe;

        public ActionRemoveOrechidRecipe(IItemStack block, IOreDictEntry ore) {
            this.ore = ore;
            this.block = block;
        }

        @Override
        public void apply() {
            SubTileOrechidManager.delOre(InternalUtils.getState(block), ore.getName());
        }

        @Override
        public String describe() {
            return "Removing IOrechid Recipe for block: " + block.getDisplayName() + " -> " + ore.getName();
        }

        @Override
        public boolean validate() {
            if (Objects.isNull(InternalUtils.getState(block))) {
                describe = "The IItemStack is not a block.";
                return false;
            } else if (!SubTileOrechidManager.checkOreExist(InternalUtils.getState(block), ore.getName())) {
                describe = "The IOrechid Recipe not exist.";
                return false;
            }
            return true;
        }

        @Override
        public String describeInvalid() {
            return describe;
        }

    }

}

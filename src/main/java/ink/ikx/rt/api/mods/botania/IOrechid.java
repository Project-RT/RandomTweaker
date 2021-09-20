package ink.ikx.rt.api.mods.botania;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.oredict.IOreDictEntry;
import crafttweaker.mc1120.brackets.BracketHandlerOre;
import ink.ikx.rt.impl.internal.utils.Utils;
import ink.ikx.rt.impl.mods.botania.module.SubTileOrechidManager;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;

@ZenClass("mods.randomtweaker.botania.Orechid")
public abstract class IOrechid {

    @ZenMethod
    public static void addOreWeight(IItemStack block, IOreDictEntry ore, int weight) {
        CraftTweakerAPI.apply(new ActionAddOrechidRecipe(block, ore, weight));
    }

    @ZenMethod
    public static void delOreWeight(IItemStack block) {
        for (IOreDictEntry ore : getOres(block)) {
            delOreWeight(block, ore);
        }
    }

    @ZenMethod
    public static void delOreWeight(IItemStack block, IOreDictEntry ore) {
        CraftTweakerAPI.apply(new ActionRemoveOrechidRecipe(block, ore));
    }

    @ZenMethod
    public static IOreDictEntry[] getOres(IItemStack block) {
        return Arrays.stream(SubTileOrechidManager.getOres(Utils.getState(block)))
                .map(BracketHandlerOre::getOre)
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
            SubTileOrechidManager.addOreWeight(Utils.getState(block), ore.getName(), weight);
        }

        @Override
        public String describe() {
            return "Adding Orechid Recipe for block: " + block.getDisplayName() + " -> " + ore.getName() + ", weight: " + weight;
        }

    }

    private static class ActionRemoveOrechidRecipe implements IAction {

        private final IItemStack block;
        private final IOreDictEntry ore;

        public ActionRemoveOrechidRecipe(IItemStack block, IOreDictEntry ore) {
            this.ore = ore;
            this.block = block;
        }

        @Override
        public void apply() {
            SubTileOrechidManager.delOreWeight(Utils.getState(block), ore.getName());
        }

        @Override
        public String describe() {
            return "Removing Orechid Recipe for block: " + block.getDisplayName() + " -> " + ore.getName();
        }

    }

}

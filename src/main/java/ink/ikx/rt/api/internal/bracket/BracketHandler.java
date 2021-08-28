package ink.ikx.rt.api.internal.bracket;

import crafttweaker.api.potions.IPotion;
import crafttweaker.api.world.IBiome;
import crafttweaker.mc1120.brackets.BracketHandlerBiome;
import crafttweaker.mc1120.brackets.BracketHandlerPotion;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.randomtweaker.BracketHandler")
public class BracketHandler {

    @ZenMethod
    public static IPotion getPotion(String name) {
        return BracketHandlerPotion.getPotion(name);
    }

    @ZenMethod
    public static IBiome getBiome(String name) {
        return BracketHandlerBiome.getBiome(name);
    }
}

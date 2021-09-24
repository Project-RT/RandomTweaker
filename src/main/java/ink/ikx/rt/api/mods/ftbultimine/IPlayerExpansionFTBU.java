package ink.ikx.rt.api.mods.ftbultimine;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("ftbultimine")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenClass("mods.randomtweaker.mods.ftbultimine.IPlayer")
public abstract class IPlayerExpansionFTBU {

    @ZenMethod
    public static void isAllowFTBUltimine(IPlayer player, boolean flag) {
        if (flag) {
            player.addTag("allowFTBUltimine");
        } else {
            player.removeTag("allowFTBUltimine");
        }
    }

}

package ink.ikx.rt.api.mods.ftbultimine;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("ftbultimine")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenClass("mods.randomtweaker.ftbultimine.IPlayer")
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

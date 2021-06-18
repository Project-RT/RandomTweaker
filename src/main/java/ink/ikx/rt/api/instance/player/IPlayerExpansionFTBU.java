package ink.ikx.rt.api.instance.player;

import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionFTBU {

    @ZenMethod
    public static void isAllowFTBUltimine(IPlayer player, boolean flag) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        if (flag) {
            mcPlayer.addTag("allowFTBUltimine");
        } else {
            mcPlayer.removeTag("allowFTBUltimine");
        }
    }

}

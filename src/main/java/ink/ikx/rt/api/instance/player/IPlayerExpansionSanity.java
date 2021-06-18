package ink.ikx.rt.api.instance.player;

import ink.ikx.rt.impl.utils.cap.PlayerSanityHelper;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionSanity {

    @ZenMethod
    public static float getOriginalSanity(IPlayer player) {
        return PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player))
            .getOriginalSanity();
    }

    @ZenMethod
    public static void setOriginalSanity(IPlayer player, int sanity) {
        PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player))
            .setOriginalSanity(sanity);
        PlayerSanityHelper.sync(CraftTweakerMC.getPlayer(player));
    }

    @ZenMethod
    public static float getSanity(IPlayer player) {
        return PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).getSanity();
    }

    @ZenMethod
    public static void setSanity(IPlayer player, float sanity, boolean playSound) {
        PlayerSanityHelper.setSanity(CraftTweakerMC.getPlayer(player), sanity, playSound);
    }

    @ZenMethod
    public static void updateSanity(IPlayer player, float sanity, boolean playSound) {
        setSanity(player, getSanity(player) + sanity, playSound);
    }
}

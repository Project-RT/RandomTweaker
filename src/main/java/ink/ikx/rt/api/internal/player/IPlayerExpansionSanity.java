package ink.ikx.rt.api.internal.player;

import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.utils.cap.PlayerSanityHelper;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionSanity {

    @ZenMethod
    public static int getOriginalSanity(IPlayer player) {
        return PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).getOriginalSanity();
    }

    @ZenMethod
    public static void setOriginalSanity(IPlayer player, int originalSanity) {
        PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).setOriginalSanity(originalSanity);
        PlayerSanityHelper.sync(CraftTweakerMC.getPlayer(player));
    }

    @ZenMethod
    public static float getSanity(IPlayer player) {
        return PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).getSanity();
    }

    @ZenMethod
    public static void setSanity(IPlayer player, float sanity, boolean playSound) {
        PlayerSanityHelper.setSanity(CraftTweakerMC.getPlayer(player), sanity, playSound);
        PlayerSanityHelper.sync(CraftTweakerMC.getPlayer(player));
    }

    @ZenMethod
    public static void updateSanity(IPlayer player, float sanity, boolean playSound) {
        setSanity(player, getSanity(player) + sanity, playSound);
    }
}

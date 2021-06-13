package com.ikexing.randomtweaker.api.instance.player;

import com.ikexing.randomtweaker.impl.client.utils.cap.PlayerSanityHelper;
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
    public static void setSanity(IPlayer player, float sanity) {
        PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).setSanity(sanity);
        PlayerSanityHelper.sync(CraftTweakerMC.getPlayer(player));
    }

    @ZenMethod
    public static void updateSanity(IPlayer player, float sanity) {
        PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).updateSanity(sanity);
        PlayerSanityHelper.sync(CraftTweakerMC.getPlayer(player));
    }
}

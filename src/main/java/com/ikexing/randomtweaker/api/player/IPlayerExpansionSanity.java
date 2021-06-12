package com.ikexing.randomtweaker.api.player;

import com.ikexing.randomtweaker.impl.utils.cap.PlayerSanityHelper;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionSanity {

    @ZenMethod
    public static float getSanity(IPlayer player) {
        return PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).getSanity();
    }

    @ZenMethod
    public static void setSanity(IPlayer player, float sanity) {
        PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).setSanity(sanity);
    }

    @ZenMethod
    public static void updateSanity(IPlayer player, float sanity) {
        PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).updateSanity(sanity);
    }
}

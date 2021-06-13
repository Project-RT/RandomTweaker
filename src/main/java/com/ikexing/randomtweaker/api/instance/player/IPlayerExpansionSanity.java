package com.ikexing.randomtweaker.api.instance.player;

import com.ikexing.randomtweaker.impl.client.utils.cap.PlayerSanityHelper;
import com.ikexing.randomtweaker.impl.events.SanityChangeEvent;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraftforge.common.MinecraftForge;
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
    public static void setOriginalSanity(IPlayer player, int sanity, boolean playSound) {
        if (playSound) {
            PlayerSanityHelper.playSound(CraftTweakerMC.getPlayer(player));
        }
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
        boolean res = MinecraftForge.EVENT_BUS.post(new SanityChangeEvent(
            sanity, CraftTweakerMC.getPlayer(player), playSound));

        if (res) {
            PlayerSanityHelper.getPlayerSanity(CraftTweakerMC.getPlayer(player)).setSanity(sanity);
            PlayerSanityHelper.sync(CraftTweakerMC.getPlayer(player));
        }
    }

    @ZenMethod
    public static void updateSanity(IPlayer player, float sanity, boolean playSound) {
        setSanity(player, getSanity(player) + sanity, playSound);
    }
}

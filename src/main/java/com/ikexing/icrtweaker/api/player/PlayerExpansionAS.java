package com.ikexing.icrtweaker.player;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import hellfirepvp.astralsorcery.common.constellation.IMajorConstellation;
import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.*;

@ZenRegister
@ZenExpansion("crafttweaker.player.IPlayer")
public class PlayerExpansionAS {
    @ZenMethod
    public static int getPerkLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return ResearchManager.getProgress(mcPlayer).getPerkLevel(mcPlayer);
    }

    @ZenMethod
    public static double getPerkExp(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getPerkExp();
    }

    @ZenMethod
    public static String getAttunedConstellation(IPlayer player){
        IMajorConstellation attunedConstellation = ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getAttunedConstellation();
        return attunedConstellation == null ? null : attunedConstellation.getSimpleName();
    }

    @ZenMethod
    public static String[] getKnownConstellations(IPlayer player){
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getKnownConstellations().toArray(new String[0]);
    }

    @ZenMethod
    public static String[] getSeenConstellations(IPlayer player){
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getSeenConstellations().toArray(new String[0]);
    }
}

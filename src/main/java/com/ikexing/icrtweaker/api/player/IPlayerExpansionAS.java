package com.ikexing.icrtweaker.api.player;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import hellfirepvp.astralsorcery.common.constellation.IMajorConstellation;
import hellfirepvp.astralsorcery.common.data.research.PlayerProgress;
import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ZenRegister
@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionAS {
    @ZenGetter("PerkPercentToNextLevel")
    public static float getPerkPercentToNextLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return ResearchManager.getProgress(mcPlayer).getPercentToNextLevel(mcPlayer);
    }

    @ZenGetter("PerkLevel")
    public static int getPerkLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return ResearchManager.getProgress(mcPlayer).getPerkLevel(mcPlayer);
    }

    @ZenGetter("PerkExp")
    public static double getPerkExp(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getPerkExp();
    }

    @ZenMethod
    public static boolean modifyPerkExp(IPlayer player, double exp) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        PlayerProgress prog = ResearchManager.getProgress(mcPlayer);
        if (IPlayerExpansionAS.getAttunedConstellation(player) == null) {
            CraftTweakerAPI.logInfo("This Player is not constellations");
            return false;
        }
        try {
            Class<? extends PlayerProgress> progClass = prog.getClass();
            Method setExp = progClass.getMethod("modifyExp", double.class, EntityPlayer.class);
            setExp.setAccessible(true);
            setExp.invoke(progClass, exp, mcPlayer);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return true;
    }

    @ZenSetter("PerkExp")
    public static boolean setPerkExp(IPlayer player, double exp) {
        PlayerProgress prog = ResearchManager.getProgress(CraftTweakerMC.getPlayer(player));
        if (IPlayerExpansionAS.getAttunedConstellation(player) == null) {
            CraftTweakerAPI.logInfo("This Player is not constellations");
            return false;
        }
        try {
            Class<? extends PlayerProgress> progClass = prog.getClass();
            Method setExp = progClass.getMethod("setExp", double.class);
            setExp.setAccessible(true);
            setExp.invoke(progClass, exp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return true;
    }

    @ZenGetter("AttunedConstellation")
    public static String getAttunedConstellation(IPlayer player) {
        IMajorConstellation attunedConstellation = ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getAttunedConstellation();
        return attunedConstellation == null ? null : attunedConstellation.getSimpleName();
    }

    @ZenGetter("KnownConstellations")
    public static String[] getKnownConstellations(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getKnownConstellations().toArray(new String[0]);
    }

    @ZenGetter("SeenConstellations")
    public static String[] getSeenConstellations(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getSeenConstellations().toArray(new String[0]);
    }
}

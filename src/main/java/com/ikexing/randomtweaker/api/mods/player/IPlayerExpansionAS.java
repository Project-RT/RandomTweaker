package com.ikexing.randomtweaker.api.mods.player;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import hellfirepvp.astralsorcery.common.constellation.IMajorConstellation;
import hellfirepvp.astralsorcery.common.data.research.PlayerProgress;
import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("astralsorcery")
@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionAS {

    @ZenMethod
    public static float getPerkPercentToNextLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        return ResearchManager.getProgress(mcPlayer).getPercentToNextLevel(mcPlayer);
    }

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
            setExp.invoke(prog, exp, mcPlayer);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return true;
    }

    @ZenMethod
    public static boolean setPerkExp(IPlayer player, double exp) {
        PlayerProgress prog = ResearchManager.getProgress(CraftTweakerMC.getPlayer(player));

        if (IPlayerExpansionAS.getAttunedConstellation(player) == null) {
            CraftTweakerAPI.logInfo("This Player is not constellations");
            return false;
        }
        try {
            Class<? extends PlayerProgress> progClass = prog.getClass();
            Method setExp = progClass.getDeclaredMethod("setExp", double.class);
            setExp.setAccessible(true);
            setExp.invoke(prog, exp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return true;
    }

    @ZenMethod
    public static String getAttunedConstellation(IPlayer player) {
        IMajorConstellation attunedConstellation = ResearchManager
            .getProgress(CraftTweakerMC.getPlayer(player)).getAttunedConstellation();
        return attunedConstellation == null ? null : attunedConstellation.getSimpleName();
    }

    @ZenMethod
    public static String[] getKnownConstellations(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player))
            .getKnownConstellations().toArray(new String[0]);
    }

    @ZenMethod
    public static String[] getSeenConstellations(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getSeenConstellations()
            .toArray(new String[0]);
    }
}

package ink.ikx.rt.api.mods.astralsorcery;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import hellfirepvp.astralsorcery.common.constellation.IMajorConstellation;
import hellfirepvp.astralsorcery.common.data.research.PlayerProgress;
import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RTRegister
@ModOnly("astralsorcery")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenClass("mods.randomtweaker.astralsorcery.IPlayer")
public abstract class IPlayerExpansionAs {

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
    public static String getAttunedConstellation(IPlayer player) {
        IMajorConstellation attunedConstellation =
                ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getAttunedConstellation();
        return attunedConstellation == null ? null : attunedConstellation.getSimpleName();
    }

    @ZenMethod
    public static List<String> getKnownConstellations(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getKnownConstellations();
    }

    @ZenMethod
    public static List<String> getSeenConstellations(IPlayer player) {
        return ResearchManager.getProgress(CraftTweakerMC.getPlayer(player)).getSeenConstellations();
    }

    @ZenMethod
    public static boolean modifyPerkExp(IPlayer player, double exp) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        PlayerProgress progress = ResearchManager.getProgress(mcPlayer);
        if (IPlayerExpansionAs.getAttunedConstellation(player) == null) {
            CraftTweakerAPI.logInfo("The Player has not constellations.");
            return false;
        }
        try {
            Class<? extends PlayerProgress> progressClass = progress.getClass();
            Method setExp = progressClass.getMethod("modifyExp", double.class, EntityPlayer.class);
            setExp.setAccessible(true);
            setExp.invoke(progress, exp, mcPlayer);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return true;
    }

    @ZenMethod
    public static boolean setPerkExp(IPlayer player, double exp) {
        PlayerProgress progress = ResearchManager.getProgress(CraftTweakerMC.getPlayer(player));

        if (IPlayerExpansionAs.getAttunedConstellation(player) == null) {
            CraftTweakerAPI.logInfo("This Player is not constellations");
            return false;
        }
        try {
            Class<? extends PlayerProgress> progressClass = progress.getClass();
            Method setExp = progressClass.getDeclaredMethod("setExp", double.class);
            setExp.setAccessible(true);
            setExp.invoke(progress, exp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return true;
    }

}

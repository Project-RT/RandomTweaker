package ink.ikx.rt.api.mods.player;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import ink.ikx.rt.impl.matteroverdrive.IMatterOverdriveAndroid;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;


/**
 * @author skyraah
 */
@ZenRegister
@ModOnly("matteroverdrive")
@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionMO {
    private static EntityPlayer mcPlayer;

    @ZenGetter("isAndroid")
    public static boolean isAndroid(IPlayer player) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        return IMatterOverdriveAndroid.isPlayerAndroid(mcPlayer);
    }

    @ZenGetter("isTurning")
    public static boolean isTurning(IPlayer player) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        return IMatterOverdriveAndroid.isPlayerAndroidTurning(mcPlayer);
    }

    @ZenGetter("isUnlocked")
    public static boolean isUnlocked(IPlayer player, int id, int level) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        boolean unlocked;
        if (IMatterOverdriveAndroid.isPlayerAndroid(mcPlayer)){
            unlocked = IMatterOverdriveAndroid.isUnlocked(mcPlayer, id, level);
        } else {
            unlocked = false;
        }
        return unlocked;
    }

    @ZenGetter("getUnlockedLevel")
    public static int getUnlockedLevel(IPlayer player, int id) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        int unlockedLevel;
        if (IMatterOverdriveAndroid.isPlayerAndroid(mcPlayer)) {
            unlockedLevel = IMatterOverdriveAndroid.getUnlockedLevel(mcPlayer, id);
        } else {
            unlockedLevel = 0;
        }
        return unlockedLevel;
    }

    @ZenGetter("getEnergy")
    public static int getEnergy(IPlayer player) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        return IMatterOverdriveAndroid.getEnergy(mcPlayer);
    }

    @ZenGetter("getMaxEnergy")
    public static int getMaxEnergy(IPlayer player) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        return IMatterOverdriveAndroid.getMaxEnergy(mcPlayer);
    }

    @ZenMethod
    public static void unlockSkill(IPlayer player, int id, @Optional int level, @Optional boolean admin) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        if (IMatterOverdriveAndroid.isPlayerAndroid(mcPlayer)) {
            IMatterOverdriveAndroid.unlock(mcPlayer, id, level, admin);
        }
    }

    @ZenMethod
    public static void setAndroid(IPlayer player, @Optional boolean animation) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        if (!IMatterOverdriveAndroid.isPlayerAndroid(mcPlayer)){
            IMatterOverdriveAndroid.setPlayerAndroid(mcPlayer, true, animation);
        }
    }

    @ZenMethod
    public static void removeAndroid(IPlayer player) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        if (IMatterOverdriveAndroid.isPlayerAndroid(mcPlayer)){
            IMatterOverdriveAndroid.setPlayerAndroid(mcPlayer, false, false);
        }
    }

    @ZenMethod
    public static void resetSkills(IPlayer player, boolean giveBackXP) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        if (!IMatterOverdriveAndroid.isPlayerAndroidTurning(mcPlayer) && IMatterOverdriveAndroid.isPlayerAndroid(mcPlayer)){
            if (giveBackXP) {
                IMatterOverdriveAndroid.resetPlayerAndroidSkills(mcPlayer, true);
            } else if (!giveBackXP) {
                IMatterOverdriveAndroid.resetPlayerAndroidSkills(mcPlayer, false);
            }
        }
    }

    @ZenMethod
    public static int receiveEnergy(IPlayer player, int energy, @Optional boolean receive) {
        mcPlayer = CraftTweakerMC.getPlayer(player);
        return IMatterOverdriveAndroid.receiveEnergy(mcPlayer, energy, receive);
    }
}

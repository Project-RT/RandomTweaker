package ink.ikx.rt.impl.matteroverdrive;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.api.android.IBioticStat;
import matteroverdrive.entity.android_player.AndroidPlayer;
import matteroverdrive.entity.player.MOPlayerCapabilityProvider;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author skyraah
 */
public class IMatterOverdriveAndroid {

    public static boolean isPlayerAndroid(EntityPlayer entityPlayer) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer != null && androidPlayer.isAndroid();
    }

    public static void setPlayerAndroid(EntityPlayer entityPlayer, boolean b, boolean animation) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        if (!animation){
            androidPlayer.setAndroid(b);
        } else if (animation && b) {
            androidPlayer.startConversion();
        } else if (animation && !b){
            androidPlayer.setAndroid(b);
        }
    }

    public static void resetPlayerAndroidSkills(EntityPlayer entityPlayer, boolean b) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        int xpLevels = androidPlayer.resetUnlocked();
        if (b){
            entityPlayer.addExperienceLevel(xpLevels);
        }
    }

    public static boolean isPlayerAndroidTurning(EntityPlayer entityPlayer) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.isTurning();
    }

    public static void unlock(EntityPlayer entityPlayer, int id, int level, boolean admin) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        IBioticStat bioticStat = getIBioticStat(id);
        if (level < bioticStat.maxLevel() && level != 0){
            if (!admin) {
                androidPlayer.tryUnlock(bioticStat, level);
            } else if (admin) {
                androidPlayer.unlock(bioticStat, level);
            }
        } else if (level == 0 || level >= bioticStat.maxLevel()) {
            if (!admin) {
                androidPlayer.tryUnlock(bioticStat, bioticStat.maxLevel());
            } else if (admin) {
                androidPlayer.unlock(bioticStat, bioticStat.maxLevel());
            }
        }
    }

    public static IBioticStat getIBioticStat(int id) {
        String stat = IIBioticStat.values()[id].toString();
        return MatterOverdrive.STAT_REGISTRY.getStat(stat);
    }

    public static boolean isUnlocked(EntityPlayer entityPlayer, int id, int level) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.isUnlocked(getIBioticStat(id), level);
    }

    public static int getUnlockedLevel(EntityPlayer entityPlayer, int id) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.getUnlockedLevel(getIBioticStat(id));
    }

    public static int getEnergy(EntityPlayer entityPlayer) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.getEnergyStored();
    }

    public static int getMaxEnergy(EntityPlayer entityPlayer) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.getMaxEnergyStored();
    }

    public static int receiveEnergy(EntityPlayer entityPlayer, int energy, boolean receive) {
        AndroidPlayer androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.receiveEnergy(energy, receive);
    }
}

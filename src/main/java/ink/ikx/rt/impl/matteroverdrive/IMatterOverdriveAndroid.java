package ink.ikx.rt.impl.matteroverdrive;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.api.android.IBioticStat;
import matteroverdrive.entity.android_player.AndroidPlayer;
import matteroverdrive.entity.player.MOPlayerCapabilityProvider;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author skyraah
 */
/*@Mod.EventBusSubscriber(modid = CollapseUtils.MOD_ID)*/
public class IMatterOverdriveAndroid {

    private static AndroidPlayer androidPlayer;

    public static boolean isPlayerAndroid(EntityPlayer entityPlayer) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer != null && androidPlayer.isAndroid();
    }

    public static void setPlayerAndroid(EntityPlayer entityPlayer, boolean b, boolean animation) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        if (!animation){
            androidPlayer.setAndroid(b);
        } else if (animation && b) {
            androidPlayer.startConversion();
        } else if (animation && !b){
            androidPlayer.setAndroid(b);
        }
    }

    public static void resetPlayerAndroidSkills(EntityPlayer entityPlayer, boolean b) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        int xpLevels = androidPlayer.resetUnlocked();
        if (b){
            entityPlayer.addExperienceLevel(xpLevels);
        }
    }

    public static boolean isPlayerAndroidTurning(EntityPlayer entityPlayer) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.isTurning();
    }

    public static void unlock(EntityPlayer entityPlayer, int id, int level, boolean admin) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
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
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.isUnlocked(getIBioticStat(id), level);
    }

    public static int getUnlockedLevel(EntityPlayer entityPlayer, int id) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.getUnlockedLevel(getIBioticStat(id));
    }

    public static int getEnergy(EntityPlayer entityPlayer) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.getEnergyStored();
    }

    public static int getMaxEnergy(EntityPlayer entityPlayer) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.getMaxEnergyStored();
    }

    public static int receiveEnergy(EntityPlayer entityPlayer, int energy, boolean receive) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(entityPlayer);
        return androidPlayer.receiveEnergy(energy, receive);
    }
/*
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
        androidPlayer = MOPlayerCapabilityProvider.GetAndroidCapability(event.getEntityPlayer());
        if (!event.getWorld().isRemote){
            setPlayerAndroid(event.getEntityPlayer(), true, true);
            event.getEntityPlayer().sendMessage(new TextComponentString("test"));
            if (SyncedConfig.getBooleanValue(GameplayOption.ENABLE_THIRST)) {
                event.getEntityPlayer().sendMessage(new TextComponentString("yep"));
            } else {
                event.getEntityPlayer().sendMessage(new TextComponentString("none"));
            }
            if (androidPlayer.isAndroid()) {
                event.getEntityPlayer().sendMessage(new TextComponentString("is android"));
                int maxEnergy = androidPlayer.getMaxEnergyStored();
                int energy = androidPlayer.getEnergyStored();
                event.getEntityPlayer().sendMessage(new TextComponentString(String.valueOf(maxEnergy)));
                event.getEntityPlayer().sendMessage(new TextComponentString(String.valueOf(energy)));
                if (event.getWorld().getBlockState(event.getPos()) == Blocks.CLAY.getDefaultState()){
                    event.getEntityPlayer().sendMessage(new TextComponentString("right click!"));
                    int a = androidPlayer.receiveEnergy(2000, false);
                    event.getEntityPlayer().sendMessage(new TextComponentString(String.valueOf(a)));
                }
                if (event.getWorld().getBlockState(event.getPos()) == Blocks.GRASS.getDefaultState()){
                    event.getEntityPlayer().sendMessage(new TextComponentString("right click! grass"));
                    int b = androidPlayer.receiveEnergy(2000, true);
                    event.getEntityPlayer().sendMessage(new TextComponentString(String.valueOf(b)));
                }

            } else if (!androidPlayer.isAndroid()) {
                event.getEntityPlayer().sendMessage(new TextComponentString("is not android"));
            }
        }
    }*/
}

package ink.ikx.rt.impl.utils.cap;

import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.impl.client.capability.PlayerSanityCapability;
import ink.ikx.rt.impl.client.capability.PlayerSanityCapabilityHandler;
import ink.ikx.rt.impl.client.network.PlayerSanityNetWork;
import ink.ikx.rt.impl.events.customevent.SanityChangeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;

public class PlayerSanityHelper {

    public static PlayerSanityCapability getPlayerSanity(EntityPlayer player) {
        return player.getCapability(PlayerSanityCapabilityHandler.PlayerSanityCap, null);
    }

    public static void playSound(EntityPlayer player) {
        player.world.playSound(null, player.posX, player.posY, player.posZ,
            RandomTweaker.SOUND_SAN, SoundCategory.PLAYERS, 0.6F, 1);
    }

    public static void setSanity(EntityPlayer player, float sanity, boolean playSound) {
        if (!new SanityChangeEvent(sanity, PlayerSanityHelper.getPlayerSanity(player).getOriginalSanity(), player).post()) {
            if (playSound) {
                PlayerSanityHelper.playSound(player);
            }
            PlayerSanityHelper.getPlayerSanity(player).setSanity(sanity);
            PlayerSanityHelper.sync(player);
        }
    }

    public static void sync(Entity entity) {
        if (entity instanceof EntityPlayer) {
            PlayerSanityNetWork.Sanity.sendClientCustomPacket((EntityPlayer) entity);
        }
    }
}

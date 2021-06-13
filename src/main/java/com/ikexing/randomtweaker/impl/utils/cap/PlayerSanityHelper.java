package com.ikexing.randomtweaker.impl.utils.cap;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapability;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapabilityHandler;
import com.ikexing.randomtweaker.impl.client.network.PlayerSanityNetWork;
import com.ikexing.randomtweaker.impl.events.SanityChangeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.MinecraftForge;

public class PlayerSanityHelper {

    public static PlayerSanityCapability getPlayerSanity(EntityPlayer player) {
        return player.getCapability(PlayerSanityCapabilityHandler.PlayerSanityCap, null);
    }

    public static void playSound(EntityPlayer player) {
        player.world.playSound(null, player.posX, player.posY, player.posZ,
            RandomTweaker.SOUND_SAN, SoundCategory.PLAYERS, 0.6F, 1);
    }

    public static void setSanity(EntityPlayer player, float sanity, boolean playSound) {
        boolean res = MinecraftForge.EVENT_BUS.post(new SanityChangeEvent(
            sanity, player));

        if (!res) {
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

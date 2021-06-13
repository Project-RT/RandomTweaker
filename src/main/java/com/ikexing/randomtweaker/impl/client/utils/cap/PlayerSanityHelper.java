package com.ikexing.randomtweaker.impl.client.utils.cap;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapability;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapabilityHandler;
import com.ikexing.randomtweaker.impl.client.network.PlayerSanityNetWork;
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

    public static void sync(Entity entity) {
        if (entity instanceof EntityPlayer) {
            PlayerSanityNetWork.Sanity.sendClientCustomPacket((EntityPlayer) entity);
        }
    }
}

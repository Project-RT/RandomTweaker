package com.ikexing.randomtweaker.impl.client.utils.cap;

import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapability;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapabilityHandler;
import com.ikexing.randomtweaker.impl.client.network.PlayerSanityNetWork;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerSanityHelper {

    public static PlayerSanityCapability getPlayerSanity(EntityPlayer player) {
        return player.getCapability(PlayerSanityCapabilityHandler.PlayerSanityCap, null);
    }

    public static void sync(Entity entity) {
        if (entity instanceof EntityPlayer) {
            PlayerSanityNetWork.Sanity.sendClientCustomPacket((EntityPlayer) entity);
        }
    }
}

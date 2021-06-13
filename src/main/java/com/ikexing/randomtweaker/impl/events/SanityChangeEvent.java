package com.ikexing.randomtweaker.impl.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class SanityChangeEvent extends Event {

    private final EntityPlayer player;
    private final float sanity;

    public SanityChangeEvent(float sanity, EntityPlayer player) {
        this.sanity = sanity;
        this.player = player;
    }

    public float getSanity() {
        return sanity;
    }

    public EntityPlayer getPlayer() {
        return player;
    }
}

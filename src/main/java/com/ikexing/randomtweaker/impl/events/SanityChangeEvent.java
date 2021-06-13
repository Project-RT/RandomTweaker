package com.ikexing.randomtweaker.impl.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class SanityChangeEvent extends Event {

    private final EntityPlayer player;
    private float sanity;
    private boolean playSound;

    public SanityChangeEvent(float sanity, EntityPlayer player, boolean playSound) {
        this.sanity = sanity;
        this.player = player;
        this.playSound = playSound;
    }

    public boolean isPlaySound() {
        return playSound;
    }

    public void setPlaySound(boolean playSound) {
        this.playSound = playSound;
    }

    public float getSanity() {
        return sanity;
    }

    public void setSanity(float sanity) {
        this.sanity = sanity;
    }

    public EntityPlayer getPlayer() {
        return player;
    }
}

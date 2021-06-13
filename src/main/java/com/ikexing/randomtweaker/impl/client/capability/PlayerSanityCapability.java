package com.ikexing.randomtweaker.impl.client.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public class PlayerSanityCapability implements INBTSerializable<NBTTagCompound> {

    private float sanity;
    private int originalSanity;

    public int getOriginalSanity() {
        return originalSanity;
    }

    public void setOriginalSanity(int originalSanity) {
        this.originalSanity = originalSanity;
    }

    public float getSanity() {
        return sanity;
    }

    public void setSanity(float sanity) {
        this.sanity = sanity;
    }

    public void updateSanity(float sanity) {
        this.sanity += sanity;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setFloat("sanity", sanity);
        nbt.setInteger("oSanity", originalSanity);

        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        setSanity(nbt.getFloat("sanity"));
        setOriginalSanity(nbt.getInteger("oSanity"));
    }
}

package com.ikexing.randomtweaker.impl.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public class PlayerSanityCapability implements INBTSerializable<NBTTagCompound> {

    private float sanity;

    public float getSanity() {
        return sanity;
    }

    public void setSanity(float sanity) {
        this.sanity = sanity;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setFloat("sanity", sanity);

        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        setSanity(nbt.getFloat("sanity"));
    }
}

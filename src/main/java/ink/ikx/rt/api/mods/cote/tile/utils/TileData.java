package ink.ikx.rt.api.mods.cote.tile.utils;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.mc1120.data.NBTConverter;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.TileData")
public class TileData implements INBTSerializable<NBTTagCompound> {

    private final NBTTagCompound nbtTagCompound = new NBTTagCompound();

    public void readFromNBT(NBTTagCompound nbt) {
        this.nbtTagCompound.merge(nbt);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.merge(this.nbtTagCompound);
        return nbt;
    }

    @ZenMethod
    @ZenGetter("data")
    public IData getData() {
        return NBTConverter.from(this.writeToNBT(new NBTTagCompound()), true);
    }

    @ZenMethod
    @ZenSetter("data")
    public void setData(IData data) {
        TileEntityManager.checkDataMap(data);
        this.readFromNBT((NBTTagCompound) NBTConverter.from(data));
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return nbtTagCompound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.nbtTagCompound.merge(nbt);
    }

}

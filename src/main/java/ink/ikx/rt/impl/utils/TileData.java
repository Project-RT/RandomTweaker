package ink.ikx.rt.impl.utils;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.DataMap;
import crafttweaker.api.data.IData;
import crafttweaker.mc1120.data.NBTConverter;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

/**
 * @author youyihj <br /> Mit LICENSE <br /> by -> https://github.com/friendlyhj/ZenUtils/blob/master/src/main/java/youyihj/zenutils/api/cotx/tile/TileData.java
 */
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

    @ZenGetter("data")
    public IData getData() {
        return NBTConverter.from(this.writeToNBT(new NBTTagCompound()), true);
    }

    public static void checkDataMap(IData data) {
        if (!(data instanceof DataMap)) {
            CraftTweakerAPI.logError("data argument must be DataMap", new IllegalArgumentException());
        }
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return nbtTagCompound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.nbtTagCompound.merge(nbt);
    }

    @ZenSetter("data")
    public void setData(IData data) {
        checkDataMap(data);
        this.readFromNBT((NBTTagCompound) NBTConverter.from(data));
    }
}

package ink.ikx.rt.api.mods.cote.flower;

import crafttweaker.api.data.IData;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.mc1120.data.NBTConverter;
import ink.ikx.rt.api.internal.utils.TileData;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.SubTileEntityInGame")
public interface SubTileEntityInGame {

    String TAG_CUSTOM_DATA = "CustomData";
    TileData customData = new TileData();

    @ZenMethod
    void sync();

    @ZenMethod
    String typeOf();

    @ZenMethod
    @ZenGetter("data")
    default IData getCustomData() {
        return customData.getData();
    }

    @ZenMethod
    @ZenSetter("data")
    default void setCustomData(IData data) {
        customData.readFromNBT((NBTTagCompound) NBTConverter.from(data));
    }

    @ZenMethod
    default void updateCustomData(IData data) {
        TileData.checkDataMap(data);
        setCustomData(getCustomData().add(data));
    }

    @ZenMethod
    void addMana(int mana);

    @ZenMethod
    void consumeMana(int mana);

    @ZenMethod
    int getMana();

    @ZenMethod
    int getMaxMana();

    @ZenMethod
    void setMana(int mana);

    @ZenMethod
    int getRedstoneSignal();

    @ZenMethod
    int getPassiveDecayTicks();

    @ZenMethod
    boolean isValidBinding();

    @ZenMethod
    IBlockPos getBindingForCrT();

    Object getInstance();
}

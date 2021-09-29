package ink.ikx.rt.api.mods.contenttweaker.subtile;

import crafttweaker.api.data.IData;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.mc1120.data.NBTConverter;
import ink.ikx.rt.api.internal.utils.ITileData;
import ink.ikx.rt.impl.internal.utils.MCTileData;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.SubTileEntityInGame")
public interface ISubTileEntityInGame {

    String TAG_CUSTOM_DATA = "CustomData";
    ITileData customData = new MCTileData();

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
        ITileData.checkDataMap(data);
        setCustomData(getCustomData().add(data));
    }

    @ZenMethod
    void addMana(int mana);

    @ZenMethod
    void consumeMana(int mana);

    @ZenMethod
    int getMana();

    @ZenMethod
    void setMana(int mana);

    @ZenMethod
    int getMaxMana();

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

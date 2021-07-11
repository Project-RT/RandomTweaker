package ink.ikx.rt.api.mods.cote.tile;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.MCBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.MCWorld;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.mc1120.data.NBTConverter;
import ink.ikx.rt.api.mods.cote.tile.utils.TileData;
import ink.ikx.rt.api.mods.cote.tile.utils.TileEntityManager;
import javax.annotation.Nonnull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.TileEntityInGame")
public class TileEntityContent extends TileEntity implements ITickable {

    private String name;
    private static final String TAG_NAME = "TileName";
    private final TileData customData = new TileData();
    public static final String TAG_CUSTOM_DATA = "CustomData";

    public TileEntityContent() {
    }

    public TileEntityContent(String name) {
        this.name = name;
    }

    @ZenGetter("name")
    @ZenMethod
    public String getName() {
        return name;
    }

    @ZenGetter("data")
    public IData getCustomData() {
        return customData.getData();
    }

    @ZenSetter("data")
    public void setCustomData(IData data) {
        customData.readFromNBT((NBTTagCompound) NBTConverter.from(data));
        this.markDirty();
    }

    @ZenMethod
    public void updateCustomData(IData data) {
        TileEntityManager.checkDataMap(data);
        setCustomData(getCustomData().add(data));
    }

    @Override
    public void update() {
        TileEntityManager.getTickFunction(name).onUpdate(this, new MCWorld(world), new MCBlockPos(pos));
    }

    @Override
    @Nonnull
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString(TAG_NAME, name);
        if (!compound.hasKey(TAG_CUSTOM_DATA)) {
            compound.setTag(TAG_CUSTOM_DATA, new NBTTagCompound());
        }
        customData.writeToNBT(compound.getCompoundTag(TAG_CUSTOM_DATA));
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(@Nonnull NBTTagCompound compound) {
        customData.readFromNBT(compound.getCompoundTag(TAG_CUSTOM_DATA));
        this.name = compound.getString(TAG_NAME);
        super.readFromNBT(compound);
    }
}
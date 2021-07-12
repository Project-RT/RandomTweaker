package ink.ikx.rt.api.mods.cote.flower.generating;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.MCBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.CTPlayer;
import com.teamacronymcoders.contenttweaker.api.ctobjects.enums.Hand;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.MCWorld;
import crafttweaker.api.data.IData;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.block.MCBlockState;
import crafttweaker.mc1120.data.NBTConverter;
import crafttweaker.mc1120.entity.MCEntityLivingBase;
import crafttweaker.mc1120.item.MCItemStack;
import crafttweaker.mc1120.world.MCFacing;
import ink.ikx.rt.api.mods.cote.flower.SubTileManager;
import ink.ikx.rt.impl.utils.TileData;
import java.util.List;
import java.util.Objects;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vazkii.botania.api.subtile.RadiusDescriptor;

// this class need Dynamic generation, dont try modify
public class CustomSubTileGeneratingContent extends SubTileGeneratingContent {

    public static final String TAG_CUSTOM_DATA = "CustomData";
    private static final String TAG_NAME = "SubTileName";
    private final TileData customData = new TileData();
    private final SubTileGeneratingRepresentation subtile;
    private String name;

    public CustomSubTileGeneratingContent(SubTileGeneratingRepresentation subtile) {
        this.subtile = subtile;
    }

    @Override
    public boolean canGeneratePassively() { // 能否被动产魔，不确定.
        return Objects.nonNull(subtile.canGeneratePassively) && subtile.canGeneratePassively.call(new MCBlockPos(getPos()), new MCWorld(getWorld()));
    }

    @Override
    public int getColor() {
        return subtile.getColor();
    }

    @Override
    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(toBlockPos(), subtile.getRange());
    }

    @Override
    public int getMaxMana() {
        return subtile.getMaxMana();
    }

    @Override
    public boolean isPassiveFlower() {
        return subtile.isPassiveFlower();
    }

    @Override
    public boolean acceptsRedstone() {
        return subtile.isAcceptsRedstone();
    }

    @Override
    public void readFromPacketNBT(NBTTagCompound compound) {
        customData.readFromNBT(compound.getCompoundTag(TAG_CUSTOM_DATA));
        this.name = compound.getString(TAG_NAME);
        super.readFromPacketNBT(compound);
    }

    @Override
    public void writeToPacketNBT(NBTTagCompound compound) {
        if (!compound.hasKey(TAG_CUSTOM_DATA)) {
            compound.setTag(TAG_CUSTOM_DATA, new NBTTagCompound());
        }
        customData.writeToNBT(compound.getCompoundTag(TAG_NAME));
        customData.writeToNBT(compound.getCompoundTag(TAG_CUSTOM_DATA));
        super.writeToPacketNBT(compound);
    }

    @Override
    public IData getCustomData() {
        return customData.getData();
    }

    @Override
    public void setCustomData(IData data) {
        customData.readFromNBT((NBTTagCompound) NBTConverter.from(data));
    }

    @Override
    public void updateCustomData(IData data) {
        TileData.checkDataMap(data);
        setCustomData(getCustomData().add(data));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (Objects.nonNull(subtile.onUpdate)) {
            SubTileManager.getTickFunction(name).call(this, new MCWorld(getWorld()), new MCBlockPos(getPos()));
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        return Objects.nonNull(subtile.onBlockActivated) && subtile.onBlockActivated.call(
            new MCWorld(world),
            new MCBlockPos(pos),
            new MCBlockState(state),
            new CTPlayer(player),
            Hand.of(hand),
            new MCFacing(side), hitX, hitY, hitZ);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        if (Objects.nonNull(subtile.onBlockAdded)) {
            subtile.onBlockAdded.call(new MCWorld(world), new MCBlockPos(pos), new MCBlockState(state));
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (Objects.nonNull(subtile.onBlockHarvested)) {
            subtile.onBlockHarvested.call(new MCWorld(world), new MCBlockPos(pos), new MCBlockState(state), new CTPlayer(player));
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
        if (Objects.nonNull(subtile.onBlockPlaceBy)) {
            subtile.onBlockPlaceBy.call(new MCWorld(world), new MCBlockPos(pos), new MCBlockState(state), new MCEntityLivingBase(entity), new MCItemStack(stack));
        }
    }

    @Override
    public void populateDropStackNBTs(List<ItemStack> drops) {
        super.populateDropStackNBTs(drops);
        if (Objects.nonNull(subtile.populateDropStackNBTs)) {
            subtile.populateDropStackNBTs.call(CraftTweakerMC.getIItemStacks(drops.toArray(new ItemStack[0])));
        }
    }

}

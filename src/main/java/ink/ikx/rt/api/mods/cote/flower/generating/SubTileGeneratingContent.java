package ink.ikx.rt.api.mods.cote.flower.generating;

import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.EntityHelper;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.CTPlayer;
import com.teamacronymcoders.contenttweaker.api.ctobjects.enums.Hand;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
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
import vazkii.botania.api.subtile.SubTileGenerating;

public class SubTileGeneratingContent extends SubTileGenerating implements SubTileEntityInGame {

    public String name;
    public final SubTileRepresentation subtile;

    public SubTileGeneratingContent(SubTileRepresentation subtile) {
        this.subtile = subtile;
    }

    @Override
    public boolean canGeneratePassively() {
        SubTileGeneratingRepresentation subtile = (SubTileGeneratingRepresentation) this.subtile;
        return Objects.nonNull(subtile.canGeneratePassively) && subtile.canGeneratePassively.call(CraftTweakerMC.getIBlockPos(getPos()), CraftTweakerMC.getIWorld(getWorld()));
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
        SubTileGeneratingRepresentation subtile = (SubTileGeneratingRepresentation) this.subtile;
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
    public int getDelayBetweenPassiveGeneration() {
        SubTileGeneratingRepresentation subtile = (SubTileGeneratingRepresentation) this.subtile;
        return subtile.getDelayBetweenPassiveGeneration();
    }

    @Override
    public int getValueForPassiveGeneration() {
        SubTileGeneratingRepresentation subtile = (SubTileGeneratingRepresentation) this.subtile;
        return subtile.getValueForPassiveGeneration();
    }

    @Override
    public void addMana(int mana) {
        super.addMana(mana);
    }

    @Override
    public boolean isOvergrowthAffected() {
        return subtile.isOvergrowthAffected();
    }

    @Override
    public boolean shouldSyncPassiveGeneration() {
        SubTileGeneratingRepresentation subtile = (SubTileGeneratingRepresentation) this.subtile;
        return subtile.isShouldSyncPassiveGeneration();
    }

    @Override
    public boolean canSelect(EntityPlayer player, ItemStack wand, BlockPos pos, EnumFacing side) {
        if (Objects.nonNull(subtile.canSelect)) {
            return subtile.canSelect.call(new CTPlayer(player), CraftTweakerMC.getIItemStack(wand), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getIFacing(side));
        }
        return true;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (Objects.nonNull(subtile.onUpdate)) {
            subtile.onUpdate.call(this, CraftTweakerMC.getIWorld(getWorld()), CraftTweakerMC.getIBlockPos(getPos()));
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        return !Objects.nonNull(subtile.onBlockActivated) || subtile.onBlockActivated.call(
            CraftTweakerMC.getIWorld(world),
            CraftTweakerMC.getIBlockPos(pos),
            CraftTweakerMC.getBlockState(state),
            new CTPlayer(player),
            Hand.of(hand),
            CraftTweakerMC.getIFacing(side), hitX, hitY, hitZ);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        if (Objects.nonNull(subtile.onBlockAdded)) {
            subtile.onBlockAdded.call(CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getBlockState(state));
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (Objects.nonNull(subtile.onBlockHarvested)) {
            subtile.onBlockHarvested.call(CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getBlockState(state), new CTPlayer(player));
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
        if (Objects.nonNull(subtile.onBlockPlaceBy)) {
            subtile.onBlockPlaceBy.call(CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getBlockState(state), EntityHelper.getIEntityLivingBase(entity), CraftTweakerMC.getIItemStack(stack));
        }
    }

    @Override
    public void populateDropStackNBTs(List<ItemStack> drops) {
        super.populateDropStackNBTs(drops);
        SubTileGeneratingRepresentation subtile = (SubTileGeneratingRepresentation) this.subtile;
        if (Objects.nonNull(subtile.populateDropStackNBTs)) {
            subtile.populateDropStackNBTs.call(CraftTweakerMC.getIItemStacks(drops.toArray(new ItemStack[0])));
        }
    }

    @Override
    public void sync() {
        super.sync();
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public int getRedstoneSignal() {
        return this.redstoneSignal;
    }

    @Override
    public int getPassiveDecayTicks() {
        return this.passiveDecayTicks;
    }

    @Override
    public boolean isValidBinding() {
        return super.isValidBinding();
    }

    @Override
    public BlockPos getBinding() {
        return super.getBinding();
    }

    @Override
    public String typeOf() {
        return "generating";
    }

    @Override
    public String getUnlocalizedName() {
        return subtile.getUnlocalizedName();
    }

    @Override
    public Object getInstance() {
        return subtile;
    }
}

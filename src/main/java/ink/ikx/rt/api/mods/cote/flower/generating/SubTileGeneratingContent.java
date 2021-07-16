package ink.ikx.rt.api.mods.cote.flower.generating;

import crafttweaker.api.data.IData;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileGenerating;

public abstract class SubTileGeneratingContent extends SubTileGenerating implements SubTileEntityInGame {

    @Override
    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    public abstract boolean canGeneratePassively();

    @Override
    public abstract int getColor();

    @Override
    public abstract RadiusDescriptor getRadius();

    @Override
    public abstract int getMaxMana();

    @Override
    public abstract boolean isPassiveFlower();

    @Override
    public abstract boolean acceptsRedstone();

    @Override
    public abstract boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ);

    @Override
    public abstract void onBlockAdded(World world, BlockPos pos, IBlockState state);

    @Override
    public abstract void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player);

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
    }

    @Override
    public void populateDropStackNBTs(List<ItemStack> drops) {
        super.populateDropStackNBTs(drops);
    }

    @Override
    public abstract int getDelayBetweenPassiveGeneration();

    @Override
    public abstract int getValueForPassiveGeneration();

    @Override
    public abstract boolean canSelect(EntityPlayer player, ItemStack wand, BlockPos pos, EnumFacing side);

    @Override
    public abstract boolean isOvergrowthAffected();

    @Override
    public abstract void updateCustomData(IData data);

    @Override
    public abstract IData getCustomData();

    @Override
    public abstract void setCustomData(IData data);

    @Override
    public void sync() {
        super.sync();
    }

    @Override
    public void addMana(int mana) {
        super.addMana(mana);
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
    public int getKnownMana() {
        return this.knownMana;
    }

    @Override
    public int getPassiveDecayTicks() {
        return this.passiveDecayTicks;
    }

    @Override
    public String typeOf() {
        return "generating";
    }
}

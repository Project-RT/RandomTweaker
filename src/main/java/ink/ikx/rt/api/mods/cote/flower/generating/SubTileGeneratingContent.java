package ink.ikx.rt.api.mods.cote.flower.generating;

import crafttweaker.api.data.IData;
import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileGenerating;

@ZenClass("mods.randomtweaker.cote.CustomSubTileGeneratingContent")
public abstract class SubTileGeneratingContent extends SubTileGenerating {

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

    @ZenMethod
    @ZenGetter("data")
    public abstract IData getCustomData();

    @ZenMethod
    @ZenSetter("data")
    public abstract void setCustomData(IData data);

    @ZenMethod
    public abstract void updateCustomData(IData data);

    @Override
    @ZenMethod
    public int getDelayBetweenPassiveGeneration() {
        return super.getDelayBetweenPassiveGeneration();
    }
}

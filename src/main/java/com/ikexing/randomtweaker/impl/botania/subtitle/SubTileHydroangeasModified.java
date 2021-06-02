package com.ikexing.randomtweaker.impl.botania.subtitle;

import com.ikexing.randomtweaker.impl.botania.module.ModHydroangeas;
import com.ikexing.randomtweaker.impl.config.RTConfig;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import java.util.List;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileGenerating;
import vazkii.botania.common.Botania;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.lexicon.LexiconData;

/**
 * @author niyan
 */
public class SubTileHydroangeasModified extends SubTileGenerating {

    private static final String TAG_BURN_TIME = "burnTime";
    private static final String TAG_COOLDOWN = "cooldown";
    private static final int RANGE = 2;
    private static final int RANGE_Y = 1;

    int burnTime, cooldown;

    double manaGen = 1;
    double manaFactorFluid = 2;
    double manaFactorBlock = 1;

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (cooldown > 0) {
            cooldown--;
            for (int i = 0; i < 3; i++) {
                Botania.proxy.wispFX(supertile.getPos().getX() + 0.5 + Math.random() * 0.2 - 0.1,
                    supertile.getPos().getY() + 0.5 + Math.random() * 0.2 - 0.1,
                    supertile.getPos().getZ() + 0.5 + Math.random() * 0.2 - 0.1, 0.1F, 0.1F, 0.1F,
                    (float) Math.random() / 6, (float) -Math.random() / 30);
            }
        }

        BlockPos pos = supertile.getPos();

        if (burnTime == 0) {
            if (mana < getMaxMana() && !getWorld().isRemote) {

                blockCheck:
                for (BlockPos posCheck : BlockPos.getAllInBox(
                    pos.add(-RANGE, -RANGE_Y, -RANGE),
                    pos.add(RANGE, RANGE_Y, RANGE))) {

                    PropertyInteger prop = supertile.getWorld().getBlockState(posCheck)
                        .getBlock() instanceof BlockLiquid ? BlockLiquid.LEVEL :
                        supertile.getWorld().getBlockState(posCheck)
                            .getBlock() instanceof BlockFluidBase ? BlockFluidBase.LEVEL : null;

                    for (ModHydroangeas.HydroangeasHandler handler : ModHydroangeas.handlerList) {

                        if (getWorld().getBlockState(posCheck).getBlock() == handler
                            .getBlockLiquid()
                            && (prop == null
                            || supertile.getWorld().getBlockState(posCheck).getValue(prop) == 0)) {
                            supertile.getWorld().setBlockToAir(posCheck);
                            manaGen = handler.getManaGen();
                            manaFactorFluid = handler.getManaFactor();

                            if (cooldown == 0) {
                                burnTime += getBurnTime();
                            } else {
                                cooldown = getCooldown();
                            }

                            sync();
                            playSound();
                            break blockCheck;
                        }

                    }

                }
            }
        } else {
            if (supertile.getWorld().rand.nextInt(8) == 0) {
                doBurnParticles();
            }
            burnTime--;

            double t = manaFactorFluid;
            manaFactorFluid = 1;
            for (BlockPos.MutableBlockPos posCheck : BlockPos.getAllInBoxMutable(
                pos.add(-RANGE, -RANGE_Y, -RANGE),
                pos.add(RANGE, RANGE_Y, RANGE))) {

                if (supertile.getWorld().getBlockState(posCheck).getBlock()
                    == ModHydroangeas.fluidFactor) {
                    manaFactorFluid = t;
                    break;
                }
            }
            IItemStack block = CraftTweakerMC.getIItemStack(
                new ItemStack(supertile.getWorld().getBlockState(pos.down()).getBlock()));
            if (ModHydroangeas.blockFactorList.containsKey(block)) {
                manaFactorBlock = ModHydroangeas.blockFactorList.get(block);
            }

            addMana((int) (manaGen * manaFactorFluid * manaFactorBlock));

            if (burnTime == 0) {
                cooldown = getCooldown();
                sync();
            }
        }
    }

    public void doBurnParticles() {
        Botania.proxy.wispFX(supertile.getPos().getX() + 0.55 + Math.random() * 0.2 - 0.1,
            supertile.getPos().getY() + 0.55 + Math.random() * 0.2 - 0.1,
            supertile.getPos().getZ() + 0.5, 0.05F, 0.05F, 0.7F, (float) Math.random() / 6,
            (float) -Math.random() / 60);
    }

    public void playSound() {
        getWorld().playSound(null, supertile.getPos(), SoundEvents.ENTITY_GENERIC_DRINK,
            SoundCategory.BLOCKS, 0.01F, 0.5F + (float) Math.random() * 0.5F);
    }

    public int getBurnTime() {
        return 40;
    }

    @Override
    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(toBlockPos(), RANGE);
    }

    @Override
    public int getMaxMana() {
        return RTConfig.HydroangeasMaxMana;
    }

    @Override
    public int getColor() {
        return 0x532FE0;
    }

    @Override
    public LexiconEntry getEntry() {
        return LexiconData.hydroangeas;
    }

    @Override
    public void writeToPacketNBT(NBTTagCompound cmp) {
        super.writeToPacketNBT(cmp);

        cmp.setInteger(TAG_BURN_TIME, burnTime);
        cmp.setInteger(TAG_COOLDOWN, cooldown);
    }

    @Override
    public void readFromPacketNBT(NBTTagCompound cmp) {
        super.readFromPacketNBT(cmp);

        burnTime = cmp.getInteger(TAG_BURN_TIME);
        cooldown = cmp.getInteger(TAG_COOLDOWN);
    }

    @Override
    public void populateDropStackNBTs(List<ItemStack> drops) {
        super.populateDropStackNBTs(drops);
        int cooldown = this.cooldown;
        if (burnTime > 0) {
            cooldown = getCooldown();
        }

        if (cooldown > 0) {
            ItemNBTHelper.setInt(drops.get(0), TAG_COOLDOWN, getCooldown());
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state,
        EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
        cooldown = ItemNBTHelper.getInt(stack, TAG_COOLDOWN, 0);
    }

    public int getCooldown() {
        return 0;
    }

    @Override
    public boolean isPassiveFlower() {
        return RTConfig.HydroangeasDecay;
    }
}
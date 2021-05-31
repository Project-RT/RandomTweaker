package com.ikexing.randomtweaker.impl.mixins;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Overwrite;
import twilightforest.block.BlockTFPortal;

import static hellfirepvp.astralsorcery.common.lib.BlocksAS.fluidLiquidStarlight;

/**
 * @author ikexing
 */
@Pseudo
@Mixin(BlockTFPortal.class)
public class MixinBlockTFPortal extends BlockBreakable {

    @Shadow(remap = false)
    @Final
    public static IProperty<Boolean> DISALLOW_RETURN;

    protected MixinBlockTFPortal(Material materialIn, boolean ignoreSimilarityIn) {
        super(materialIn, ignoreSimilarityIn);
    }

    /**
     * @author ikexing
     * @reason Modify this portal to support other liquids
     */
    @Overwrite(remap = false)
    public boolean canFormPortal(IBlockState state) {
        System.out.println("test for bool");
        return state == fluidLiquidStarlight.getBlock().getDefaultState() || state.getBlock() == this && state.getValue(DISALLOW_RETURN);
    }
}

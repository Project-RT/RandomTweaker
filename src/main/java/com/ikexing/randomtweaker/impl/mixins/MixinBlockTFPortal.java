package com.ikexing.randomtweaker.impl.mixins.mod;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import twilightforest.block.BlockTFPortal;

import static hellfirepvp.astralsorcery.common.lib.BlocksAS.fluidLiquidStarlight;

/**
 * @author ikexing
 */
@Pseudo
@Mixin(value = BlockTFPortal.class, remap = false)
public class MixinBlockTFPortal extends BlockBreakable {

    @Shadow
    @Final
    public static IProperty<Boolean> DISALLOW_RETURN;

    protected MixinBlockTFPortal(Material materialIn, boolean ignoreSimilarityIn) {
        super(materialIn, ignoreSimilarityIn);
    }

    @Inject(method = "canFormPortal", at = @At(value = "INVOKE", target = "Ltwilightforest/block/BlockTFPortal;canFormPortal(Lnet/minecraft/block/state/IBlockState;)Z", remap = false), cancellable = true)
    public void injectCanFormPortal(IBlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(state == fluidLiquidStarlight.getBlock().getDefaultState() || state.getBlock() == this && state.getValue(DISALLOW_RETURN));
    }

    /**
     * @author ikexing
     * @reason Modify this portal to support other liquids
     */
//    @Overwrite(remap = false)
//    public boolean canFormPortal(IBlockState state) {
//        System.out.println("test for bool");
//        return state == fluidLiquidStarlight.getBlock().getDefaultState() || state.getBlock() == this && state.getValue(DISALLOW_RETURN);
//    }
}

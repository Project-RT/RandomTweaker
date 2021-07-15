package ink.ikx.rt.impl.mixins.mods;

import crafttweaker.api.block.IBlock;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.brackets.BracketHandlerLiquid;
import ink.ikx.rt.impl.config.RTConfig;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import twilightforest.block.BlockTFPortal;

@Pseudo
@Mixin(value = BlockTFPortal.class, remap = false)
public class MixinBlockTFPortal extends BlockBreakable {

    @Shadow
    @Final
    public static IProperty<Boolean> DISALLOW_RETURN;

    protected MixinBlockTFPortal(Material materialIn, boolean ignoreSimilarityIn) {
        super(materialIn, ignoreSimilarityIn);
    }

    @Inject(method = "canFormPortal", at = @At(value = "HEAD"), cancellable = true)
    private void injectCanFormPortal(IBlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(state == getLiquidState(RTConfig.TwilightForest.TFPortalLiquid) || state.getBlock() == this && state.getValue(DISALLOW_RETURN));
    }

    @ModifyArgs(method = "neighborChanged",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z")
    )
    private void modifyArgsNeighborChanged(Args args) {
        args.set(1, getLiquidState(RTConfig.TwilightForest.TFPortalLiquid));
    }

    private static IBlockState getLiquidState(String liquidName) {
        if (BracketHandlerLiquid.getLiquid(liquidName) != null) {
            IBlock liquidIBlock = BracketHandlerLiquid.getLiquid(liquidName).getDefinition().getBlock();
            return CraftTweakerMC.getBlock(liquidIBlock).getDefaultState();
        } else {
            return Blocks.WATER.getDefaultState();
        }
    }
}

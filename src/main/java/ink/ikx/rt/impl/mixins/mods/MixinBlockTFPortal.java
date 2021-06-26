package ink.ikx.rt.impl.mixins.mods;

import ink.ikx.rt.impl.config.RTConfig;
import crafttweaker.api.block.IBlock;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.brackets.BracketHandlerLiquid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
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

    /**
     * @author ikexing
     * @reason Modify this portal to support other liquids
     */
    @Deprecated
    @Overwrite
    public void func_189540_a(IBlockState state, World world, BlockPos pos, Block notUsed, BlockPos fromPos) {
        boolean good = world.getBlockState(pos.down()).isFullCube();

        for (EnumFacing facing : EnumFacing.HORIZONTALS) {
            if (!good) {
                break;
            }

            IBlockState neighboringState = world.getBlockState(pos.offset(facing));

            good = isGrassOrDirt(neighboringState) || neighboringState == state;
        }

        if (!good) {
            world.playEvent(2001, pos, Block.getStateId(state));
            world.setBlockState(pos, getLiquidState(RTConfig.TwilightForest.TFPortalLiquid), 0b11);
        }
    }

    /**
     * @author ikexing
     * @reason Modify this portal to support other liquids
     */
    @Overwrite(remap = false)
    public boolean canFormPortal(IBlockState state) {
        return state == getLiquidState(RTConfig.TwilightForest.TFPortalLiquid) || state.getBlock() == this && state.getValue(DISALLOW_RETURN);
    }

    private static IBlockState getLiquidState(String liquidName) {
        if (BracketHandlerLiquid.getLiquid(liquidName) != null) {
            IBlock liquidIBlock = BracketHandlerLiquid.getLiquid(liquidName).getDefinition().getBlock();
            return CraftTweakerMC.getBlock(liquidIBlock).getDefaultState();
        } else {
            return Blocks.WATER.getDefaultState();
        }
    }

    private static boolean isGrassOrDirt(IBlockState state) {
        Material mat = state.getMaterial();
        return state.isFullCube() && (mat == Material.GRASS || mat == Material.GROUND);
    }
}

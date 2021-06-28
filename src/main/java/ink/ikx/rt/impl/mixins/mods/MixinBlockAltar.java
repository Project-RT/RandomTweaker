package ink.ikx.rt.impl.mixins.mods;

import java.util.Objects;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.block.BlockAltar;
import vazkii.botania.common.block.tile.TileAltar;

@Mixin(BlockAltar.class)
public class MixinBlockAltar {

    @Inject(method = "onBlockActivated", at = @At(value = "TAIL"), cancellable = true)
    public void injectOnBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing par6, float par7, float par8, float par9, CallbackInfoReturnable<Boolean> cir) {
        TileAltar tile = (TileAltar) world.getTileEntity(pos);
        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote && !stack.isEmpty() && !Objects.requireNonNull(tile).hasWater && !tile.hasLava) {

        }
    }

}

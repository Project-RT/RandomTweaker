package ink.ikx.rt.mixins.botania;

import ink.ikx.rt.Main;
import ink.ikx.rt.impl.mods.botania.cocoon.IMixinTileCocoon;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.block.BlockCocoon;

import javax.annotation.Nullable;

@Pseudo
@Mixin(value = BlockCocoon.class, remap = false)
public abstract class MixinBlockCocoon {

    @Inject(method = "onBlockActivated", at = @At(value = "HEAD"), cancellable = true, remap = true)
    private void injectOnBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing s, float xs, float ys, float zs, CallbackInfoReturnable<Boolean> cir) {
        logic(world, pos, player.getHeldItem(hand), player.capabilities.isCreativeMode, player, cir);
    }

    @Inject(method = "addStack", at = @At(value = "HEAD"), cancellable = true)
    private void injectAddStack(World world, BlockPos pos, ItemStack stack, boolean creative, CallbackInfoReturnable<Boolean> cir) {
        logic(world, pos, stack, creative, null, cir);
    }

    private void logic(World world, BlockPos pos, ItemStack stack, boolean creative, @Nullable EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        Item item = stack.getItem();
        TileEntity cocoon = world.getTileEntity(pos);
        if (!(cocoon instanceof IMixinTileCocoon) || item == Items.EMERALD || item == Items.CHORUS_FRUIT) {
            return;
        }

        IMixinTileCocoon mixinCocoon = ((IMixinTileCocoon) cocoon);
        if (mixinCocoon.getMapSize() >= 16) {
            return;
        }

        boolean isStackInMap = Main.CUSTOM_COCOONS_SPAWN.values().stream().anyMatch(cocoonx -> cocoonx.match(stack));

        if (!world.isRemote && isStackInMap) {
            int amount = mixinCocoon.getAmount(world, pos, stack, player);

            if (amount >= 20) {
                cir.setReturnValue(false);
                return;
            }

            mixinCocoon.setAmount(world, pos, stack, player, amount + 1);

            if (!creative) {
                stack.shrink(1);
            }
        }
        cir.setReturnValue(true);
    }

}

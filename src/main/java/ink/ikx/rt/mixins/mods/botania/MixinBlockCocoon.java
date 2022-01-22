package ink.ikx.rt.mixins.mods.botania;

import ink.ikx.rt.Main;
import ink.ikx.rt.impl.mods.botania.IMixinTileCocoon;
import java.util.Objects;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.block.BlockCocoon;
import vazkii.botania.common.block.tile.TileCocoon;

@Pseudo
@Mixin(value = BlockCocoon.class, remap = false)
public abstract class MixinBlockCocoon {

    @Inject(method = "addStack", at = @At(value = "HEAD"), cancellable = true)
    private void injectAddStack(World world, BlockPos pos, ItemStack stack, boolean creative, CallbackInfoReturnable<Boolean> cir) {
        boolean isStackInSet = Main.CUSTOM_COCOONS_SPAWN.values().stream().anyMatch(cocoon -> cocoon.match(stack));
        TileCocoon cocoon = (TileCocoon) world.getTileEntity(pos);
        Item item = stack.getItem();

        if(item != Items.EMERALD && item != Items.CHORUS_FRUIT) {
            if (!world.isRemote && Objects.nonNull(cocoon) && !stack.isEmpty() && cocoon instanceof IMixinTileCocoon && isStackInSet) {
                IMixinTileCocoon mixinCocoon = ((IMixinTileCocoon) cocoon);

                int amount = mixinCocoon.getAmount(stack);
                if (amount >= 20) {
                    cir.setReturnValue(false);
                    return;
                }

                mixinCocoon.setAmount(stack, amount + 1);
                if (!creative) {
                    stack.shrink(1);
                }
            }

            cir.setReturnValue(true);
        }
    }

}

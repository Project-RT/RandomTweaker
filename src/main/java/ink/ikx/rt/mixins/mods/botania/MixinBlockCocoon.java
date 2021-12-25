package ink.ikx.rt.mixins.mods.botania;

import ink.ikx.rt.Main;
import ink.ikx.rt.impl.mods.botania.MCCocoon;
import java.util.Objects;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
        boolean isStackInSet = Main.CUSTOM_COCOONS_SPAWN.stream().anyMatch(cocoon -> cocoon.match(stack));
        TileCocoon cocoon = (TileCocoon) world.getTileEntity(pos);
        Item item = stack.getItem();

        if(item != Items.EMERALD && item != Items.CHORUS_FRUIT) {
            if (!world.isRemote && Objects.nonNull(cocoon) && !stack.isEmpty() && isStackInSet) {
                NBTTagCompound tileData = cocoon.getTileData();

                if (!tileData.hasKey("ItemGiven")) {
                    tileData.setTag("ItemGiven", new NBTTagCompound());
                }

                NBTTagCompound itemGiven = tileData.getCompoundTag("ItemGiven");
                String stackToString = MCCocoon.writeStackToString(stack);

                int amount = itemGiven.getInteger(stackToString);

                if(amount < 20) {
                    itemGiven.setInteger(stackToString, amount + 1);
                } else {
                    cir.setReturnValue(false);
                    return;
                }

                if (!creative) {
                    stack.shrink(1);
                }

            }
            cir.setReturnValue(true);
        }
    }

}

package ink.ikx.rt.impl.mods.botania.cocoon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public interface IMixinTileCocoon {

    int getMapSize();

    int getAmount(World world, BlockPos pos, ItemStack stack, @Nullable EntityPlayer player);

    void setAmount(World world, BlockPos pos, ItemStack stack, @Nullable EntityPlayer player, int amount);

}

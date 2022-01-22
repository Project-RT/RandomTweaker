package ink.ikx.rt.impl.mods.botania;

import net.minecraft.item.ItemStack;

public interface IMixinTileCocoon {

    int getAmount(ItemStack stack);

    void setAmount(ItemStack stack, int amount);
}

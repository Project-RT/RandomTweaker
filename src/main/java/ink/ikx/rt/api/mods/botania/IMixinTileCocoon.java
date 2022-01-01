package ink.ikx.rt.api.mods.botania;

import net.minecraft.item.ItemStack;

public interface IMixinTileCocoon {

    int getAmount(ItemStack stack);

    void setAmount(ItemStack stack, int amount);
}

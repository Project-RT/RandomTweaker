package ink.ikx.rt.impl.mods.contenttweaker.mana.bauble;

import ink.ikx.rt.api.mods.contenttweaker.mana.IManaBauble;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.MCManaItem;
import net.minecraft.item.ItemStack;

/**
 * @author superhelo
 */
public class MCManaBauble extends MCManaItem implements IManaBauble {

    public MCManaBauble(ItemStack stack) {
        super(stack);
    }

    @Override
    public String getBaubleType() {
        return ((MCManaBaubleContent) this.itemIn).getBaubleType(stack).toString();
    }

}

package ink.ikx.rt.impl.mods.botania.mana;

import ink.ikx.rt.api.mods.botania.mana.IManaBauble;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.ManaBaubleContent;
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
        return ((ManaBaubleContent) this.itemIn).getBaubleType(stack).toString();
    }
}

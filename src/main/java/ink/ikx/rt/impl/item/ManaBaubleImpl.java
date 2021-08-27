package ink.ikx.rt.impl.item;

import ink.ikx.rt.api.internal.item.ManaBauble;
import ink.ikx.rt.api.mods.cote.mana.bauble.ManaBaubleContent;
import net.minecraft.item.ItemStack;

/**
 * @author superhelo
 */
public class ManaBaubleImpl extends ManaItemImpl implements ManaBauble {

    private final ManaBaubleContent manaBauble;

    public ManaBaubleImpl(ItemStack stack) {
        super(stack);
        this.manaBauble = (ManaBaubleContent) stack.getItem();
    }

    @Override
    public String getBaubleType() {
        return this.manaBauble.getBaubleType(stack).toString();
    }
}

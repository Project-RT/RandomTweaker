package ink.ikx.rt.impl.item;

import ink.ikx.rt.api.instance.item.ManaBauble;
import ink.ikx.rt.api.mods.cote.item.ManaBaubleContent;
import ink.ikx.rt.api.mods.cote.item.ManaUsingContent;
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

    @Override
    public boolean getUseMana() {
        if (!this.getBaubleType().equals("RING") && !this.getBaubleType().equals("TRINKET")) {
            return ((ManaUsingContent) this.manaBauble).usesMana(stack);
        }
        return false;
    }
}

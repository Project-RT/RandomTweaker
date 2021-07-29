package ink.ikx.rt.impl.item;

import baubles.api.BaubleType;
import ink.ikx.rt.api.instance.item.ManaBauble;
import ink.ikx.rt.api.mods.cote.mana.ManaBaubleContent;
import ink.ikx.rt.api.mods.cote.mana.ManaUsingContent;
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
        if (this.manaBauble.getBaubleType(stack) != BaubleType.RING && this.manaBauble.getBaubleType(stack) != BaubleType.TRINKET) {
            return ((ManaUsingContent) manaBauble).usesMana(stack);
        }
        return false;
    }
}

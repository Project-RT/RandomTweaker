package ink.ikx.rt.impl.item;

import ink.ikx.rt.api.instance.item.ManaBauble;
import ink.ikx.rt.api.mods.cote.item.ManaBaubleContent;
import ink.ikx.rt.api.mods.cote.item.ManaBaubleContent.ManaUsingItem;
import net.minecraft.item.ItemStack;

public class ManaBaubleImpl extends ManaItemImpl implements ManaBauble {

    private final ManaBaubleContent manaBauble;

    public ManaBaubleImpl(ItemStack stack) {
        super(stack);
        this.manaBauble = (ManaBaubleContent) stack.getItem();
    }

    @Override
    public String getBaubleType() {
        return manaBauble.baubleType.toString();
    }

    @Override
    public boolean getUseMana() {
        if (!this.getBaubleType().equals("RING") && !this.getBaubleType().equals("TRINKET")) {
            return ((ManaUsingItem) manaBauble).usesMana(stack);
        }
        return false;
    }
}

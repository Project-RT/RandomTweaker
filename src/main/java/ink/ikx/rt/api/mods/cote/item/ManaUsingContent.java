package ink.ikx.rt.api.mods.cote.item;

import net.minecraft.item.ItemStack;
import vazkii.botania.api.mana.IManaUsingItem;
import youyihj.zenutils.api.annotation.ExpandContentTweakerEntry;

@ExpandContentTweakerEntry
public class ManaUsingContent extends ManaBaubleContent implements IManaUsingItem {

    public boolean useMana;

    public ManaUsingContent(ManaBaubleRepresentation manaBauble) {
        super(manaBauble);
        this.useMana = manaBauble.isUseMana();
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        if (this.getMana(stack) > 0) {
            return false;
        }
        return useMana;
    }
}

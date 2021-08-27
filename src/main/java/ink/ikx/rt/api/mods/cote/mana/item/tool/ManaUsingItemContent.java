package ink.ikx.rt.api.mods.cote.mana.item.tool;

import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.cote.mana.item.ManaItemContent;
import ink.ikx.rt.api.mods.cote.mana.item.ManaItemRepresentation;
import java.util.Objects;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.mana.IManaUsingItem;
import youyihj.zenutils.api.cotx.annotation.ExpandContentTweakerEntry;

@ExpandContentTweakerEntry
public class ManaUsingItemContent extends ManaItemContent implements IManaUsingItem {

    private final ManaUsingItemRepresentation manaUsingItem;

    public ManaUsingItemContent(ManaUsingItemRepresentation manaUsingItem) {
        super(manaUsingItem);
        this.manaUsingItem = manaUsingItem;
    }

    @Override
    @ExpandContentTweakerEntry.RepresentationGetter
    public ManaItemRepresentation getRepresentation() {
        return manaUsingItem;
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        if (this.getMana(stack) > 0) {
            return false;
        }
        return Objects.isNull(manaUsingItem.usesMana) || manaUsingItem.usesMana.handle(CraftTweakerMC.getIItemStack(stack));
    }
}

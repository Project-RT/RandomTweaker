package ink.ikx.rt.impl.mods.contenttweaker.mana.item.tool;

import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.tool.IManaUsingItemRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.MCManaItemContent;
import java.util.Objects;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.mana.IManaUsingItem;
import youyihj.zenutils.api.cotx.annotation.ExpandContentTweakerEntry;

@ExpandContentTweakerEntry
public class MCMCManaUsingItemContent extends MCManaItemContent implements IManaUsingItem {

    private final IManaUsingItemRepresentation manaUsingItem;

    public MCMCManaUsingItemContent(IManaUsingItemRepresentation manaUsingItem) {
        super(manaUsingItem);
        this.manaUsingItem = manaUsingItem;
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return Objects.isNull(manaUsingItem.usesMana) || manaUsingItem.usesMana.call(CraftTweakerMC.getIItemStack(stack));
    }

}

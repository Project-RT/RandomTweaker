package ink.ikx.rt.impl.mods.contenttweaker.mana.item.tool;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.tool.IManaUsingItemRepresentation;

public class MCManaUsingItemRepresentation extends IManaUsingItemRepresentation {

    public MCManaUsingItemRepresentation(String unlocalizedName, int maxMana) {
        super(unlocalizedName, maxMana);
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaUsingItemContent(this));
    }
}

package ink.ikx.rt.impl.mods.contenttweaker.mana.item;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;

public class MCManaItemRepresentation extends IManaItemRepresentation {

    public MCManaItemRepresentation(String unlocalizedName, int maxMana) {
        super(unlocalizedName, maxMana);
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaItemContent(this));
    }
}

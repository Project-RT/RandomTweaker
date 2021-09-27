package ink.ikx.rt.impl.mods.contenttweaker.mana.item;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;

public class MCManaItemRepresentation extends IManaItemRepresentation {

    public MCManaItemRepresentation(String unlocalizedName, int maxMana) {
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxMana(maxMana);
        this.setMaxStackSize(1);
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new MCManaItemContent(this));
    }

}

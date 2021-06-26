package ink.ikx.rt.api.mods.cote.manaItem;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author : superhelo
 */

@ZenClass("mods.randomtweaker.ManaBauble")
public class ManaBaubleRepresentation extends ManaItemRepresentation {

    public ManaBaubleRepresentation(String unlocalizedName, int maxMana) {
        super(unlocalizedName, maxMana);
    }

    @Override
    public String getTypeName() {
        return "ManaBauble";
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaBaubleContent(this));
    }
}

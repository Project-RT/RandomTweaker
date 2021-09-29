package ink.ikx.rt.api.mods.cote.mana.item.tool;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.cote.function.mana.IsUsesMana;
import ink.ikx.rt.api.mods.cote.mana.item.ManaItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author superhelo
 */
@ZenClass("mods.randomtweaker.cote.ManaUsingItem")
public class ManaUsingItemRepresentation extends ManaItemRepresentation {

    @ZenProperty
    public IsUsesMana usesMana;

    public ManaUsingItemRepresentation(String unlocalizedName, int maxMana) {
        super(unlocalizedName, maxMana);
    }

    @ZenMethod
    public IsUsesMana getUsesMana() {
        return usesMana;
    }

    @ZenMethod
    public void setUsesMana(IsUsesMana usesMana) {
        this.usesMana = usesMana;
    }

    @Override
    public String getTypeName() {
        return "ManaUsingItem";
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaUsingItemContent(this));
    }
}
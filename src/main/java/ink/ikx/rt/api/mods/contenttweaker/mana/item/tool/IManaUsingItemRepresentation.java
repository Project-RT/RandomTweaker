package ink.ikx.rt.api.mods.contenttweaker.mana.item.tool;

import ink.ikx.rt.api.mods.contenttweaker.function.mana.IisUsesMana;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author superhelo
 */
@ZenClass("mods.randomtweaker.cote.ManaUsingItem")
public abstract class IManaUsingItemRepresentation extends IManaItemRepresentation {

    @ZenProperty
    public IisUsesMana usesMana;

    @ZenMethod
    public IisUsesMana getUsesMana() {
        return usesMana;
    }

    @ZenMethod
    public void setUsesMana(IisUsesMana usesMana) {
        this.usesMana = usesMana;
    }

    @Override
    public String getTypeName() {
        return "ManaUsingItem";
    }

    @Override
    public abstract void register();
}
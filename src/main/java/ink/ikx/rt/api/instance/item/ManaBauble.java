package ink.ikx.rt.api.instance.item;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

/**
 * @author superhelo
 */
@ZenClass("mods.randomtweaker.item.IManaBauble")
public interface ManaBauble extends ManaItem {

    @ZenGetter("baubleType")
    String getBaubleType();

    @ZenGetter("isUseMana")
    boolean getUseMana();
}

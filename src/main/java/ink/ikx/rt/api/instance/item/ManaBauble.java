package ink.ikx.rt.api.instance.item;

import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

/**
 * @author superhelo
 */
@RTRegisterClass({"zenutils", "botania"})
@ZenClass("mods.randomtweaker.item.IManaBauble")
public interface ManaBauble extends ManaItem {

    @ZenGetter("baubleType")
    String getBaubleType();

    @ZenGetter("isUseMana")
    boolean getUseMana();
}

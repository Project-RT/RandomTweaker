package ink.ikx.rt.api.internal.item;

import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.item.IManaBauble")
public interface ManaBauble extends ManaItem {

    @ZenGetter("baubleType")
    String getBaubleType();

}

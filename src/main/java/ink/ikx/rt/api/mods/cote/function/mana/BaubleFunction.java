package ink.ikx.rt.api.mods.cote.function.mana;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.BaubleFunction")
@FunctionalInterface
public interface BaubleFunction {

    void handle(IItemStack bauble, IEntityLivingBase wearer);

}

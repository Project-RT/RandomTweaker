package ink.ikx.rt.api.mods.contenttweaker.mana;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
@RTRegister
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.item.IManaBauble")
public interface IManaBauble extends IManaItem {

    @ZenGetter("baubleType")
    String getBaubleType();

    @ZenMethod
    boolean canEquip(IItemStack baubleItem, IEntityLivingBase wearer);

    @ZenMethod
    boolean canUnEquip(IItemStack baubleItem, IEntityLivingBase wearer);

}

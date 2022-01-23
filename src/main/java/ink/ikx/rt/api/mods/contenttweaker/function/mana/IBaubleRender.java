package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@RTRegister
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.PlayerBaubleRender")
@FunctionalInterface
public interface IBaubleRender {

    void call(IItemStack stack, IPlayer player, String renderType, float partialTicks);

}

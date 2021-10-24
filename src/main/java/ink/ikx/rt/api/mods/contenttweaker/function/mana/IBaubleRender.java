package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.PlayerBaubleRender")
@FunctionalInterface
public interface IBaubleRender {

    void call(IItemStack stack, IPlayer player, String renderType, float partialTicks);

}

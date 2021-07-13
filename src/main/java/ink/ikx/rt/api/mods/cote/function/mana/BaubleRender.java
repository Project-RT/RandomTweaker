package ink.ikx.rt.api.mods.cote.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.PlayerBaubleRender")
@FunctionalInterface
public interface BaubleRender {

    void onPlayerBaubleRender(IItemStack stack, IPlayer player, String renderType, float partialTicks);

}

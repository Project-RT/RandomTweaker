package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@ZenClass("mods.randomtweaker.cote.PlayerBaubleRender")
@FunctionalInterface
public interface BaubleRender {

    void onPlayerBaubleRender(IItemStack stack, IPlayer player, String renderType, float partialTicks);

}

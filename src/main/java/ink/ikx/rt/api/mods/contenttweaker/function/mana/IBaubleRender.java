package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import youyihj.zenutils.api.zenscript.SidedZenRegister;

import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */

@SidedZenRegister(modDeps = {"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.PlayerBaubleRender")
@FunctionalInterface
public interface IBaubleRender {

    void call(IItemStack stack, IPlayer player, String renderType, float partialTicks);

}

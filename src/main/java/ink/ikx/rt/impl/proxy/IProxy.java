package ink.ikx.rt.impl.proxy;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleRender;

/**
 * @author superhelo
 */
public interface IProxy {

    void onPlayerBaubleRender(BaubleRender render, IItemStack stack, IPlayer player, String renderType, float partialTicks);

    void rotateIfSneaking(IPlayer player);

    void translateToHeadLevel(IPlayer player);

    void translateToFace();

    void defaultTransforms();

    void translateToChest();

    void renderItem(IItemStack renderStack, String transformType);

    void bindTexture(String resourceLocation);

    void scale(double x, double y, double z);

    void rotate(float angle, float x, float y, float z);

    void translate(double x, double y, double z);
}

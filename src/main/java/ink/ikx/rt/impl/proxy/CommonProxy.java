package ink.ikx.rt.impl.proxy;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.api.mods.cote.function.BaubleRender;

public interface CommonProxy {

    void onPlayerBaubleRender(BaubleRender render, IItemStack stack, IPlayer player, String renderType, float partialTicks);

    void rotateIfSneaking(IPlayer player);

    void applySneakingRotation();

    void translateToHeadLevel(IPlayer player);

    void translateToFace();

    void defaultTransforms();

    void translateToChest();

    void renderItem(IItemStack renderStack, String transformType);

    void bindTexture();

    void scale(double x, double y, double z);

    void rotate(float angle, float x, float y, float z);

    void translate(double x, double y, double z);
}

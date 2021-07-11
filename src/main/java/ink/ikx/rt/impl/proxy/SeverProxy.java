package ink.ikx.rt.impl.proxy;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.api.mods.cote.function.BaubleRender;

/**
 * @author superhelo
 */
public class SeverProxy implements IProxy {

    @Override
    public void scale(double x, double y, double z) { }

    @Override
    public void rotate(float angle, float x, float y, float z) { }

    @Override
    public void translate(double x, double y, double z) { }

    @Override
    public void bindTexture(String resourceLocation) { }

    @Override
    public void renderItem(IItemStack renderStack, String transformType) { }

    @Override
    public void onPlayerBaubleRender(BaubleRender render, IItemStack stack, IPlayer player, String renderType, float partialTicks) { }

    @Override
    public void rotateIfSneaking(IPlayer player) { }

    @Override
    public void translateToFace() { }

    @Override
    public void translateToHeadLevel(IPlayer player) { }

    @Override
    public void defaultTransforms() { }

    @Override
    public void translateToChest() { }
}

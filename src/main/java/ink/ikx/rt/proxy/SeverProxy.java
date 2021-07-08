package ink.ikx.rt.proxy;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.api.mods.cote.function.BaubleRender;

public class SeverProxy implements CommonProxy {

    private void throwException() {
        throw new IllegalStateException("This is only run in clent");
    }

    @Override
    public void scale(double x, double y, double z) {
        throwException();
    }

    @Override
    public void rotate(float angle, float x, float y, float z) {
        throwException();
    }

    @Override
    public void translate(double x, double y, double z) {
        throwException();
    }

    @Override
    public void bindTexture() {
        throwException();
    }

    @Override
    public void renderItem(IItemStack renderStack, String transformType) {
        throwException();
    }

    @Override
    public void onPlayerBaubleRender(BaubleRender render, IItemStack stack, IPlayer player, String renderType, float partialTicks) {
        throwException();
    }

    @Override
    public void rotateIfSneaking(IPlayer player) {
        throwException();
    }

    @Override
    public void applySneakingRotation() {
        throwException();
    }

    @Override
    public void translateToFace() {
        throwException();
    }

    @Override
    public void translateToHeadLevel(IPlayer player) {
        throwException();
    }

    @Override
    public void defaultTransforms() {
        throwException();
    }

    @Override
    public void translateToChest() {
        throwException();
    }
}

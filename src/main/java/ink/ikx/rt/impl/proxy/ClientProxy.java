package ink.ikx.rt.impl.proxy;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.util.ResourceLocation;
import vazkii.botania.api.item.IBaubleRender.Helper;

/**
 * @author superhelo
 */
public class ClientProxy implements IProxy {

    @Override
    public void onPlayerBaubleRender(BaubleRender render, IItemStack stack, IPlayer player, String renderType, float partialTicks) {
        render.onPlayerBaubleRender(stack, player, renderType, partialTicks);
    }

    @Override
    public void rotateIfSneaking(IPlayer player) {
        Helper.rotateIfSneaking(CraftTweakerMC.getPlayer(player));
    }

    @Override
    public void translateToHeadLevel(IPlayer player) {
        Helper.translateToHeadLevel(CraftTweakerMC.getPlayer(player));
    }

    @Override
    public void translateToFace() {
        Helper.translateToFace();
    }

    @Override
    public void defaultTransforms() {
        Helper.defaultTransforms();
    }

    @Override
    public void renderItem(IItemStack renderStack, String transformType) {
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getRenderItem().renderItem(CraftTweakerMC.getItemStack(renderStack), ItemCameraTransforms.TransformType.valueOf(transformType));
        GlStateManager.popMatrix();
    }

    @Override
    public void translateToChest() {
        Helper.translateToChest();
    }

    @Override
    public void bindTexture(String resourceLocation) {
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(resourceLocation));
    }

    @Override
    public void scale(double x, double y, double z) {
        GlStateManager.scale(x, y, z);
    }

    @Override
    public void rotate(float angle, float x, float y, float z) {
        GlStateManager.rotate(angle, x, y, z);
    }

    @Override
    public void translate(double x, double y, double z) {
        GlStateManager.translate(x, y, z);
    }
}

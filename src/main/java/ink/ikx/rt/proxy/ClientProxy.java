package ink.ikx.rt.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;

public class ClientProxy extends CommonProxy {

    @Override
    public void renderTrinket(ItemStack renderStack, double[] toScale, float[] toTranslate) {
        GlStateManager.scale(toScale[0], toScale[1], toScale[2]);
        GlStateManager.translate(toTranslate[0], toTranslate[1], toTranslate[2]);
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getRenderItem().renderItem(renderStack, ItemCameraTransforms.TransformType.NONE);
        GlStateManager.popMatrix();
    }
}

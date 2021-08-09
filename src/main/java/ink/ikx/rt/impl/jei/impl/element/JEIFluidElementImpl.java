package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.mods.jei.interfaces.element.JEIFluidElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class JEIFluidElementImpl extends JEIElementImpl implements JEIFluidElement {

    public JEIFluidElementImpl(int x, int y, int width, int heigh) {
        super(x, y, width, heigh);
    }

    @Override
    public int getU() {
        return 0;
    }

    @Override
    public int getV() {
        return 0;
    }

    @Override
    public void Render(Minecraft minecraft) {
        if (this.getWidth() == 16 && this.getHeight() == 16) {
            this.Render(minecraft, 18, 0);
        } else if (this.getWidth() == 34 && this.getHeight() == 16) {
            this.Render(minecraft, 0, 18);
        } else if (this.getWidth() == 16 && this.getHeight() == 34) {
            this.Render(minecraft, 0, 36);
        }
    }

    private void Render(Minecraft minecraft, int u, int v) {
        GlStateManager.enableAlpha();
        minecraft.getTextureManager()
            .bindTexture(new ResourceLocation(this.getTexture()));
        Gui.drawModalRectWithCustomSizedTexture(this.getX() - 1, this.getY() - 1,
            u, v, this.getWidth() + 2, this.getHeight() + 2, 256, 256);
        GlStateManager.disableAlpha();
    }
}

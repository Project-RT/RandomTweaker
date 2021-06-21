package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.instance.jei.interfaces.element.JEICustomElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class JEICustomElementImpl extends JEIElementImpl implements JEICustomElement {

    public int u;
    public int v;
    public String texture;

    public JEICustomElementImpl(int x, int y, int width, int heigh, int u, int v, String texture) {
        super(x, y, width, heigh);
        this.u = u;
        this.v = v;
    }

    @Override
    public int getU() {
        return this.u;
    }

    @Override
    public int getV() {
        return this.v;
    }

    @Override
    public String getTexture() {
        return this.texture;
    }

    @Override
    public void Render(Minecraft minecraft) {
        GlStateManager.enableAlpha();
        minecraft.getTextureManager().bindTexture(new ResourceLocation(this.getTexture()));
        Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(), this.getU(), this.getV(), this.getWidth(), this.getHeigh(), 256, 256);
        GlStateManager.disableAlpha();
    }
}

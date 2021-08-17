package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.mods.jei.interfaces.element.JEIItemElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class JEIItemInputElementImpl extends JEIElementImpl implements JEIItemElement {

    public final int u = 0;
    public final int v = 0;

    public JEIItemInputElementImpl(int x, int y) {
        super(x, y, 18, 18);
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
    public void Render(Minecraft minecraft) {
        GlStateManager.enableAlpha();
        minecraft.getTextureManager()
            .bindTexture(new ResourceLocation(this.getTexture()));
        Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(),
            this.getU(), this.getV(), this.getWidth(), this.getHeight(), 256, 256);
        GlStateManager.disableAlpha();
    }
}

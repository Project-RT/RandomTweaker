package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.instance.jei.interfaces.element.JEIItemElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class JEIItemOutputElementImpl extends JEIElementImpl implements JEIItemElement {

    public final int U = 80;
    public final int V = 0;

    public JEIItemOutputElementImpl(int x, int y) {
        super(x, y, 26, 26);
    }

    @Override
    public int getU() {
        return this.U;
    }

    @Override
    public int getV() {
        return this.V;
    }

    @Override
    public void Render(Minecraft minecraft) {
        GlStateManager.enableAlpha();
        minecraft.getTextureManager()
            .bindTexture(new ResourceLocation(this.getTexture()));
        Gui.drawModalRectWithCustomSizedTexture(this.getX() - 4, this.getY() - 4,
            this.getU(), this.getV(), this.getWidth(), this.getHeigh(), 255, 255);
        GlStateManager.disableAlpha();
    }
}

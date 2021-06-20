package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.instance.jei.interfaces.element.JEIFontInfoElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class JEIFontInfoElementImpl extends JEIElementImpl implements JEIFontInfoElement {

    public String info;
    public int color;

    public JEIFontInfoElementImpl(int x, int y, String info, int color) {
        super(x, y, 0, 0);
        this.color = color;
        this.info = info;
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
    public String getInfo() {
        return this.info;
    }

    @Override
    public int getColor() {
        return this.color;
    }

    @Override
    public void Render(Minecraft minecraft) {
        FontRenderer fontRenderer = minecraft.fontRenderer;
        fontRenderer.drawString(this.info, this.x, this.y, this.color);
    }
}

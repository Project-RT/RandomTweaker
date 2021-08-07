package ink.ikx.rt.impl.jei.impl.element;

import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIArrowElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class JEIArrowElementImpl extends JEIElementImpl implements JEIArrowElement {

    public int direction;

    public JEIArrowElementImpl(int x, int y, int direction) {
        super(x, y, 0, 0);
        this.direction = direction;
    }

    @Override
    public int getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
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
        Render(minecraft, direction);
    }

    private void Render(Minecraft minecraft, int direction) {
        GlStateManager.enableAlpha();
        minecraft.getTextureManager()
            .bindTexture(new ResourceLocation(this.getTexture()));
        switch (direction) {
            case 0:
                Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(), 36, 0, 22, 15, 256, 256);
                break;
            case 1:
                Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(), 36, 16, 22, 15, 256, 256);
                break;
            case 2:
                Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(), 64, 0, 15, 22, 256, 256);
                break;
            case 3:
                Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(), 64, 32, 15, 22, 256, 256);
                break;
            default:
                CraftTweakerAPI.getLogger().logError("Direction is not supported and you shouldn't goto in here");
                break;
        }
        GlStateManager.disableAlpha();
    }
}

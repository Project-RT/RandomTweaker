package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.mods.jei.interfaces.element.JEIManaBarElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import vazkii.botania.client.core.handler.HUDHandler;
import vazkii.botania.common.block.tile.mana.TilePool;

public class JEIManaBarElementImpl extends JEIElementImpl implements JEIManaBarElement {

    public int mana;
    public int manaMax = TilePool.MAX_MANA_DILLUTED;
    public int multiplesLog = 0;
    private final int COLOR = 0x0000FF;

    public JEIManaBarElementImpl(int x, int y, int mana) {
        super(x, y, 0, 0);
        this.mana = mana;
        for (; mana > manaMax; manaMax *= 10)
            multiplesLog += 1;
        for (; (manaMax / mana > 50); manaMax /= 10)
            multiplesLog -= 1;
    }

    @Override
    public void Render(Minecraft minecraft) {
        GlStateManager.enableAlpha();
        HUDHandler.renderManaBar(x, y, COLOR, 0.75F, mana, manaMax);
        String sign = "x";
        if (multiplesLog < 0)
            sign = "/";
        if (multiplesLog != 0)
            minecraft.fontRenderer.drawString(sign + Math.pow(10, Math.abs(multiplesLog)), x + 103, y - 2, 0x8B8B8B);
        GlStateManager.disableAlpha();
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getMultiplesLog() {
        return multiplesLog;
    }

}

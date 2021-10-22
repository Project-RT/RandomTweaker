package ink.ikx.rt.api.mods.jei.slots;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IJeiSlotRenderable {
    @SideOnly(Side.CLIENT)
    public abstract void render(Minecraft minecraft);
}

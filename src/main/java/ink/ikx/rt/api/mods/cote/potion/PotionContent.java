package ink.ikx.rt.api.mods.cote.potion;

import com.teamacronymcoders.contenttweaker.ContentTweaker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PotionContent extends Potion {

    public final PotionRepresentation potionRepresentation;
    public final ResourceLocation textureResourceLocation;

    protected PotionContent(PotionRepresentation potionRepresentation) {
        super(potionRepresentation.isBadEffectIn, potionRepresentation.liquidColorIn);
        this.potionRepresentation = potionRepresentation;
        this.textureResourceLocation = new ResourceLocation(
            "contenttweaker:textures/gui/" + potionRepresentation.getName() + ".png");
        this.setPotionName(
            "effect." + ContentTweaker.MOD_ID + "." + potionRepresentation.name);
        this.setRegistryName(ContentTweaker.MOD_ID, potionRepresentation.name);
    }

    @Override
    public boolean hasStatusIcon() {
        return false;
    }

    /**
     * @return true if the potion has an instant effect instead of a continuous one (eg Harming)
     */
    @Override
    public boolean isInstant() {
        return potionRepresentation.isInstant();
    }

    @Override
    public boolean isBadEffect() {
        return potionRepresentation.isBadEffectIn();
    }

    @Override
    public boolean shouldRender(PotionEffect effect) {
        return potionRepresentation.isShouldRender();
    }

    @Override
    public boolean shouldRenderHUD(PotionEffect effect) {
        return potionRepresentation.isShouldRenderHUD();
    }

    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
        mc.getTextureManager().bindTexture(textureResourceLocation);
        Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
    }

    @Override
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
        mc.getTextureManager().bindTexture(textureResourceLocation);
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
    }
}

package ink.ikx.rt.api.mods.cote.potion;

import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.EntityHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.Objects;

@SuppressWarnings("NullableProblems")
public class PotionContent extends Potion {

    public final PotionRepresentation potionRepresentation;
    public final ResourceLocation textureResourceLocation;

    protected PotionContent(PotionRepresentation potionRepresentation) {
        super(potionRepresentation.isBadEffectIn(), potionRepresentation.getLiquidColorIn());
        this.potionRepresentation = potionRepresentation;
        this.textureResourceLocation = new ResourceLocation("contenttweaker:textures/gui/" + potionRepresentation.getName() + ".png");
        this.setPotionName("effect." + ContentTweaker.MOD_ID + "." + potionRepresentation.unlocalizedName);
        this.setRegistryName(ContentTweaker.MOD_ID, potionRepresentation.unlocalizedName);
    }

    @Override
    public boolean hasStatusIcon() {
        return false;
    }

    @Override
    public boolean isInstant() {
        return potionRepresentation.isInstant();
    }

    @Override
    public boolean isBeneficial() {
        return potionRepresentation.isBeneficial();
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

    public PotionRepresentation getRepresentation() {
        return potionRepresentation;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        if (Objects.nonNull(potionRepresentation.isReady)) {
            return potionRepresentation.isReady.call(duration, amplifier);
        } else {
            return Objects.nonNull(potionRepresentation.performEffect);
        }
    }

    @Override
    public void performEffect(EntityLivingBase living, int amplifier) {
        if (Objects.nonNull(potionRepresentation.performEffect)) {
            potionRepresentation.performEffect.call(EntityHelper.getIEntityLivingBase(living), amplifier);
        }
    }

    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, EntityLivingBase living, int amplifier, double health) {
        if (Objects.nonNull(potionRepresentation.affectEntity)) {
            potionRepresentation.affectEntity.call(EntityHelper.getIEntityLivingBase(living), amplifier);
        }
    }
}

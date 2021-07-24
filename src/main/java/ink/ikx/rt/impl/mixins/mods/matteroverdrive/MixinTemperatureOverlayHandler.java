package ink.ikx.rt.impl.mixins.mods.matteroverdrive;

import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.matteroverdrive.IMatterOverdriveAndroid;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toughasnails.handler.temperature.TemperatureOverlayHandler;

/**
 * @author skyraah
 */
@Pseudo
@Mixin(value = TemperatureOverlayHandler.class, remap = false)
public class MixinTemperatureOverlayHandler {

    @Inject(method = "onPostRenderOverlay", at = @At(value = "HEAD"), cancellable = true)
    public void injectOnPreRenderOverlay(RenderGameOverlayEvent.Post event, CallbackInfo ci) {
        if (IMatterOverdriveAndroid.isPlayerAndroid(Minecraft.getMinecraft().player)) {
            if (RTConfig.ToughAsNails.AndroidTemperature && !RTConfig.ToughAsNails.SelectedStatsTemperature) {
                ci.cancel();
            } else if (RTConfig.ToughAsNails.SelectedStatsTemperature && !RTConfig.ToughAsNails.AndroidTemperature) {
                if (IMatterOverdriveAndroid.isUnlocked(Minecraft.getMinecraft().player, RTConfig.ToughAsNails.SelectedStatTemperature, 1)) {
                    ci.cancel();
                }
            }
        }
    }
}


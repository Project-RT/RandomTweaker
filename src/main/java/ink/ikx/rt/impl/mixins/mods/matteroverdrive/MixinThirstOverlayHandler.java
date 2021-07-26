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
import toughasnails.handler.thirst.ThirstOverlayHandler;

/**
 * @author skyraah
 */
@Pseudo
@Mixin(value = ThirstOverlayHandler.class, remap = false)
public class  MixinThirstOverlayHandler {

    @Inject(method = "onPreRenderOverlay", at = @At(value = "HEAD"), cancellable = true)
    public void injectOnPreRenderOverlay(RenderGameOverlayEvent.Pre event, CallbackInfo ci) {
        if (IMatterOverdriveAndroid.isPlayerAndroid(Minecraft.getMinecraft().player)) {
            if (RTConfig.ToughAsNails.AndroidThirst && !RTConfig.ToughAsNails.SelectedStatsThirst) {
                ci.cancel();
            } else if (RTConfig.ToughAsNails.SelectedStatsThirst && !RTConfig.ToughAsNails.AndroidThirst) {
                if (IMatterOverdriveAndroid.isUnlocked(Minecraft.getMinecraft().player, RTConfig.ToughAsNails.SelectedStatThirst, 1)) {
                    ci.cancel();
                }
            }
        }
    }
}

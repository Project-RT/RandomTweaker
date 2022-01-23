package ink.ikx.rt.mixins.mods.ftbultimine;

import com.feed_the_beast.mods.ftbultimine.client.FTBUltimineClient;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler.FTBUltimineTag;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = FTBUltimineClient.class, remap = false)
public class MixinFTBUltimineClient {

    @Inject(method = "info", at = @At("HEAD"), cancellable = true)
    public void injectInfo(RenderGameOverlayEvent.Text event, CallbackInfo ci) {
        InternalUtils.decouplingMethod(ci);
    }

    @Inject(method = "renderGameOverlay", at = @At("HEAD"), cancellable = true)
    public void injectRenderGameOverlay(RenderGameOverlayEvent.Post list, CallbackInfo ci) {
        InternalUtils.decouplingMethod(ci);
    }

}

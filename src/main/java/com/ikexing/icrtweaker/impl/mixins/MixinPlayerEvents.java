package com.ikexing.icrtweaker.impl.mixins;

import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import thaumcraft.common.lib.events.PlayerEvents;

@Mixin(value = PlayerEvents.class, remap = false)
public class MixinPlayerEvents {
    @Inject(method = "wakeUp", at = @At(value = "HEAD", target = "Lthaumcraft/common/lib/events/PlayerEvents;wakeUp(Lnet/minecraftforge/event/entity/player/PlayerWakeUpEvent;)V"), cancellable = true)
    private static void MixinWakeUp(PlayerWakeUpEvent event, CallbackInfo ci){
        ci.cancel();
    }
}

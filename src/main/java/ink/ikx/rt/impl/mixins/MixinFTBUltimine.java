package ink.ikx.rt.impl.mixins;

import com.feed_the_beast.mods.ftbultimine.FTBUltimine;
import ink.ikx.rt.impl.config.RTConfig;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(value = FTBUltimine.class, remap = false)
public class MixinFTBUltimine {

    @Inject(method = "blockBroken", at = @At(value = "HEAD", target = "Lcom/feed_the_beast/mods/ftbultimine/FTBUltimine;blockBroken(Lnet/minecraftforge/event/world/BlockEvent$BreakEvent;)V"), cancellable = true)
    public void injectBlockBroken(BreakEvent event, CallbackInfo ci) {
        if (!event.getPlayer().getTags().contains("allowFTBUltimine")
            && RTConfig.FTBUltimine.AllowCrTControl) {
            ci.cancel();
        }
    }

}

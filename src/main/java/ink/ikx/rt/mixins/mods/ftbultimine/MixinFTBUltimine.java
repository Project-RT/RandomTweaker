package ink.ikx.rt.mixins.mods.ftbultimine;

import com.feed_the_beast.mods.ftbultimine.FTBUltimine;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import net.minecraftforge.event.world.BlockEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(value = FTBUltimine.class, remap = false)
public abstract class MixinFTBUltimine {

    @Inject(method = "blockBroken", at = @At(value = "HEAD"), cancellable = true)
    public void injectBlockBroken(BlockEvent.BreakEvent event, CallbackInfo ci) {
        InternalUtils.decouplingMethod(ci);
    }

}

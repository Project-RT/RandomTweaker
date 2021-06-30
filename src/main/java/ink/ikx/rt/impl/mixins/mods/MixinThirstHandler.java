package ink.ikx.rt.impl.mixins.mods;

import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.matteroverdrive.IMatterOverdriveAndroid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toughasnails.thirst.ThirstHandler;

/**
 * @author skyraah
 */
@Pseudo
@Mixin(value = ThirstHandler.class, remap = false)
public class MixinThirstHandler {

    @Inject(method = "update", at = @At(value = "HEAD"), cancellable = true)
    public void injectUpdate(EntityPlayer player, World world, TickEvent.Phase phase, CallbackInfo ci) {
        if (IMatterOverdriveAndroid.isPlayerAndroid(player)) {
            if (RTConfig.ToughAsNails.AndroidThirst && !RTConfig.ToughAsNails.SelectedStatsThirst) {
                ci.cancel();
            } else if (RTConfig.ToughAsNails.SelectedStatsThirst && !RTConfig.ToughAsNails.AndroidThirst) {
                if (IMatterOverdriveAndroid.isUnlocked(player, RTConfig.ToughAsNails.SelectedStatThirst, 1)) {
                    ci.cancel();
                }
            }
        }
    }
}

package ink.ikx.rt.impl.mixins.mods.matteroverdrive;

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
import toughasnails.temperature.TemperatureHandler;

/**
 * @author skyraah
 */
@Pseudo
@Mixin(value = TemperatureHandler.class, remap = false)
public class MixinTemperatureHandler {

    @Inject(method = "update", at = @At(value = "HEAD"), cancellable = true)
    public void injectUpdate(EntityPlayer player, World world, TickEvent.Phase phase, CallbackInfo ci) {
        if (IMatterOverdriveAndroid.isPlayerAndroid(player)) {
            if (RTConfig.ToughAsNails.AndroidTemperature && !RTConfig.ToughAsNails.SelectedStatsTemperature) {
                ci.cancel();
            } else if (RTConfig.ToughAsNails.SelectedStatsTemperature && !RTConfig.ToughAsNails.AndroidTemperature) {
                if (IMatterOverdriveAndroid.isUnlocked(player, RTConfig.ToughAsNails.SelectedStatTemperature, 1)) {
                    ci.cancel();
                }
            }
        }
    }
}


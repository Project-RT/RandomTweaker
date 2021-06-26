package ink.ikx.rt.impl.mixins.mods;

import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.matteroverdrive.IMatterOverdriveAndroid;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

    @SideOnly(Side.CLIENT)
    @Inject(method = "update", at = @At(value = "HEAD", target = "Ltoughasnails/temperature/TemperatureHandler;update(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/world/World;Lnet/minecraftforge/fml/common/gameevent/TickEvent$Phase;)V"), cancellable = true)
    public void injectUpdate(EntityPlayer player, World world, TickEvent.Phase phase, CallbackInfo ci) {
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


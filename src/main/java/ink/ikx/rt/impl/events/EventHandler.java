package ink.ikx.rt.impl.events;

import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.impl.client.capability.PlayerSanityCapability;
import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.utils.cap.PlayerSanityHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (!event.getWorld().isRemote && entity instanceof EntityPlayer) {
            PlayerSanityCapability sanityCap = PlayerSanityHelper
                .getPlayerSanity((EntityPlayer) entity);
            if (sanityCap.getOriginalSanity() == 0) {
                if (RTConfig.RandomTweaker.OriginalSanity) {
                    double random = Math.random();
                    sanityCap.setOriginalSanity((int) (random >= 0.75 ? random * 100 : (random + (random / 2)) * 100));
                } else {
                    sanityCap.setOriginalSanity(100);
                }
            }
            PlayerSanityHelper.sync(entity);
        }
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(RandomTweaker.MODID)) {
            ConfigManager.sync(RandomTweaker.MODID, Config.Type.INSTANCE);
        }
    }
}

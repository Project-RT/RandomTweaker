package ink.ikx.rt.impl.internal.event;

import ink.ikx.rt.Main;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler.FTBUltimineTag;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler.FTBUltimineTagProvider;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Main.MODID)) {
            ConfigManager.sync(Main.MODID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer && InternalUtils.isOpenFtbultimineControl()) {
            FTBUltimineTagProvider provider = new FTBUltimineTagProvider();
            event.addCapability(new ResourceLocation(Main.MODID + ":ftb_ultimine_tag"), provider);
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        FTBUltimineTag original = event.getOriginal().getCapability(CapabilityRegistryHandler.FTB_ULTIMINE_CAPABILITY, null);
        FTBUltimineTag instance = event.getEntityPlayer().getCapability(CapabilityRegistryHandler.FTB_ULTIMINE_CAPABILITY, null);

        Objects.requireNonNull(instance).setAllow(Objects.requireNonNull(original).isAllow());
    }

}

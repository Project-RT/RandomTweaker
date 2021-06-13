package com.ikexing.randomtweaker.impl.capability;

import com.ikexing.randomtweaker.RandomTweaker;
import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = RandomTweaker.MODID)
public class PlayerSanityCapabilityHandler {

    @CapabilityInject(PlayerSanityCapability.class)
    public static Capability<PlayerSanityCapability> PlayerSanityCap;

    public static void register() {
        CapabilityManager.INSTANCE.register(PlayerSanityCapability.class,
            new IStorage<PlayerSanityCapability>() {

                @Override
                public NBTBase writeNBT(Capability<PlayerSanityCapability> capability,
                    PlayerSanityCapability instance, EnumFacing side) {
                    return instance.serializeNBT();
                }

                @Override
                public void readNBT(Capability<PlayerSanityCapability> capability,
                    PlayerSanityCapability instance, EnumFacing side, NBTBase nbt) {
                    instance.deserializeNBT((NBTTagCompound) nbt);
                }

            }, PlayerSanityCapability::new);
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            PlayerSanityCapabilityProvider provider = new PlayerSanityCapabilityProvider();
            event.addCapability(new ResourceLocation(RandomTweaker.MODID + ":sanity"), provider);
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        PlayerSanityCapability instance = event.getEntityPlayer()
            .getCapability(PlayerSanityCapabilityHandler.PlayerSanityCap, null);
        PlayerSanityCapability original = event.getOriginal()
            .getCapability(PlayerSanityCapabilityHandler.PlayerSanityCap, null);

        Objects.requireNonNull(instance).setSanity(Objects.requireNonNull(original).getSanity());
    }
}

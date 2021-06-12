package com.ikexing.randomtweaker.impl.events.client;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.impl.capability.PlayerSanityCapability;
import com.ikexing.randomtweaker.impl.config.RTConfig;
import com.ikexing.randomtweaker.impl.utils.cap.PlayerSanityHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid = RandomTweaker.MODID)
public class Render {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
        RandomTweaker.MODID + ":textures/gui/player_sanity.png");

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRenderGameOverlayPost(RenderGameOverlayEvent.Post event) {
        if (ElementType.ALL.equals(event.getType()) && RTConfig.PlayerSanity) {
            Minecraft mc = Minecraft.getMinecraft();
            Entity entity = mc.getRenderViewEntity();
            if (entity instanceof EntityPlayer) {
                PlayerSanityCapability sanityCap = PlayerSanityHelper
                    .getPlayerSanity((EntityPlayer) entity);
                float result = sanityCap.getSanity() / sanityCap.getOriginalSanity();

                ScaledResolution resolution = event.getResolution();
                int width = resolution.getScaledWidth(), height = resolution.getScaledHeight();

                GlStateManager.enableBlend();
                mc.getTextureManager().bindTexture(TEXTURE);

                mc.ingameGUI
                    .drawTexturedModalRect(width / 10, height / 10, 1, 17, 32, 32);

                if (result <= 0.25f || sanityCap.getSanity() == 0) {
                    mc.ingameGUI
                        .drawTexturedModalRect((float) (width / 8.4), (float) (height / 8.3), 1, 1,
                            16, 16);
                } else if (result <= 0.5f) {
                    mc.ingameGUI
                        .drawTexturedModalRect((float) (width / 8.4), (float) (height / 8.3), 17, 1,
                            16, 16);
                } else if (result <= 0.75f) {
                    mc.ingameGUI
                        .drawTexturedModalRect((float) (width / 8.4), (float) (height / 8.3), 33, 1,
                            16, 16);
                } else {
                    mc.ingameGUI
                        .drawTexturedModalRect((float) (width / 8.4), (float) (height / 8.3), 49, 1,
                            16, 16);
                }
            }
        }
    }

}

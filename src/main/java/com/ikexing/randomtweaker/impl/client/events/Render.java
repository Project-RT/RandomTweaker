package com.ikexing.randomtweaker.impl.client.events;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapability;
import com.ikexing.randomtweaker.impl.config.RTConfig;
import com.ikexing.randomtweaker.impl.utils.cap.PlayerSanityHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
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
        if (RTConfig.PlayerSanity) {
            Minecraft mc = Minecraft.getMinecraft();
            Entity entity = mc.getRenderViewEntity();
            if (entity instanceof EntityPlayer) {
                PlayerSanityCapability sanityCap = PlayerSanityHelper
                    .getPlayerSanity((EntityPlayer) entity);
                float result = sanityCap.getSanity() / sanityCap.getOriginalSanity();

                ScaledResolution resolution = event.getResolution();
                float width = getWidth(resolution.getScaledWidth()), height = getHeigh(
                    resolution.getScaledHeight());

                GlStateManager.enableBlend();
                mc.getTextureManager().bindTexture(TEXTURE);

                if (result <= 0.25f || sanityCap.getSanity() == 0) {
                    mc.ingameGUI
                        .drawTexturedModalRect(width, height, 0, 0,
                            32, 32);
                } else if (result <= 0.5f) {
                    mc.ingameGUI
                        .drawTexturedModalRect(width, height, 0, 32,
                            32, 32);
                } else if (result <= 0.75f) {
                    mc.ingameGUI
                        .drawTexturedModalRect(width, height, 0, 64,
                            32, 32);
                } else {
                    mc.ingameGUI
                        .drawTexturedModalRect(width, height, 0, 96,
                            32, 32);
                }
            }
        }
    }

    private static float getWidth(int width) {
        String widthC = RTConfig.SanityPos[0];
        if (widthC.contains("px")) {
            widthC = widthC.substring(0, widthC.length() - 2);
        }
        return width / Float.parseFloat(widthC);
    }

    private static float getHeigh(int heigh) {
        String heightC = RTConfig.SanityPos[1];

        if (heightC.contains("px")) {
            heightC = heightC.substring(0, heightC.length() - 2);
        }
        return heigh / Float.parseFloat(heightC);
    }
}

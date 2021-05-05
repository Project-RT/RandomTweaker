//package com.ikexing.icrtweaker.events;
//
//import com.ikexing.icrtweaker.ICRTweaker;
//import hellfirepvp.astralsorcery.common.data.research.PlayerProgress;
//import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
//import net.minecraft.client.Minecraft;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.Items;
//import net.minecraft.util.EnumHand;
//import net.minecraft.world.World;
//import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//@Mod.EventBusSubscriber(modid = ICRTweaker.MODID)
//public class eventHandler {
//
//    @SubscribeEvent
//    public static void onPlayerLeftClickBlockEvent(PlayerInteractEvent.RightClickItem event){
//        EntityPlayer player = event.getEntityPlayer();
//        World world = event.getEntityPlayer().getEntityWorld();
//
//        if(!world.isRemote && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.STICK){
//            System.out.println(Minecraft.getMinecraft().objectMouseOver.getBlockPos().getX());
//            System.out.println(Minecraft.getMinecraft().objectMouseOver.getBlockPos().getY());
//            System.out.println(Minecraft.getMinecraft().objectMouseOver.getBlockPos().getZ());
//        }
//    }
//
//}

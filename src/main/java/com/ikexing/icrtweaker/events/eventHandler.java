//package com.ikexing.icrtweaker.events;
//
//import com.ikexing.icrtweaker.ICRTweaker;
//import hellfirepvp.astralsorcery.common.data.research.PlayerProgress;
//import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.Items;
//import net.minecraft.util.EnumHand;
//import net.minecraft.world.World;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//@Mod.EventBusSubscriber(modid = ICRTweaker.MODID)
//public class eventHandler {
//
//    @SubscribeEvent
//    public static void onPlayerLeftClickBlockEvent(PlayerInteractEvent.LeftClickBlock event){
//        EntityPlayer player = event.getEntityPlayer();
//        World world = event.getEntityPlayer().getEntityWorld();
//
//        if(!world.isRemote && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.STICK){
//            PlayerProgress prog = ResearchManager.getProgress(player, event.getSide());
//
//            System.out.println(prog.getAttunedConstellation().getSimpleName() );
//            System.out.println(prog.getPerkLevel(player));
//        }
//    }
//}

package ink.ikx.rt.impl.events;

import baubles.api.BaublesApi;
import ink.ikx.rt.api.mods.cote.mana.bauble.ManaBaubleContent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;

public class ManaBaubleEvent {

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent evt) {
        if (!evt.getEntityLiving().world.isRemote
            && evt.getEntityLiving() instanceof EntityPlayer
            && !evt.getEntityLiving().world.getGameRules().getBoolean("keepInventory")
            && !((EntityPlayer) evt.getEntityLiving()).isSpectator()) {
            IItemHandler inv = BaublesApi.getBaublesHandler((EntityPlayer) evt.getEntityLiving());
            for (int i = 0; i < inv.getSlots(); i++) {
                ItemStack stack = inv.getStackInSlot(i);
                if (!stack.isEmpty() && stack.getItem() instanceof ManaBaubleContent) {
                    ((ManaBaubleContent) stack.getItem()).onUnequipped(stack, evt.getEntityLiving());
                }
            }
        }
    }

}

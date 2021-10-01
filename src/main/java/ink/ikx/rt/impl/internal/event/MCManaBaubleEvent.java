package ink.ikx.rt.impl.internal.event;

import baubles.api.BaublesApi;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.MCManaBaubleContent;
import java.util.Objects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;

public class MCManaBaubleEvent {

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent evt) {
        if (!evt.getEntityLiving().world.isRemote
            && evt.getEntityLiving() instanceof EntityPlayer
            && !evt.getEntityLiving().world.getGameRules().getBoolean("keepInventory")
            && !((EntityPlayer) evt.getEntityLiving()).isSpectator()) {
            IItemHandler inv = BaublesApi.getBaublesHandler((EntityPlayer) evt.getEntityLiving());
            for (int i = 0; i < inv.getSlots(); i++) {
                ItemStack stack = inv.getStackInSlot(i);
                if (!stack.isEmpty() && Objects.requireNonNull(stack.getItem().getRegistryName()).getNamespace().equals("contenttweaker")) {
                    ((MCManaBaubleContent) stack.getItem()).onUnequipped(stack, evt.getEntityLiving());
                }
            }
        }
    }

}

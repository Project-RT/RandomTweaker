package ink.ikx.rt.classTransforms.vanilla;

import com.google.common.collect.Multimap;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.vanilla.CTEventHandler;
import ink.ikx.rt.impl.vanilla.ItemAttributeModificationEvent;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

/**
 * @author youyihj
 */
@SuppressWarnings("unused")
public class ItemStackHook {
    public static void fireAttributeModificationEvent(ItemStack stack, EntityEquipmentSlot equipmentSlot, Multimap<String, AttributeModifier> multimap) {
        CTEventHandler.elAttributeModification.publish(new ItemAttributeModificationEvent(
                CraftTweakerMC.getIItemStack(stack),
                CraftTweakerMC.getIEntityEquipmentSlot(equipmentSlot),
                multimap
        ));
    }
}

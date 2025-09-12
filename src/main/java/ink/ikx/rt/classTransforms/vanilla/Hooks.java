package ink.ikx.rt.classTransforms.vanilla;

import com.google.common.collect.Multimap;
import ink.ikx.rt.api.vanilla.CTEventHandler;
import ink.ikx.rt.impl.internal.config.RTConfig;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author youyihj
 */
@SuppressWarnings("unused")
public class Hooks {
    public static void fireAttributeModificationEvent(ItemStack stack, EntityEquipmentSlot equipmentSlot, Multimap<String, AttributeModifier> multimap) {
        CTEventHandler.Holder.publishItemAttributeModificationEvent(stack, equipmentSlot, multimap);
    }

    public static boolean isInBreakableEnchantmentBlacklist(Item item) {
        return ArrayUtils.contains(RTConfig.RandomTweaker.breakableEnchantmentBlacklist, item.getRegistryName().toString());
    }
}

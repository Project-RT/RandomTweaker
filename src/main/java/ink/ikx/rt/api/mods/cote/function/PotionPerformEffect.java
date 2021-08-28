package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntityLivingBase;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.PotionPerformEffect")
public interface PotionPerformEffect {
    void call(IEntityLivingBase living, int amplifier);
}

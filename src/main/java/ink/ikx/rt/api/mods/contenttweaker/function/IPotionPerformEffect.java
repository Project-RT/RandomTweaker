package ink.ikx.rt.api.mods.contenttweaker.function;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntityLivingBase;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.IPotionPerformEffect")
public interface IPotionPerformEffect {

    void call(IEntityLivingBase living, int amplifier);

}

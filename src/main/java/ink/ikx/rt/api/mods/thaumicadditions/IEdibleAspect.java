package ink.ikx.rt.api.mods.thaumicadditions;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspect;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.contenttweaker.function.IPotionPerformEffect;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import org.zeith.thaumicadditions.api.EdibleAspect;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModTotal({"thaumadditions", "modtweaker"})
@ZenClass("mods.randomtweaker.thaumadditions.IEdibleAspect")
public abstract class IEdibleAspect {

    @ZenMethod
    public static void addEatCall(CTAspect aspect, EatFunction function) {
        EdibleAspect.addEatCall(aspect.getInternal(), (entityLiving, count) -> {
            function.apply(count);
            return true;
        });
    }

    @ZenMethod
    public static void addEatCall(CTAspect aspect, EatFunctionWithPlayer function) {
        EdibleAspect.addEatCall(aspect.getInternal(), (entityLiving, count) -> function.apply(CraftTweakerMC.getIEntityLivingBase(entityLiving), count));
    }

    @ZenMethod
    public static void removeEatCall(CTAspect aspect) {
        EdibleAspect.EAT_FUNCTIONS.entrySet().removeIf(entry -> entry.getKey().getTag().equals(aspect.getInternal().getTag()));
    }

    @RTRegister
    @ModTotal({"thaumadditions", "modtweaker"})
    @ZenClass("mods.randomtweaker.thaumadditions.EatFunction")
    @FunctionalInterface
    public interface EatFunction {

        IPotionPerformEffect apply(int count);

    }

    @RTRegister
    @ModTotal({"thaumadditions", "modtweaker"})
    @ZenClass("mods.randomtweaker.thaumadditions.EatFunction")
    @FunctionalInterface
    public interface EatFunctionWithPlayer {

        boolean apply(IEntityLivingBase entityLiving, int count);

    }

}

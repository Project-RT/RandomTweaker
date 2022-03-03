package ink.ikx.rt.api.mods.thaumicadditions;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.potions.IPotionEffect;
import ink.ikx.rt.api.mods.thaumcraft.IAspect;
import ink.ikx.rt.api.mods.thaumcraft.IAspectList;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import org.zeith.thaumicadditions.api.EdibleAspect;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModOnly("thaumadditions")
@ZenClass("mods.randomtweaker.thaumadditions.IEdibleAspect")
public abstract class IEdibleAspect {

    @ZenMethod
    public static void addEatCall(IAspect aspect, EatFunction function) {
        EdibleAspect.addEatCall(aspect.getInternal(), (entity, count) -> {
            entity.addPotionEffect(CraftTweakerMC.getPotionEffect(function.apply(count)));
            return true;
        });
    }

    @ZenMethod
    public static void addEatCall(IAspect aspect, EatFunctionWithEntity function) {
        EdibleAspect.addEatCall(aspect.getInternal(), (entity, count) -> function.apply(CraftTweakerMC.getIEntityLivingBase(entity), count));
    }

    @ZenMethod
    public static void removeEatCall(IAspect aspect) {
        EdibleAspect.EAT_FUNCTIONS.entrySet().removeIf(entry -> entry.getKey().getTag().equals(aspect.getInternal().getTag()));
    }

    @ZenMethod
    public static IItemStack applyToFoodStack(IItemStack stack, IAspectList aspects) {
        return CraftTweakerMC.getIItemStack(EdibleAspect.applyToFoodStack(CraftTweakerMC.getItemStack(stack), aspects.getInternal()));
    }

    @ZenMethod
    public static IAspectList getSalt(IItemStack stack) {
        return IAspectList.of(EdibleAspect.getSalt(CraftTweakerMC.getItemStack(stack)));
    }

    @RTRegister
    @ModOnly("thaumadditions")
    @ZenClass("mods.randomtweaker.thaumadditions.EatFunction")
    @FunctionalInterface
    public interface EatFunction {

        IPotionEffect apply(int count);

    }

    @RTRegister
    @ModOnly("thaumadditions")
    @ZenClass("mods.randomtweaker.thaumadditions.EatFunctionWithEntity")
    @FunctionalInterface
    public interface EatFunctionWithEntity {

        boolean apply(IEntityLivingBase entity, int count);

    }

}

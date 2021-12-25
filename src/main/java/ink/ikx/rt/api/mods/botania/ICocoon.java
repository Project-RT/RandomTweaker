package ink.ikx.rt.api.mods.botania;

import com.google.common.collect.Maps;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntityDefinition;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.Main;
import ink.ikx.rt.impl.mods.botania.MCCocoon;
import java.util.Map;
import java.util.Objects;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityEntry;
import stanhebben.zenscript.annotations.NotNull;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.ICocoon")
public abstract class ICocoon {

    public abstract ItemStack getStack();

    public abstract Map<EntityEntry, Double> getSpawnTab();

    public abstract double getProbablyByEntity(EntityEntry entity);

    public abstract boolean match(ItemStack stack);

    public abstract boolean match(String stack);

    @ZenMethod
    public static void registerSpawn(@NotNull IItemStack stack, @NotNull Map<IEntityDefinition, Double> spawnTab) {
        if(Objects.isNull(stack) || Objects.isNull(spawnTab)) {
            CraftTweakerAPI.logError("The argument cannot be null", new IllegalArgumentException());
            return;
        }

        Map<EntityEntry, Double> tab = Maps.newHashMap();
        spawnTab.forEach((entity, probably) -> {
            if(Objects.nonNull(entity)) {
                if(entity.getInternal() instanceof EntityEntry) {
                    tab.put((EntityEntry) entity.getInternal(), probably);
                } else {
                    CraftTweakerAPI.logError("The internal type of the entity is not EntityEntry!");
                }
            }
        });
        MCCocoon.create(CraftTweakerMC.getItemStack(stack), tab);
    }

    public static ICocoon getInstanceByString(String stack) {
        for(ICocoon cocoon : Main.CUSTOM_COCOONS_SPAWN) {
            if(cocoon.match(stack)) {
                return cocoon;
            }
        }
        return null;
    }

    public static ICocoon getInstanceByStack(ItemStack stack) {
        for(ICocoon cocoon : Main.CUSTOM_COCOONS_SPAWN) {
            if(cocoon.match(stack)) {
                return cocoon;
            }
        }
        return null;
    }

}

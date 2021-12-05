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
@ZenClass("mods.randomtweaker.botania.Cocoon")
public abstract class ICocoon {

    public abstract ItemStack getStack();

    public abstract Map<Float, EntityEntry> getSpawnTab();

    public abstract EntityEntry getEntityAt(float probability);

    public abstract boolean match(ItemStack stack);

    public abstract boolean match(String stack);

    @ZenMethod
    public static void registerSpawn(@NotNull IItemStack stack, @NotNull Map<Float, IEntityDefinition> spawnTab) {
        if(checkMap(spawnTab)) {
            Map<Float, EntityEntry> tab = Maps.newHashMap();
            spawnTab.forEach((key, value) -> tab.put(key, (EntityEntry) value.getInternal()));
            Main.CUSTOM_COCOONS_SPAWN.add(new MCCocoon(CraftTweakerMC.getItemStack(stack), tab));
        }
    }

    private static boolean checkMap(Map<Float, IEntityDefinition> spawnTab) {
        float sumResult = 0.0f;

        for(float probability : spawnTab.keySet()) {
            sumResult += probability;
            IEntityDefinition entity = spawnTab.get(probability);
            if(Objects.isNull(entity) || Objects.isNull(entity.getInternal()) || !(entity.getInternal() instanceof EntityEntry)) {
                CraftTweakerAPI.logError("entity cannot be null!", new IllegalArgumentException());
                return false;
            }
        }

        if(sumResult > 1.0f) {
            CraftTweakerAPI.logError("probability over 1", new IllegalArgumentException());
            return false;
        }

        return true;
    }

}

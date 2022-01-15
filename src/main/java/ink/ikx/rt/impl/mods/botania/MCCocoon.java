package ink.ikx.rt.impl.mods.botania;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.mods.botania.ICocoon;
import java.util.Map;
import java.util.Objects;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class MCCocoon extends ICocoon {

    private final String name;
    private final ItemStack giveStack;
    private final Map<EntityEntry, Double> spawnTab;

    private MCCocoon(String name, ItemStack giveStack, Map<EntityEntry, Double> spawnTab) {
        this.name = name;
        this.giveStack = giveStack;
        this.spawnTab = spawnTab;
    }

    public static MCCocoon create(String name, ItemStack giveStack, Map<EntityEntry, Double> spawnTab) {
        if (check(name, spawnTab)) {
            return new MCCocoon(name, giveStack, spawnTab);
        }
        return null;
    }

    private static boolean check(String name, Map<EntityEntry, Double> spawnTab) {
        double sumResult = 0.0f;

        if (Objects.isNull(name) || Main.CUSTOM_COCOONS_SPAWN.containsKey(name)) {
            CraftTweakerAPI.logWarning("The name cannot be null and must be unique!");
            return false;
        }

        if (Objects.isNull(spawnTab)) {
            CraftTweakerAPI.logError("SpawnTab cannot be null!", new IllegalArgumentException());
            return false;
        }

        for (EntityEntry entity : spawnTab.keySet()) {
            if (Objects.isNull(entity)) {
                CraftTweakerAPI.logError("The entity cannot be null!", new IllegalArgumentException());
                return false;
            }

            double probably = spawnTab.get(entity);

            if(probably <= 0.0f) {
                CraftTweakerAPI.logError("Probably less than 0!", new IllegalArgumentException());
                return false;
            }

            sumResult += probably;
        }

        if (sumResult > 1.0f) {
            CraftTweakerAPI.logError("Probably over 1!", new IllegalArgumentException());
            return false;
        }

        return true;
    }

    public ItemStack getStack() {
        return giveStack;
    }

    public Map<EntityEntry, Double> getSpawnTab() {
        return spawnTab;
    }

    @Override
    public double getProbablyByEntity(EntityEntry entity) {
        return spawnTab.get(entity);
    }

    public boolean match(ItemStack stack) {
        return CraftTweakerMC.getIItemStack(this.giveStack).matches(CraftTweakerMC.getIItemStack(stack));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICocoon that = (ICocoon) o;

        return this.match(that.getStack());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + giveStack.getItem().hashCode();
        hash = 41 * hash + giveStack.getItemDamage();
        hash = 41 * hash + (Objects.nonNull(giveStack.getTagCompound()) ? giveStack.getTagCompound().hashCode() : 0);

        return hash;
    }

}

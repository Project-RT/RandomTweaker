package ink.ikx.rt.impl.mods.botania.cocoon;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.mods.botania.ICocoon;
import ink.ikx.rt.api.mods.botania.function.ICocoonDynamic;
import ink.ikx.rt.api.mods.botania.function.ICocoonTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityEntry;

import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;

public class MCCocoon extends ICocoon {

    private final String name;
    private final ItemStack giveStack;
    private final Map<EntityEntry, Double> spawnTab;
    private ICocoonDynamic dynamicSpawn = (stack, player, context) -> this.getName();

    private MCCocoon(String name, ItemStack giveStack, Map<EntityEntry, Double> spawnTab) {
        this.name = name;
        this.spawnTab = spawnTab;
        this.giveStack = giveStack;
    }

    public static ICocoon create(@Nonnull String name, @Nonnull ItemStack giveStack, @Nonnull Map<EntityEntry, Double> spawnTab) {
        if (check(name, giveStack, spawnTab)) {
            return new MCCocoon(name, giveStack, spawnTab);
        }
        return null;
    }

    public static ICocoon create(@Nonnull String name, @Nonnull ItemStack giveStack, @Nonnull Map<EntityEntry, Double> spawnTab, ICocoonDynamic dynamicSpawn) {
        ICocoon cocoon = create(name, giveStack, spawnTab);

        if (Objects.nonNull(cocoon) && Objects.nonNull(dynamicSpawn)) {
            cocoon.setSpawnDynamic(dynamicSpawn);
        }

        return cocoon;
    }

    private static boolean check(String name, ItemStack stack, Map<EntityEntry, Double> spawnTab) {
        double sumResult = 0.0f;

        if (Main.CUSTOM_COCOONS_SPAWN.containsKey(name)) {
            CraftTweakerAPI.logWarning("The name repeated : " + name);
            return false;
        }

        if (stack.isEmpty()) {
            CraftTweakerAPI.logError("The stack cannot be empty");
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
    public ICocoonDynamic getSpawnDynamic() {
        return this.dynamicSpawn;
    }

    @Override
    public double getProbablyByEntity(EntityEntry entity) {
        return spawnTab.get(entity);
    }

    public boolean match(ItemStack stack) {
        return CraftTweakerMC.getIItemStack(this.giveStack).matches(CraftTweakerMC.getIItemStack(stack));
    }

    @Override
    public void setSpawnDynamic(ICocoonDynamic dynamicSpawn) {
        this.dynamicSpawn = dynamicSpawn;
    }

    @Override
    public String getSpawnDynamicResult(ItemStack stack, EntityPlayer player, ICocoonTileEntity tile) {
        return this.dynamicSpawn.call(
            CraftTweakerMC.getIItemStack(stack),
            CraftTweakerMC.getIPlayer(player),
            tile
        );
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
        boolean theSameAsMap = spawnTab.entrySet().stream().allMatch((entry) ->
            that.getSpawnTab().containsKey(entry.getKey()) && that.getProbablyByEntity(entry.getKey()) == entry.getValue());

        return this.match(that.getStack()) && theSameAsMap;
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

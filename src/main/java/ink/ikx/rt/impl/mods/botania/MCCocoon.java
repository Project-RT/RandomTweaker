package ink.ikx.rt.impl.mods.botania;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.mods.botania.ICocoon;
import java.util.Map;
import java.util.Objects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class MCCocoon extends ICocoon {

    private final ItemStack giveStack;
    private final Map<EntityEntry, Double> spawnTab;

    private MCCocoon(ItemStack giveStack, Map<EntityEntry, Double> spawnTab) {
        this.giveStack = giveStack;
        this.spawnTab = spawnTab;
    }

    public static MCCocoon create(ItemStack giveStack, Map<EntityEntry, Double> spawnTab) {
        if(check(spawnTab)) {
            MCCocoon cocoon = new MCCocoon(giveStack, spawnTab);
            Main.CUSTOM_COCOONS_SPAWN.add(cocoon);
            return cocoon;
        }

        return null;
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
    public boolean match(String stack) {
        String stackToString = writeStackToString(giveStack);
        return stackToString.equals(stack);
    }

    public static String writeStackToString(ItemStack stack) {
        NBTTagCompound nbt = new NBTTagCompound();
        ResourceLocation resourcelocation = Item.REGISTRY.getNameForObject(stack.getItem());

        nbt.setString("id", Objects.isNull(resourcelocation) ? "minecraft:air" : resourcelocation.toString());
        nbt.setShort("Damage", (short) stack.getItemDamage());

        if(Objects.nonNull(stack.getTagCompound())) {
            nbt.setTag("tag", stack.getTagCompound());
        }

        return nbt.toString();
    }

    private static boolean check(Map<EntityEntry, Double> spawnTab) {
        double sumResult = 0.0f;

        if(Objects.isNull(spawnTab)) {
            CraftTweakerAPI.logError("SpawnTab cannot be null!", new IllegalArgumentException());
            return false;
        }

        for(EntityEntry entity : spawnTab.keySet()) {
            if(Objects.isNull(entity)) {
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

        if(sumResult > 1.0f) {
            CraftTweakerAPI.logError("Probably over 1!", new IllegalArgumentException());
            return false;
        }

        return true;
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

package ink.ikx.rt.impl.mods.botania;

import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.botania.ICocoon;
import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class MCCocoon extends ICocoon {

    private final ItemStack giveStack;
    private final Map<Float, EntityEntry> spawnTab;

    public MCCocoon(ItemStack giveStack, Map<Float, EntityEntry> spawnTab) {
        this.giveStack = giveStack;
        this.spawnTab = spawnTab;
    }

    public ItemStack getStack() {
        return giveStack;
    }

    public Map<Float, EntityEntry> getSpawnTab() {
        return spawnTab;
    }

    public EntityEntry getEntityAt(float probability) {
        return spawnTab.get(probability);
    }

    public boolean match(ItemStack stack) {
        return CraftTweakerMC.getIItemStack(giveStack).matches(CraftTweakerMC.getIItemStack(stack));
    }

    @Override
    public boolean match(String stack) {
        String stackToString = getStackName(giveStack);
        return stackToString.equals(stack);
    }

    public static String getStackName(ItemStack stack) {
        NBTTagCompound stackToNBT = stack.writeToNBT(new NBTTagCompound());
        stackToNBT.removeTag("Count");
        stackToNBT.removeTag("ForgeCaps");
        return stackToNBT.toString();
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

        return giveStack.equals(that.getStack());
    }

    @Override
    public int hashCode() {
        return giveStack.hashCode();
    }

}

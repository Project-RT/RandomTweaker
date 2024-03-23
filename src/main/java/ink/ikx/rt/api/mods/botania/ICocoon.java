package ink.ikx.rt.api.mods.botania;

import com.google.common.collect.Maps;
import crafttweaker.CraftTweakerAPI;
import youyihj.zenutils.api.zenscript.SidedZenRegister;
import crafttweaker.api.entity.IEntityDefinition;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.mods.botania.function.DynamicSpawnTable;
import ink.ikx.rt.api.mods.botania.function.ICocoonTileEntity;
import ink.ikx.rt.impl.mods.botania.cocoon.MCCocoon;

import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityEntry;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;


@SidedZenRegister(modDeps = "botania")
@ZenClass("mods.randomtweaker.botania.ICocoon")
public abstract class ICocoon {

    @Nullable
    @ZenMethod
    public static ICocoon registerSpawn(@Nonnull String name, IItemStack stack, Map<IEntityDefinition, Double> spawnTab, @Optional DynamicSpawnTable dynamicSpawnTab) {
        ICocoon cocoon;
        if (!Main.CUSTOM_COCOONS_SPAWN.containsKey(name)) {
            Map<EntityEntry, Double> tab = Maps.newHashMap();
            spawnTab.forEach((entity, probably) -> {
                if (Objects.nonNull(entity)) {
                    if (entity.getInternal() instanceof EntityEntry) {
                        tab.put((EntityEntry) entity.getInternal(), probably);
                    } else {
                        CraftTweakerAPI.logError("The internal type of " + entity.getId() + " is not EntityEntry!");
                    }
                }
            });

            cocoon = MCCocoon.create(name, CraftTweakerMC.getItemStack(stack), tab, dynamicSpawnTab);

            if (Objects.isNull(cocoon)) {
                CraftTweakerAPI.logError("Registering " + name + " failed");
                return null;
            }
        } else {
            cocoon = getInstanceByName(name);

            if (Objects.nonNull(dynamicSpawnTab)) {
                cocoon.setDynamicSpawnTable(dynamicSpawnTab);
            }
        }

        Main.CUSTOM_COCOONS_SPAWN.put(name, cocoon);
        return cocoon;
    }

    @Nullable
    @ZenMethod
    public static ICocoon getInstanceByStack(IItemStack stack) {
        return getInstanceByStack(CraftTweakerMC.getItemStack(stack));
    }

    @ZenMethod
    public static ICocoon getInstanceByName(String name) {
        return Main.CUSTOM_COCOONS_SPAWN.get(name);
    }

    @Nullable
    public static ICocoon getInstanceByStack(ItemStack stack) {
        return Main.CUSTOM_COCOONS_SPAWN.values().stream().filter(cocoon -> cocoon.match(stack)).findFirst().orElse(null);
    }

    public abstract ItemStack getStack();

    public abstract boolean match(ItemStack stack);

    public abstract DynamicSpawnTable getDynamicSpawnTable();

    public abstract Map<EntityEntry, Double> getSpawnTab();

    public abstract void setDynamicSpawnTable(DynamicSpawnTable dynamicSpawn);

    public abstract double getProbablyByEntity(EntityEntry entity);

    public abstract String getDynamicResult(ItemStack stack, EntityPlayer player, ICocoonTileEntity tile);

    @ZenMethod
    @ZenGetter("name")
    public abstract String getName();

}

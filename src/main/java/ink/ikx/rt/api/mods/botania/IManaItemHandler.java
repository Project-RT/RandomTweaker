package ink.ikx.rt.api.mods.botania;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import vazkii.botania.api.mana.ManaItemHandler;

import java.util.HashMap;
import java.util.Map;

@RTRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.IManaItemHandler")
public abstract class IManaItemHandler {

    @ZenMethod
    public static IItemStack[] getManaItems(IPlayer player) {
        return CraftTweakerMC.getIItemStacks(ManaItemHandler.getManaItems(CraftTweakerMC.getPlayer(player)));
    }

    @ZenMethod
    public static Map<Integer, IItemStack> getManaBaubles(IPlayer player) {
        Map<Integer, IItemStack> toReturn = new HashMap<>();

        for (Map.Entry<Integer, ItemStack> entry : ManaItemHandler.getManaBaubles(CraftTweakerMC.getPlayer(player)).entrySet()) {
            toReturn.put(entry.getKey(), CraftTweakerMC.getIItemStack(entry.getValue()));
        }
        return toReturn;
    }

    @ZenMethod
    public static int requestMana(IItemStack stack, IPlayer player, int manaToGet, boolean remove) {
        return ManaItemHandler.requestMana(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getPlayer(player), manaToGet, remove);
    }

    @ZenMethod
    public static boolean requestManaExact(IItemStack stack, IPlayer player, int manaToGet, boolean remove) {
        return ManaItemHandler.requestManaExact(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getPlayer(player), manaToGet, remove);
    }

    @ZenMethod
    public static int requestManaForTool(IItemStack stack, IPlayer player, int manaToGet, boolean remove) {
        return ManaItemHandler.requestManaForTool(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getPlayer(player), manaToGet, remove);
    }

    @ZenMethod
    public static boolean requestManaExactForTool(IItemStack stack, IPlayer player, int manaToGet, boolean remove) {
        return ManaItemHandler.requestManaExactForTool(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getPlayer(player), manaToGet, remove);
    }

    @ZenMethod
    public static int dispatchMana(IItemStack stack, IPlayer player, int manaToSend, boolean add) {
        return ManaItemHandler.dispatchMana(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getPlayer(player), manaToSend, add);
    }

    @ZenMethod
    public static boolean dispatchManaExact(IItemStack stack, IPlayer player, int manaToSend, boolean add) {
        return ManaItemHandler.dispatchManaExact(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getPlayer(player), manaToSend, add);
    }

    @ZenMethod
    public static float getFullDiscountForTools(IPlayer player, IItemStack tool) {
        return ManaItemHandler.getFullDiscountForTools(CraftTweakerMC.getPlayer(player), CraftTweakerMC.getItemStack(tool));
    }

}

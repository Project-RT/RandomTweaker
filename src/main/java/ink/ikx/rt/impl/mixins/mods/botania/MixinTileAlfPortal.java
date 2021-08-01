package ink.ikx.rt.impl.mixins.mods.botania;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.events.AlfPortalDroppedEvent;
import ink.ikx.rt.impl.events.ElvenTradeEvent;
import ink.ikx.rt.impl.utils.IMixinTileAlfPortal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import vazkii.botania.api.recipe.ElvenPortalUpdateEvent;
import vazkii.botania.api.recipe.RecipeElvenTrade;
import vazkii.botania.api.state.enums.AlfPortalState;
import vazkii.botania.common.block.tile.TileAlfPortal;
import vazkii.botania.common.block.tile.TileMod;

@Pseudo
@Mixin(value = TileAlfPortal.class, remap = false)
public abstract class MixinTileAlfPortal extends TileMod implements IMixinTileAlfPortal {

    @Shadow
    @Final
    private List<ItemStack> stacksIn;

    private List<ItemStack> allInput = new ArrayList<>();

    private static <T> T[] getArray(List<T> t) {
        return (T[]) t.toArray();
    }

    @Shadow
    protected abstract void spawnItem(ItemStack stack);

    @Shadow
    public abstract boolean consumeMana(@Nullable List<BlockPos> pylons, int totalCost, boolean close);

    @Inject(method = "update", at = @At("HEAD"))
    private void injectUpdate(CallbackInfo ci) {
        if (!allInput.isEmpty())
            allInput.clear();
    }

    // why the fucking need all the variable to parameter ????????????
    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lvazkii/botania/common/block/tile/TileAlfPortal;validateItemUsage(Lnet/minecraft/item/ItemStack;)Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectUpdate_(CallbackInfo ci, IBlockState iBlockState, AlfPortalState state, AlfPortalState newState, AxisAlignedBB aabb, boolean open, ElvenPortalUpdateEvent event, List items, Iterator var8, EntityItem item, ItemStack stack, boolean consume) { // validateItemUsage
        boolean res = MinecraftForge.EVENT_BUS.post(new AlfPortalDroppedEvent(getWorld(), getPos(), stack));
        if (!res) {
            allInput.add(stack);
        }
    }

    @Inject(method = "resolveRecipes", at = @At(value = "INVOKE", target = "Lvazkii/botania/api/recipe/RecipeElvenTrade;matches(Ljava/util/List;Z)Z", shift = Shift.AFTER, ordinal = 1), locals = LocalCapture.PRINT, cancellable = true)
    private void injectResolveRecipes(CallbackInfo ci, int i, Iterator var2, RecipeElvenTrade recipe) {
        ElvenTradeEvent event = new ElvenTradeEvent(getWorld(), getPos(), getArray(stacksIn), getArray(recipe.getOutputs()));
        if (!MinecraftForge.EVENT_BUS.post(event)) {
            Arrays.stream(event.getOutput()).forEach(this::spawnItem);
        }
        ci.cancel();
    }

    @Override
    public IItemStack[] getAllInput() {
        return this.allInput.stream().map(CraftTweakerMC::getIItemStack).toArray(IItemStack[]::new);
    }

    @Override
    public void setAllInput(IItemStack[] newList) {
        this.allInput = Arrays.stream(newList).map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
    }

    @Override
    public void delAllInput(IItemStack stack) {
        this.allInput.remove(CraftTweakerMC.getItemStack(stack));
    }

    @Override
    public void addAllInput(IItemStack stack) {
        this.allInput.add(CraftTweakerMC.getItemStack(stack));
    }

    @Override
    public void clearAllInput() {
        this.allInput.clear();
    }

    @Override
    public boolean consumeMana(int totalCost) {
        return this.consumeMana(null, totalCost, false);
    }
}

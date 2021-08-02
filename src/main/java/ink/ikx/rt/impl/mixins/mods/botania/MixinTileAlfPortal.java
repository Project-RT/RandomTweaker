package ink.ikx.rt.impl.mixins.mods.botania;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import ink.ikx.rt.impl.events.customevent.AlfPortalDroppedEvent;
import ink.ikx.rt.impl.events.customevent.ElvenTradeEvent;
import ink.ikx.rt.impl.utils.ItemStackList;
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
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
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

    private final ItemStackList inputList = new ItemStackList();

    @Shadow
    protected abstract void spawnItem(ItemStack stack);

    @Shadow
    public abstract boolean consumeMana(@Nullable List<BlockPos> pylons, int totalCost, boolean close);

    private static ItemStack[] asItemStackArray(List<ItemStack> stacksIn) {
        return stacksIn.stream().map(ItemStack::copy).toArray(ItemStack[]::new);
    }

    // why the fucking need all the variable to parameter ????????????
    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lvazkii/botania/common/block/tile/TileAlfPortal;validateItemUsage(Lnet/minecraft/item/ItemStack;)Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectUpdate_(CallbackInfo ci, IBlockState iBlockState, AlfPortalState state, AlfPortalState newState, AxisAlignedBB aabb, boolean open, ElvenPortalUpdateEvent event, List items, Iterator var8, EntityItem item, ItemStack stack, boolean consume) { // validateItemUsage
        if (!new AlfPortalDroppedEvent(getWorld(), getPos(), stack).post()) {
            addInput(CraftTweakerMC.getIItemStack(stack));
        }
    }

    @Inject(method = "resolveRecipes", at = @At(value = "INVOKE", target = "Lvazkii/botania/api/recipe/RecipeElvenTrade;matches(Ljava/util/List;Z)Z", ordinal = 1), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void injectResolveRecipes(CallbackInfo ci, int i, Iterator var2, RecipeElvenTrade recipe) {
        ElvenTradeEvent event = new ElvenTradeEvent(getWorld(), getPos(), asItemStackArray(stacksIn), asItemStackArray(recipe.getOutputs()));
        recipe.matches(stacksIn, true);
        if (!event.post()) {
            Arrays.stream(event.getOutput()).forEach(this::spawnItem);
        }
        ci.cancel();
    }

    @Override
    public IItemStack[] getInputList() {
        return inputList.getItemStackList().stream().map(CraftTweakerMC::getIItemStack).toArray(IItemStack[]::new);
    }

    @Override
    public void setInputList(IItemStack[] newList) {
        inputList.setItemStackList(Arrays.stream(newList).map(CraftTweakerMC::getItemStack).collect(Collectors.toList()));
    }

    @Override
    public void delInput(IItemStack stack) {
        inputList.remove(CraftTweakerMC.getItemStack(stack));
    }

    @Override
    public void addInput(IItemStack stack) {
        inputList.add(CraftTweakerMC.getItemStack(stack));
    }

    @Override
    public void clearInputList() {
        inputList.clear();
    }

    @Override
    public boolean consumeMana(int totalCost) {
        return this.consumeMana(null, totalCost, false);
    }

    @Override
    public void spawnItem(IItemStack stack) {
        spawnItem(CraftTweakerMC.getItemStack(stack));
    }
}

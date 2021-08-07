package ink.ikx.rt.impl.mixins.mods.botania;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.data.DataMap;
import crafttweaker.api.data.IData;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import crafttweaker.mc1120.data.NBTConverter;
import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import ink.ikx.rt.impl.events.customevent.AlfPortalDroppedEvent;
import ink.ikx.rt.impl.events.customevent.ElvenTradeEvent;
import ink.ikx.rt.impl.utils.ItemStackList;
import ink.ikx.rt.impl.utils.Utils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
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

    @Shadow
    @Final
    private static String TAG_PORTAL_FLAG;

    private final ItemStackList inputList = new ItemStackList();

    private ItemStack stacksCopy;
    private boolean eventExec;

    @Shadow
    protected abstract void spawnItem(ItemStack stack);

    @Shadow
    public abstract boolean consumeMana(@Nullable List<BlockPos> pylons, int totalCost, boolean close);

    // why the fucking need all the variable to parameter ????????????
    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lvazkii/botania/common/block/tile/TileAlfPortal;validateItemUsage(Lnet/minecraft/item/ItemStack;)Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectUpdate(CallbackInfo ci, IBlockState iBlockState, AlfPortalState state, AlfPortalState newState, AxisAlignedBB aabb, boolean open, ElvenPortalUpdateEvent eventU, List items, Iterator var8, EntityItem item, ItemStack stack, boolean consume) { // validateItemUsage
        AlfPortalDroppedEvent event = new AlfPortalDroppedEvent(item, this);
        eventExec = event.post();
        stacksCopy = event.getInput().getItem();
        if (!eventExec) {
            addInput(CraftTweakerMC.getIItemStack(stacksCopy));
            item.isDead = event.isDead();
            if (!item.isDead)
                item.getEntityData().setBoolean(TAG_PORTAL_FLAG, true);
        } else {
            if (event.getOutput() != null) {
                event.getOutput().forEach(this::spawnItem);
            } else {
                if (item.isDead)
                    spawnItem(stacksCopy);
            }
        }
    }

    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lvazkii/botania/common/block/tile/TileAlfPortal;addItem(Lnet/minecraft/item/ItemStack;)V", shift = Shift.AFTER))
    private void injectUpdate_(CallbackInfo ci) {
        AtomicInteger count = new AtomicInteger(1);
        if (eventExec) {
            stacksIn.removeIf(a -> {
                if (count.get() <= stacksCopy.getCount()) {
                    Utils.areItemStacksEqual(stacksCopy, a);
                    count.getAndIncrement();
                    return true;
                }
                return false;
            });
        }
    }

    @Inject(method = "resolveRecipes", at = @At(value = "INVOKE", target = "Lvazkii/botania/api/recipe/RecipeElvenTrade;matches(Ljava/util/List;Z)Z", ordinal = 1), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void injectResolveRecipes(CallbackInfo ci, int i, Iterator var2, RecipeElvenTrade recipe) {
        ElvenTradeEvent event = new ElvenTradeEvent(this, stacksIn, recipe.getOutputs());
        recipe.matches(stacksIn, true);
        if (!event.post()) {
            event.getOutput().forEach(this::spawnItem);
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

    @Override
    public IBlockPos getBlockPos() {
        return CraftTweakerMC.getIBlockPos(this.getPos());
    }

    @Override
    public IWorld getIWorld() {
        return CraftTweakerMC.getIWorld(this.getWorld());
    }

    @Override
    public boolean isEmpty(IData data) {
        return this.getTileData().isEmpty();
    }

    @Override
    public IData getData() {
        return NBTConverter.from(this.getTileData(), true);
    }

    @Override
    public void setData(IData data) {
        if (data instanceof DataMap) {
            this.getTileData().merge((NBTTagCompound) NBTConverter.from(data));
            this.markDirty();
        } else {
            CraftTweakerAPI.logError("data argument must be DataMap", new IllegalArgumentException());
        }
    }

    @Override
    public void updateData(IData data) {
        this.setData(this.getData().add(data));
    }

}

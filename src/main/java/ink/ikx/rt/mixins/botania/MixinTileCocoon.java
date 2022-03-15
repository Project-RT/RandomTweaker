package ink.ikx.rt.mixins.botania;

import com.google.common.collect.Maps;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.data.DataMap;
import crafttweaker.api.data.IData;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import crafttweaker.mc1120.data.NBTConverter;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.mods.botania.ICocoon;
import ink.ikx.rt.api.mods.botania.function.ICocoonTileEntity;
import ink.ikx.rt.impl.mods.botania.cocoon.IMixinTileCocoon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.block.tile.TileCocoon;
import vazkii.botania.common.block.tile.TileMod;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import javax.annotation.Nullable;

@Pseudo
@Mixin(value = TileCocoon.class, remap = false)
public abstract class MixinTileCocoon extends TileMod implements IMixinTileCocoon, ICocoonTileEntity {

    private static final String CUSTOM_TAB = "CustomTab";

    private final Map<String, Integer> customMap = Maps.newHashMap();

    @Override
    public int getMapSize() {
        return customMap.size();
    }

    @Override
    public IData getData() {
        return NBTConverter.from(this.getTileData(), false);
    }

    @Override
    public void updateData(IData data) {
        if (data instanceof DataMap) {
            this.getTileData().merge((NBTTagCompound) NBTConverter.from((data)));
            this.markDirty();
        } else {
            CraftTweakerAPI.logError("data argument must be DataMap", new IllegalArgumentException());
        }
    }

    @Override
    public IWorld getIWorld() {
        return CraftTweakerMC.getIWorld(this.world);
    }

    @Override
    public IBlockPos getIBlockPos() {
        return CraftTweakerMC.getIBlockPos(this.pos);
    }

    public int getAmount(String cocoonName) {
        return customMap.getOrDefault(cocoonName, 0);
    }

    @Override
    public int getAmount(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
        ICocoon cocoon = ICocoon.getInstanceByStack(stack);

        if (Objects.nonNull(cocoon)) {
            String name = cocoon.getSpawnDynamicResult(stack, player, this);

            if (Main.CUSTOM_COCOONS_SPAWN.containsKey(name)) {
                return this.getAmount(name);
            }
        }

        return 0;
    }

    @Override
    public void setAmount(World world, BlockPos pos, ItemStack stack, EntityPlayer player, int amount) {
        ICocoon cocoon = ICocoon.getInstanceByStack(stack);

        if (Objects.nonNull(cocoon)) {
            String name = cocoon.getSpawnDynamicResult(stack, player, this);

            if (Main.CUSTOM_COCOONS_SPAWN.containsKey(name)) {
                this.customMap.put(name, amount);
            }
        }
    }

    @Nullable
    private String getTabName() {
        String name = null;

        for (Entry<String, Integer> entry : customMap.entrySet()) {
            if (Objects.isNull(name)) {
                name = entry.getKey();
            } else if (entry.getValue() > customMap.get(name)) {
                name = entry.getKey();
            }
        }

        return name;
    }

    private void spawnEntityLiving(EntityLiving entityLiving) {
        entityLiving.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        if (entityLiving instanceof EntityAgeable) {
            ((EntityAgeable) entityLiving).setGrowingAge(-24000);
        }
        entityLiving.onInitialSpawn(world.getDifficultyForLocation(pos), null);
        world.spawnEntity(entityLiving);
        entityLiving.spawnExplosionParticle();
    }

    @Inject(method = "readPacketNBT", at = @At(value = "HEAD"))
    private void injectReadPacketNBT(NBTTagCompound cmp, CallbackInfo ci) {
        NBTTagCompound data = cmp.getCompoundTag(CUSTOM_TAB);
        data.getKeySet().forEach(name ->
            this.customMap.put(name, data.getInteger(name)));
    }

    @Inject(method = "writePacketNBT", at = @At(value = "HEAD"))
    private void injectWritePacketNBT(NBTTagCompound cmp, CallbackInfo ci) {
        if (!cmp.hasKey(CUSTOM_TAB)) {
            cmp.setTag(CUSTOM_TAB, new NBTTagCompound());
        }

        customMap.forEach((name, amount) -> cmp.getCompoundTag(CUSTOM_TAB).setInteger(name, amount));
    }

    @Inject(method = "hatch", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLiving;setPosition(DDD)V", remap = true), cancellable = true)
    private void injectHatch(CallbackInfo ci) {
        String name = this.getTabName();
        ICocoon cocoon = ICocoon.getInstanceByName(name);

        if (Objects.isNull(cocoon)) {
            CraftTweakerAPI.logWarning("[RandomTweaker] cocoon is null");
            return;
        }

        for (EntityEntry entityEntry : cocoon.getSpawnTab().keySet()) {
            double probably = cocoon.getProbablyByEntity(entityEntry);
            if (Math.random() < probably) {
                Entity entity = entityEntry.newInstance(this.world);
                if (entity instanceof EntityLiving) {
                    this.spawnEntityLiving((EntityLiving) entity);
                    ci.cancel();
                    break;
                }

                CraftTweakerAPI.logWarning(entity.getName() + " does not extend EntityLiving");
            }
        }
    }

}

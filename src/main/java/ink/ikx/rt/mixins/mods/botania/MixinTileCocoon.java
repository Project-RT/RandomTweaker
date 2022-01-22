package ink.ikx.rt.mixins.mods.botania;

import com.google.common.collect.Maps;
import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.api.mods.botania.ICocoon;
import ink.ikx.rt.impl.mods.botania.IMixinTileCocoon;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.EntityEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.block.tile.TileCocoon;
import vazkii.botania.common.block.tile.TileMod;

@Pseudo
@Mixin(value = TileCocoon.class, remap = false)
public abstract class MixinTileCocoon extends TileMod implements IMixinTileCocoon {

    private static final String FLAG = "spawnEntityByRandomTweaker";

    @Shadow
    public int emeraldsGiven;
    @Shadow
    public int chorusFruitGiven;
    private static final String CUSTOM_TAB = "CustomTab";
    private final Map<String, Integer> customMap = Maps.newHashMap();

    public int getAmount(ICocoon cocoon) {
        return Objects.nonNull(cocoon) && customMap.containsKey(cocoon.getName()) ? customMap.get(cocoon.getName()) : 0;
    }

    @Override
    public int getAmount(ItemStack stack) {
        return this.getAmount(ICocoon.getInstanceByStack(stack));
    }

    @Override
    public void setAmount(ItemStack stack, int amount) {
        ICocoon cocoon = ICocoon.getInstanceByStack(stack);

        if (Objects.nonNull(cocoon)) {
            this.customMap.put(cocoon.getName(), amount);
        }
    }

    private String getICocoonName() {
        String name = null;
        int amount = 0;

        for (Entry<String, Integer> entry : customMap.entrySet()) {
            if (Objects.isNull(name)) {
                name = entry.getKey();
                amount = entry.getValue();
            } else if (entry.getValue() > amount) {
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

    private void spawnItem() {
        if (this.getTileData().hasKey(FLAG) && this.getTileData().getBoolean(FLAG)) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 1.5;
            double z = pos.getZ() + 0.5;

            if (emeraldsGiven > 0) {
                EntityItem emeralds = new EntityItem(world, x, y, z, new ItemStack(Items.EMERALD, emeraldsGiven));
                world.spawnEntity(emeralds);
            }

            if (chorusFruitGiven > 0) {
                EntityItem chorusFruit = new EntityItem(world, x, y, z, new ItemStack(Items.CHORUS_FRUIT, chorusFruitGiven));
                world.spawnEntity(chorusFruit);
            }
        }
    }

    @Inject(method = "readPacketNBT", at = @At(value = "HEAD"))
    private void injectReadPacketNBT(NBTTagCompound cmp, CallbackInfo ci) {
        cmp.getCompoundTag(CUSTOM_TAB).getKeySet().forEach(name ->
            this.customMap.put(name, cmp.getCompoundTag(CUSTOM_TAB).getInteger(name)));
    }

    @Inject(method = "writePacketNBT", at = @At(value = "HEAD"))
    private void injectWritePacketNBT(NBTTagCompound cmp, CallbackInfo ci) {
        if (!cmp.hasKey(CUSTOM_TAB)) {
            cmp.setTag(CUSTOM_TAB, new NBTTagCompound());
        }

        customMap.forEach((name, amount) -> cmp.getCompoundTag(CUSTOM_TAB).setInteger(name, amount));
    }

    @Inject(method = "hatch", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLiving;setPosition(DDD)V"), cancellable = true)
    private void injectHatch(CallbackInfo ci) {
        String name = this.getICocoonName();
        ICocoon cocoon = ICocoon.getInstanceByName(name);

        if (Objects.isNull(cocoon)) {
            CraftTweakerAPI.logError("cocoon is null!", new NullPointerException());
            return;
        }

        for (EntityEntry entityEntry : cocoon.getSpawnTab().keySet()) {
            double probably = cocoon.getProbablyByEntity(entityEntry);
            if (Math.random() < probably) {
                Entity entity = entityEntry.newInstance(world);
                if (entity instanceof EntityLiving) {
                    this.spawnEntityLiving((EntityLiving) entity);
                    this.getTileData().setBoolean(FLAG, true);
                    ci.cancel();
                    break;
                }

                CraftTweakerAPI.logWarning(entity.getName() + " does not extend EntityLiving");
            }
        }

        this.spawnItem();
    }

}

package ink.ikx.rt.mixins.mods.botania;

import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.api.mods.botania.ICocoon;
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
public abstract class MixinTileCocoon extends TileMod {

    @Shadow
    public int emeraldsGiven;
    @Shadow
    public int chorusFruitGiven;

    private String getStack(NBTTagCompound itemGiven) {
        String stack = null;

        for(String stackInTileData : itemGiven.getKeySet()) {
            if(Objects.isNull(stack)) {
                stack = stackInTileData;
            } else if(itemGiven.getFloat(stackInTileData) > itemGiven.getFloat(stack)) {
                stack = stackInTileData;
            }
        }

        return stack;
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
        if(this.getTileData().hasKey("spawnEntityByRt") && this.getTileData().getBoolean("spawnEntityByRt")) {
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 1.5;
            double z = pos.getZ() + 0.5;

            if(emeraldsGiven > 0) {
                EntityItem emeralds = new EntityItem(world, x, y, z, new ItemStack(Items.EMERALD, emeraldsGiven));
                world.spawnEntity(emeralds);
            }

            if(chorusFruitGiven > 0) {
                EntityItem chorusFruit = new EntityItem(world, x, y, z, new ItemStack(Items.CHORUS_FRUIT, chorusFruitGiven));
                world.spawnEntity(chorusFruit);
            }
        }
    }

    @Inject(method = "hatch", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLiving;setPosition(DDD)V"), cancellable = true)
    private void injectHatch(CallbackInfo ci) {
        String stack = getStack(this.getTileData().getCompoundTag("ItemGiven"));
        ICocoon cocoon = ICocoon.getInstanceByString(stack);

        for(EntityEntry entityEntry : cocoon.getSpawnTab().keySet()) {
            double probably = cocoon.getProbablyByEntity(entityEntry);
            if (Math.random() < probably) {
                Entity entity = entityEntry.newInstance(world);
                if (entity instanceof EntityLiving) {
                    this.spawnEntityLiving((EntityLiving) entity);
                    this.getTileData().setBoolean("spawnEntityByRt", true);
                    ci.cancel();
                    break;
                } else {
                    CraftTweakerAPI.logWarning(entity.getName() + "does not extend EntityLiving");
                }
            }
        }

        spawnItem();
    }

}

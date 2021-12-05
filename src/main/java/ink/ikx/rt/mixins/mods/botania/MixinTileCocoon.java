package ink.ikx.rt.mixins.mods.botania;

import ink.ikx.rt.Main;
import ink.ikx.rt.api.mods.botania.ICocoon;
import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import vazkii.botania.common.block.tile.TileCocoon;
import vazkii.botania.common.block.tile.TileMod;

@Pseudo
@Mixin(value = TileCocoon.class, remap = false)
public abstract class MixinTileCocoon extends TileMod {

    private String getStack(NBTTagCompound itemGiven) {
        String probabilityMax = null;

        for(String stack : itemGiven.getKeySet()) {
            if(Objects.isNull(probabilityMax)) {
                probabilityMax = stack;
            } else if(itemGiven.getFloat(stack) > itemGiven.getFloat(probabilityMax)) {
                probabilityMax = stack;
            }
        }

        return probabilityMax;
    }

    @Inject(method = "hatch", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLiving;setPosition(DDD)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectHatch(CallbackInfo ci, EntityLiving entityLiving) {
        String stack = getStack(this.getTileData().getCompoundTag("ItemGiven"));

        for(ICocoon cocoon : Main.CUSTOM_COCOONS_SPAWN) {
            if(cocoon.match(stack)) {
                for(Float probability : cocoon.getSpawnTab().keySet()) {
                    if(Math.random() < probability) {
                        Entity entity = cocoon.getEntityAt(probability).newInstance(this.world);
                        if(entity instanceof EntityLiving) {
                            entityLiving = (EntityLiving) entity;
                        }
                        break;
                    }
                }
            }
        }
    }

}

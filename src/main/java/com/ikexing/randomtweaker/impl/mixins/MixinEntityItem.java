package com.ikexing.randomtweaker.impl.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.ikexing.randomtweaker.RandomTweaker.noBurnItems;

/**
 * @author ikexing
 */

@Mixin(value = EntityItem.class)
public abstract class MixinEntityItem extends Entity {

    @Shadow
    public abstract ItemStack getItem();

    public MixinEntityItem(World worldIn) {
        super(worldIn);
    }

    @Inject(method = "attackEntityFrom", at = @At("HEAD"), cancellable = true)
    public void mixinAttackEntityFrom(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (!this.world.isRemote && !this.isDead && !this.isEntityInvulnerable(source)) {
            for (ItemStack item : noBurnItems) {
                ItemStack oItem = this.getItem();
                if (item.getItem() == oItem.getItem() && item.getMetadata() == oItem.getMetadata()) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}

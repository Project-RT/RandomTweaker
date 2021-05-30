package com.ikexing.randomtweaker.impl.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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
    public void MixinAttackEntityFrom(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (!this.world.isRemote && !this.isDead && !this.isEntityInvulnerable(source)) {
            if (this.getItem().isEmpty() && this.getItem().getItem() == Items.STICK) {
                cir.setReturnValue(false);
            }
        }
    }
}

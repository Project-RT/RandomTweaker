package ink.ikx.rt.impl.mixins.core;

import static ink.ikx.rt.RandomTweaker.itemDsSet;

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

@Mixin(value = EntityItem.class)
public abstract class MixinEntityItem extends Entity {

    @Shadow
    public abstract ItemStack getItem();

    public MixinEntityItem(World worldIn) {
        super(worldIn);
    }

    @Inject(method = "attackEntityFrom", at = @At(value = "HEAD"), cancellable = true)
    public void injectAttackEntityFrom(DamageSource source, float amount,
        CallbackInfoReturnable<Boolean> cir) {
        if (!this.world.isRemote && !this.isDead && !this.isEntityInvulnerable(source)) {
            itemDsSet.forEach(it -> {
                it.item.setCount(this.getItem().getCount());
                if (ItemStack.areItemStacksEqual(this.getItem(), it.item) && source == it.damageSource) {
                    cir.setReturnValue(false);
                }
            });
        }
    }
}

package ink.ikx.rt.mixins.thaumcraft;

import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.Main;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import thaumcraft.api.aspects.AspectEventProxy;
import thaumcraft.api.aspects.AspectList;

@Mixin(value = AspectEventProxy.class, remap = false)
public class MixinAspectEventProxy {

    @Inject(method = "registerObjectTag(Lnet/minecraft/item/ItemStack;Lthaumcraft/api/aspects/AspectList;)V",
        at = @At(value = "INVOKE", target = "Ljava/util/concurrent/ConcurrentHashMap;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"))
    private void injectRegisterObjectTag(ItemStack item, AspectList aspects, CallbackInfo ci) {
        Main.OBJECT_TAGS_FOR_RT.put(CraftTweakerMC.getIItemStack(item), aspects);
    }

}

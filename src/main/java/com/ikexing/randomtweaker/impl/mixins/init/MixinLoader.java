package com.ikexing.randomtweaker.impl.mixins.init;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModClassLoader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.discovery.ModDiscoverer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

/**
 * @author ikexing<br>
 */
@Mixin(value = Loader.class, remap = false, priority = 800)
public abstract class MixinLoader {
    @Shadow
    private List<ModContainer> mods;
    @Shadow
    private ModClassLoader modClassLoader;

    @Inject(method = "loadMods", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/common/LoadController;transition(Lnet/minecraftforge/fml/common/LoaderState;Z)V", ordinal = 1), remap = false)
    private void initMixins(List<String> injectedModContainers, CallbackInfo ci) {
        for (ModContainer mod : mods) {
            try {
                modClassLoader.addFile(mod.getSource());
                System.out.println(mod.getModId());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("mixins mods");
        Mixins.addConfiguration("mixins.randomtweaker.json");
    }
}

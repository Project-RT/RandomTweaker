package ink.ikx.rt.impl.mixins.init;

import org.spongepowered.asm.mixin.Mixins;
import zone.rong.mixinbooter.MixinLoader;

@MixinLoader
public class ModMixinLoader {

    public ModMixinLoader() {
        Mixins.addConfiguration("mixins.randomtweaker.mods.json");
    }
}

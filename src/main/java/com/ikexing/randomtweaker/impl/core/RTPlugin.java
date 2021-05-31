package com.ikexing.randomtweaker.impl.core;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * @author ikexing
 */
@IFMLLoadingPlugin.Name("randomtweaker")
@IFMLLoadingPlugin.SortingIndex(-7500)
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class RTPlugin implements IFMLLoadingPlugin {
    public RTPlugin() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.randomtweaker.core.json");
        Mixins.addConfiguration("mixins.randomtweaker.init.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
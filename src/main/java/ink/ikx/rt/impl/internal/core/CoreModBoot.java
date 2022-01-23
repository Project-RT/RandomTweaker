package ink.ikx.rt.impl.internal.core;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

/**
 * @author ikexing
 */
@IFMLLoadingPlugin.Name("RandomTweaker Mixin Boot")
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class CoreModBoot implements IFMLLoadingPlugin {

    public CoreModBoot() {
        MixinBootstrap.init();
        LogManager.getLogger("RandomTweaker Mixins").info("registering core mixins...");
        Mixins.addConfiguration("mixins.randomtweaker.init.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                "ink.ikx.rt.classTransforms.RandomTweakerClassTransformer"
        };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

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
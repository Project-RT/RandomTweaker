package ink.ikx.rt.impl.internal.core;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * @author ikexing
 */
@IFMLLoadingPlugin.Name("RandomTweaker Mixin Boot")
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class CoreModBoot implements IFMLLoadingPlugin {

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
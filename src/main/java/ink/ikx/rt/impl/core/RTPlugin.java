package ink.ikx.rt.impl.core;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.Map;
import net.minecraftforge.fml.relauncher.CoreModManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

/**
 * @author ikexing
 */
@IFMLLoadingPlugin.Name("RandomTweaker Plugin")
@IFMLLoadingPlugin.SortingIndex(-7500)
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class RTPlugin implements IFMLLoadingPlugin {

    public RTPlugin() {
        MixinBootstrap.init();
        LogManager.getLogger("RandomTweaker Mixins").info("registering core mixins...");
        Mixins.addConfiguration("mixins.randomtweaker.core.json");

        CodeSource codeSource = this.getClass().getProtectionDomain().getCodeSource();
        if (codeSource != null) {
            URL location = codeSource.getLocation();
            try {
                File file = new File(location.toURI());
                if (file.isFile()) {
                    CoreModManager.getReparseableCoremods().remove(file.getName());
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            LogManager.getLogger().warn(
                "No CodeSource, if this is not a development environment we might run into problems!");
            LogManager.getLogger().warn(this.getClass().getProtectionDomain());
        }
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
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
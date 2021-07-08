package ink.ikx.rt.api.instance.render;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.proxy.CommonProxy;
import net.minecraftforge.fml.common.SidedProxy;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.randomtweaker.render.BaubleRenderHelper")
public class BaubleRenderHelper {

    @SidedProxy(clientSide = "ink.ikx.rt.impl.proxy.ClientProxy",
        serverSide = "ink.ikx.rt.impl.proxy.SeverProxy")
    public static CommonProxy proxy;

    @ZenMethod
    public static void bindTexture() {
        proxy.bindTexture();
    }

    @ZenMethod
    public static void renderItem(IItemStack renderStack, @Optional(value = "NONE") String transformType) {
        proxy.renderItem(renderStack, transformType);
    }

    @ZenMethod
    public static void rotateIfSneaking(IPlayer player) {
        proxy.rotateIfSneaking(player);
    }

    @ZenMethod
    public static void applySneakingRotation() {
        proxy.applySneakingRotation();
    }

    @ZenMethod
    public static void translateToHeadLevel(IPlayer player) {
        proxy.translateToHeadLevel(player);
    }

    @ZenMethod
    public static void translateToFace() {
        proxy.translateToFace();
    }

    @ZenMethod
    public static void defaultTransforms() {
        proxy.defaultTransforms();
    }

    @ZenMethod
    public static void scale(double x, double y, double z) {
        proxy.scale(x, y, z);
    }

    @ZenMethod
    public static void rotate(float angle, float x, float y, float z) {
        proxy.rotate(angle, x, y, z);
    }

    @ZenMethod
    public static void translate(double x, double y, double z) {
        proxy.translate(x, y, z);
    }
}

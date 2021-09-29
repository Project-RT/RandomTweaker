package ink.ikx.rt.api.mods.render;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.BaubleRenderHelper")
public class BaubleRenderHelper {

    @ZenMethod
    public static void bindTexture(@Optional(value = "textures/atlas/blocks.png") String resourceLocation) {
        RandomTweaker.proxy.bindTexture(resourceLocation);
    }

    @ZenMethod
    public static void renderItem(IItemStack renderStack, @Optional(value = "NONE") String transformType) {
        RandomTweaker.proxy.renderItem(renderStack, transformType);
    }

    @ZenMethod
    public static void rotateIfSneaking(IPlayer player) {
        RandomTweaker.proxy.rotateIfSneaking(player);
    }

    @ZenMethod
    public static void translateToHeadLevel(IPlayer player) {
        RandomTweaker.proxy.translateToHeadLevel(player);
    }

    @ZenMethod
    public static void translateToFace() {
        RandomTweaker.proxy.translateToFace();
    }

    @ZenMethod
    public static void defaultTransforms() {
        RandomTweaker.proxy.defaultTransforms();
    }

    @ZenMethod
    public static void scale(double x, double y, double z) {
        RandomTweaker.proxy.scale(x, y, z);
    }

    @ZenMethod
    public static void rotate(float angle, float x, float y, float z) {
        RandomTweaker.proxy.rotate(angle, x, y, z);
    }

    @ZenMethod
    public static void translate(double x, double y, double z) {
        RandomTweaker.proxy.translate(x, y, z);
    }

    @ZenMethod
    public static void translateToChest() {
        RandomTweaker.proxy.translateToChest();
    }
}

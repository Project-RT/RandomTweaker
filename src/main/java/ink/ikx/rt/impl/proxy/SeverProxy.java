package ink.ikx.rt.impl.proxy;

import cn.hutool.core.compiler.CompilerUtil;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.JAVATextContent;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleRender;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.api.subtile.signature.BasicSignature;

/**
 * @author superhelo
 */
@SuppressWarnings("unchecked")
public class SeverProxy implements IProxy {

    @Override
    public void scale(double x, double y, double z) { }

    @Override
    public void rotate(float angle, float x, float y, float z) { }

    @Override
    public void translate(double x, double y, double z) { }

    @Override
    public void bindTexture(String resourceLocation) { }

    @Override
    public void renderItem(IItemStack renderStack, String transformType) { }

    @Override
    public void onPlayerBaubleRender(BaubleRender render, IItemStack stack, IPlayer player, String renderType, float partialTicks) { }

    @Override
    public void rotateIfSneaking(IPlayer player) { }

    @Override
    public void translateToFace() {
    }

    @Override
    public void translateToHeadLevel(IPlayer player) {
    }

    @Override
    public void defaultTransforms() {
    }

    @Override
    public void translateToChest() {
    }

    @Override
    public void botaniaReg() {
        if (RandomTweaker.subTileGeneratingMap.isEmpty()) {
            return;
        }
        RandomTweaker.subTileGeneratingMap.forEach((k, v) -> {
            String Generating = JAVATextContent.Generating.replace("{$name}", k);
            String className = "ink.ikx.rt.api.mods.cote.flower.generating.CustomSubTileGeneratingContent_" + k;
            ClassLoader classLoader = CompilerUtil.getCompiler(null)
                .addSource(className, Generating)
                .compile();

            try {
                Class<? extends SubTileEntity> clazz = (Class<? extends SubTileEntity>) classLoader.loadClass(className);
                BotaniaAPI.registerSubTile(k, clazz);
                BotaniaAPI.registerSubTileSignature(clazz, new BasicSignature(k));
                BotaniaAPI.addSubTileToCreativeMenu(k);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}

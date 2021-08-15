package ink.ikx.rt.impl.mixins.mods.botania;

import cn.hutool.core.lang.Pair;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import java.util.Map.Entry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.block.tile.TileSpecialFlower;

@Mixin(value = TileSpecialFlower.class, remap = false)
public abstract class MixinTileSpecialFlower {

    @Shadow
    public abstract void setSubTile(SubTileEntity tile);

    @Inject(method = "provideSubTile", at = @At(value = "RETURN"))
    protected void injectProvideSubTile(String name, CallbackInfo ci) {
        for (Entry<String, Pair<String, SubTileEntityInGame>> entries : RandomTweaker.subTileGeneratingMap.entrySet()) {
            if (entries.getKey().equals(name)) {
                setSubTile((SubTileEntity) entries.getValue().getValue());
            }
        }
    }
}

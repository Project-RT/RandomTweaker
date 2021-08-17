package ink.ikx.rt.impl.mixins.mods.botania;

import cn.hutool.core.lang.Pair;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import java.util.Map.Entry;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.block.tile.TileSpecialFlower;

@Mixin(value = TileSpecialFlower.class, remap = false)
public abstract class MixinTileSpecialFlower {

    @Final
    @Shadow
    private static String TAG_SUBTILE_NAME;
    @Shadow
    public String subTileName;
    @Shadow
    private SubTileEntity subTile;

    @Shadow
    public abstract void setSubTile(SubTileEntity tile);

    @Shadow
    protected abstract void provideSubTile(String name);

    @Inject(method = "provideSubTile", at = @At(value = "HEAD"), cancellable = true)
    protected void injectProvideSubTile(String name, CallbackInfo ci) {
        for (Entry<String, Pair<String, SubTileEntityInGame>> entries : RandomTweaker.subTileGeneratingMap.entrySet()) {
            if (entries.getKey().equals(name)) {
                setSubTile((SubTileEntity) entries.getValue().getValue());
                ci.cancel();
            }
        }
    }

    @Inject(method = "readPacketNBT", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NBTTagCompound;getString(Ljava/lang/String;)Ljava/lang/String;", shift = Shift.AFTER), cancellable = true)
    public void readPacketNBT(NBTTagCompound cmp, CallbackInfo ci) {
        NBTTagCompound subCmp = cmp.getCompoundTag(TAG_SUBTILE_NAME);

        try {
            if (subTile == null || !BotaniaAPI.getSubTileStringMapping(subTile.getClass()).equals(subTileName))
                provideSubTile(subTileName);
        } catch (NullPointerException e) {
            if (!RandomTweaker.subTileGeneratingMap.containsKey(subTileName))
                provideSubTile(subTileName);
        }

        if (subTile != null)
            subTile.readFromPacketNBTInternal(subCmp);

        ci.cancel();
    }
}

package ink.ikx.rt.impl.mixins.mods.botania;

import cn.hutool.core.lang.Pair;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.api.mods.cote.flower.functional.SubTileFunctionalContent;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingContent;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.block.tile.TileMod;
import vazkii.botania.common.block.tile.TileSpecialFlower;

import java.util.Map.Entry;

@Pseudo
@Mixin(value = TileSpecialFlower.class, remap = false)
public abstract class MixinTileSpecialFlower extends TileMod {

    @Final
    @Shadow
    private static String TAG_SUBTILE_CMP;
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
        for (Entry<String, Pair<String, SubTileRepresentation>> entries : RandomTweaker.subTileGeneratingMap.entrySet()) {
            if (entries.getKey().equals(name)) {
                subTileName = name;
                if(entries.getValue().getKey().equals("generating")) {
                    setSubTile(new SubTileGeneratingContent(entries.getValue().getValue()));
                } else {
                    setSubTile(new SubTileFunctionalContent(entries.getValue().getValue()));
                }
                ci.cancel();
            }
        }
    }

    @Inject(method = "readPacketNBT", at = @At(value = "HEAD"), cancellable = true)
    public void readPacketNBT(NBTTagCompound cmp, CallbackInfo ci) {
        super.readPacketNBT(cmp);
        subTileName = cmp.getString(TAG_SUBTILE_NAME);

        NBTTagCompound subCmp = cmp.getCompoundTag(TAG_SUBTILE_CMP);

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

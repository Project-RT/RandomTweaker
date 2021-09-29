package ink.ikx.rt.mixins.mods.botania;

import cn.hutool.core.lang.Pair;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.subtile.MCSubTileEntityFunctionalContent;
import ink.ikx.rt.impl.mods.contenttweaker.subtile.MCSubTileEntityGeneratingContent;
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

import java.util.Map;

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
        for (Map.Entry<String, Pair<String, ISubTileEntityRepresentation>> entry : Main.SUB_TILE_GENERATING_MAP.entrySet()) {
            if (entry.getKey().equals(name)) {
                subTileName = name;
                if (entry.getValue().getKey().equals("generating")) {
                    setSubTile(new MCSubTileEntityGeneratingContent(entry.getValue().getValue()));
                } else {
                    setSubTile(new MCSubTileEntityFunctionalContent(entry.getValue().getValue()));
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
            if (!Main.SUB_TILE_GENERATING_MAP.containsKey(subTileName))
                provideSubTile(subTileName);
        }

        if (subTile != null)
            subTile.readFromPacketNBTInternal(subCmp);

        ci.cancel();
    }


}

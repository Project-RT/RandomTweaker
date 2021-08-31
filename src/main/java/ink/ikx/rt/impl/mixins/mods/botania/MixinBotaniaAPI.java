package ink.ikx.rt.impl.mixins.mods.botania;

import cn.hutool.core.lang.Pair;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.api.mods.cote.flower.functional.SubTileFunctionalContent;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingContent;
import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.api.subtile.signature.BasicSignature;
import vazkii.botania.api.subtile.signature.SubTileSignature;

@Pseudo
@Mixin(value = BotaniaAPI.class, remap = false)
public abstract class MixinBotaniaAPI {

    private static final Map<String, SubTileSignature> customSubTileSignatures = new HashMap<>();

    @Inject(method = "getSignatureForName", at = @At(value = "HEAD"), cancellable = true)
    private static void injectGetSignatureForName(String name, CallbackInfoReturnable<SubTileSignature> cir) {
        if (RandomTweaker.subTileGeneratingMap.containsKey(name)) {
            if (!customSubTileSignatures.containsKey(name))
                customSubTileSignatures.put(name, new BasicSignature(name));
            cir.setReturnValue(customSubTileSignatures.get(name));
        }
    }

    @Inject(method = "getSubTileMapping", at = @At(value = "HEAD"), cancellable = true)
    private static void injectGetSubTileMapping(String key, CallbackInfoReturnable<Class<? extends SubTileEntity>> cir) {
        if (RandomTweaker.subTileGeneratingMap.containsKey(key)) {
            if(RandomTweaker.subTileGeneratingMap.get(key).getKey().equals("generating")) {
                cir.setReturnValue(SubTileGeneratingContent.class);
            } else {
                cir.setReturnValue(SubTileFunctionalContent.class);
            }
        }
    }
}

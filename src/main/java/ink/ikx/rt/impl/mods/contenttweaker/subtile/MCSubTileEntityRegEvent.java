package ink.ikx.rt.impl.mods.contenttweaker.subtile;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Pair;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.internal.file.IProp;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vazkii.botania.api.BotaniaAPIClient;

import java.io.File;
import java.util.Map;

public class MCSubTileEntityRegEvent {

    public static String FLOWER_BLOCK_STATE = "{\n"
            + "  \"forge_marker\": 1,\n"
            + "  \"variants\": {\n"
            + "    \"normal\": [{\n"
            + "      \"model\": \"botania:shapes/cross_tinted\",\n"
            + "      \"textures\": {\n"
            + "        \"cross\": \"contenttweaker:blocks/${name}\"\n"
            + "      }\n"
            + "    }],\n"
            + "    \"inventory\": [{\n"
            + "      \"model\": \"builtin/generated\",\n"
            + "      \"transform\": \"forge:default-item\",\n"
            + "      \"textures\": {\n"
            + "        \"layer0\": \"contenttweaker:blocks/${name}\"\n"
            + "      }\n"
            + "    }]\n"
            + "  }\n"
            + "}";

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        for (Map.Entry<String, Pair<String, ISubTileEntityRepresentation>> entry : Main.SUB_TILE_GENERATING_MAP.entrySet()) {
            createFlowerBlockState(entry.getKey());
            BotaniaAPIClient.registerSubtileModel(entry.getKey(), new ModelResourceLocation(ContentTweaker.MOD_ID + ":" + entry.getKey()));
        }
    }

    private static void createFlowerBlockState(String name) {
        String nameL = name.toLowerCase();
        String path = IProp.getPath(System.getProperty("user.dir"), "resources", "contenttweaker", "blockstates", nameL + ".json");
        File file = new File(path);
        if (!FileUtil.exist(file)) {
            if (nameL.contains("chibi")) {
                nameL = nameL.replace("chibi", "_chibi");
            }
            FileUtil.writeUtf8String(FLOWER_BLOCK_STATE.replace("${name}", nameL), file);
        }
    }

}

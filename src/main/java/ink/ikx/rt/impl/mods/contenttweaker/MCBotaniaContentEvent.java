package ink.ikx.rt.impl.mods.contenttweaker;

import baubles.api.BaublesApi;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.Main;
import ink.ikx.rt.api.internal.file.IProp;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.MCManaBaubleContent;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;
import org.apache.commons.lang3.tuple.Pair;
import org.codehaus.plexus.util.FileUtils;
import vazkii.botania.api.BotaniaAPIClient;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MCBotaniaContentEvent {

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

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent evt) {
        if (!evt.getEntityLiving().world.isRemote
                && evt.getEntityLiving() instanceof EntityPlayer
                && !evt.getEntityLiving().world.getGameRules().getBoolean("keepInventory")
                && !((EntityPlayer) evt.getEntityLiving()).isSpectator()) {
            IItemHandler inv = BaublesApi.getBaublesHandler((EntityPlayer) evt.getEntityLiving());
            for (int i = 0; i < inv.getSlots(); i++) {
                ItemStack stack = inv.getStackInSlot(i);
                if (!stack.isEmpty() && stack.getItem() instanceof MCManaBaubleContent) {
                    ((MCManaBaubleContent) stack.getItem()).onUnequipped(stack, evt.getEntityLiving());
                }
            }
        }
    }

    private static void createFlowerBlockState(String name) {
        String nameL = name.toLowerCase();
        String path = IProp.getPath(System.getProperty("user.dir"), "resources", "contenttweaker", "blockstates", nameL + ".json");
        File file = new File(path);
        if (!file.exists()) {
            if (nameL.contains("chibi")) {
                nameL = nameL.replace("chibi", "_chibi");
            }
            try {
                FileUtils.fileWrite(file, FLOWER_BLOCK_STATE.replace("${name}", nameL));
            } catch (IOException e) {
                CraftTweakerAPI.logError("Failed to create blockstate for " + name, e);
            }
        }
    }

}

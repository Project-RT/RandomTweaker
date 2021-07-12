package ink.ikx.rt.api.mods.cote.flower;

import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.api.mods.cote.function.botania.Update;
import java.util.HashMap;
import java.util.Map;

public class SubTileManager {

    public static final Map<String, Update> TICK_FUNCTIONS = new HashMap<>();

    public static void registerSubTile(SubTileGeneratingRepresentation subtile) {
        String name = subtile.getName();
        if (TICK_FUNCTIONS.containsKey(name)) {
            CraftTweakerAPI.logError("The flower name: " + name + " has been used!");
            return;
        }
        TICK_FUNCTIONS.put(name, subtile.onUpdate);
    }

    public static Update getTickFunction(String name) {
        return TICK_FUNCTIONS.getOrDefault(name, ((subtile, world, pos) -> {
        }));
    }
}

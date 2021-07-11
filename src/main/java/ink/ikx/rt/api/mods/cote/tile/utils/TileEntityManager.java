package ink.ikx.rt.api.mods.cote.tile.utils;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.data.DataMap;
import crafttweaker.api.data.IData;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.function.TileEntityTick;
import ink.ikx.rt.api.mods.cote.tile.TileEntityRepresentation;

public class TileEntityManager {

    public static void registerTileEntity(TileEntityRepresentation tile) {
        String name = tile.getName();
        if (RandomTweaker.TILE_ENTITY_TICKS.containsKey(name)) {
            CraftTweakerAPI.logError("This TileEntity name: " + name + "has been used!");
            return;
        }
        RandomTweaker.TILE_ENTITY_TICKS.put(name, tile.onTick);
    }

    public static TileEntityTick getTickFunction(String name) {
        return RandomTweaker.TILE_ENTITY_TICKS.getOrDefault(name, ((tileEntity, world, pos) -> { }));
    }

    public static void checkDataMap(IData data) {
        if (!(data instanceof DataMap)) {
            CraftTweakerAPI.logError("data argument must be DataMap", new IllegalArgumentException());
        }
    }
}

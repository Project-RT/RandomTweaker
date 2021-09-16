package ink.ikx.rt.impl.botania.module;

import net.minecraft.block.state.IBlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class SubTileOrechidManager {

    public static final Map<IBlockState, Map<String, Integer>> oreWeights = new HashMap<>();

    public static void addOreWeight(IBlockState state, String ore, Integer weight) {
        if (oreWeights.containsKey(state)) {
            Map<String, Integer> map = new HashMap<>();
            map.put(ore, weight);
            Objects.requireNonNull(map).putAll(oreWeights.get(state));
            oreWeights.put(state, map);
        } else
            oreWeights.put(state, new HashMap<String, Integer>() {{
                put(ore, weight);
            }});
    }

    public static String[] getOreWeight(IBlockState state) {
        return Objects.requireNonNull(Optional.ofNullable(oreWeights.get(state)).map(Map::keySet).orElse(null)).toArray(new String[0]);
    }

    public static void delOreWeight(IBlockState state, String oreName, boolean isAll) {
        if (!isAll)
            oreWeights.entrySet().stream()
                .filter(entry -> entry.getKey() == state)
                .map(Entry::getValue)
                .filter(map -> map.containsKey(oreName))
                .forEach(e -> e.remove(oreName));
        else
            Stream.of(oreWeights)
                .filter(m -> m.containsKey(state))
                .forEach(m -> m.remove(state));
    }
}

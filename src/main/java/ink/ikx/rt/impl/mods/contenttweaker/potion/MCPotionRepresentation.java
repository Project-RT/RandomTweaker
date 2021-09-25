package ink.ikx.rt.impl.mods.contenttweaker.potion;

import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.api.mods.contenttweaker.potion.IPotionRepresentation;
import ink.ikx.rt.impl.internal.event.EventRegister;
import net.minecraft.potion.Potion;

import java.text.MessageFormat;

public class MCPotionRepresentation extends IPotionRepresentation {

    public MCPotionRepresentation(int liquidColor, String unlocalizedName) {
        super(liquidColor, unlocalizedName);
    }

    @Override
    public void register() {
        if (!EventRegister.POTION_MAP.containsKey(unlocalizedName)) {
            EventRegister.POTION_MAP.put(unlocalizedName, new MCPotionContent(this));
        } else {
            CraftTweakerAPI.getLogger().logError(MessageFormat.format(
                            "All PotionTypes must be unique. Key: contenttweaker:{0} is not.", unlocalizedName)
                    , new UnsupportedOperationException());
        }
    }

    @Override
    public Potion getInternal() {
        return EventRegister.POTION_MAP.get(unlocalizedName);
    }
}

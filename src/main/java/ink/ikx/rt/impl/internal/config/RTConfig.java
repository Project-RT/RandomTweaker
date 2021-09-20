package ink.ikx.rt.impl.internal.config;

import ink.ikx.rt.Main;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = Main.MODID)
public class RTConfig {

    public static Botania Botania = new Botania();
    public static RandomTweaker RandomTweaker = new RandomTweaker();

    public static class RandomTweaker {

        @RequiresMcRestart
        @Comment("If true, Allow CrT to manipulate the file \"rt.properties\". [default: false]")
        public boolean Prop = false;

    }

    public static class Botania {

        @RequiresMcRestart
        @Comment("If true, the Orechid will be modified. [default: false]")
        public boolean OrechidModified = false;

        @RequiresMcRestart
        @Comment("How much the interval of each work of Orechid.[Valid only for modified results | default: 700]")
        public int OrechidDelay = 20;

        @RequiresMcRestart
        @Comment("How much mana is consumed per work of Orechid.[Valid only for modified results | default: 20]")
        public int OrechidCost = 700;

        @RequiresMcRestart
        @Comment("How much mana is max of Orechid? [Valid only for modified results | default: 18000]")
        public int OrechidMaxMana = 18000;

        @RequiresMcRestart
        @Comment("If true, the Orechid will keep the Botania recipes. [Valid only for modified results | default: true]")
        public boolean OrechidHasDefault = true;

    }

}

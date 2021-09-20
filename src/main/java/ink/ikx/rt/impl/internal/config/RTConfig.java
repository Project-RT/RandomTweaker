package ink.ikx.rt.impl.internal.config;

import ink.ikx.rt.Main;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = Main.MODID)
public class RTConfig {

    public static RandomTweaker RandomTweaker = new RandomTweaker();

    public static class RandomTweaker {

        @RequiresMcRestart
        @Comment("If true, Allow CrT to manipulate the file \"rt.properties\". [default: false]")
        public boolean Prop = false;

    }

}

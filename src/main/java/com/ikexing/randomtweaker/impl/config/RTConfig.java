package com.ikexing.randomtweaker.impl.config;

import com.ikexing.randomtweaker.RandomTweaker;
import net.minecraftforge.common.config.Config;

/**
 * @author ikexing
 *
 * Config Settings
 */
@Config(modid = RandomTweaker.MODID)
public class RTConfig {
    @Config.RequiresMcRestart
    @Config.Comment("If true, The original dreamjournal will be no longer available.")
    public static boolean DreamJournal = false;
}

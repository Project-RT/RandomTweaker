package com.ikexing.randomtweaker.impl.config;

import com.ikexing.randomtweaker.RandomTweaker;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

import static net.minecraftforge.common.config.Config.Comment;

/**
 * @author ikexing
 * <p>
 * Config Settings
 */
@Config(modid = RandomTweaker.MODID)
public class RTConfig {
    @RequiresMcRestart
    @Comment("If true, The original DreamJournal will be no longer available.")
    public static boolean DreamJournal = false;

    @RequiresMcRestart
    @Comment("If true, You can manipulate randomtweaker.prop I / O")
    public static boolean Prop = true;
}
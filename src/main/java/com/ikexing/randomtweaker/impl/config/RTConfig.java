package com.ikexing.randomtweaker.impl.config;

import com.ikexing.randomtweaker.RandomTweaker;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

import static net.minecraftforge.common.config.Config.Comment;

/**
 * @author ikexing
 * <p>
 * Config Settings
 */
@Config(modid = RandomTweaker.MODID)
public class RTConfig {
    @LangKey("config.randomtweaker.thaumcraft.dreamjournal")
    @RequiresMcRestart
    @Comment("If true, The original DreamJournal will be no longer available.")
    public static boolean DreamJournal = false;
}
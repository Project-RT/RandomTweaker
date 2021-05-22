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
    @Comment("If true, The original DreamJournal will be no longer available. [default: false]")
    public static boolean DreamJournal = false;

    @RequiresMcRestart
    @Comment("If true, Allow CrT to manipulate the file \"randomtweaker.prop\". [default: true]")
    public static boolean Prop = true;

    @RequiresMcRestart
    @Comment("If true, the hydroangeas will not be modified. [default: false]")
    public static boolean HydroangeasModified = false;

    @RequiresMcRestart
    @Comment("If true, the hydroangeas won't decay. [Valid only for modified results | default: true]")
    public static boolean HydroangeasDecay = true;

    @RequiresMcRestart
    @Comment("How much mana is max of hydroangeas? [Valid only for modified results | default: 18000]")
    public static int HydroangeasMaxMana = 18000;
}
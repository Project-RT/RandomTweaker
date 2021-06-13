package com.ikexing.randomtweaker.impl.config;

import static net.minecraftforge.common.config.Config.Comment;

import com.ikexing.randomtweaker.RandomTweaker;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = RandomTweaker.MODID)
public class RTConfig {

    @Comment({
        "RandomTweaker",
        "This option decide the position of Sanity hud, the first parameter is the width, The second parameter is the height.",
        "The specific position is width and height of the game window divided by this number.",
        "[If the unit of measurement is px, then it refer to a fixed coordinate. e.g. 102px]",
        "[default : <6.0, 1.152>"
    })
    public static String[] SanityPos = {"6.0", "1.152"};

    @RequiresMcRestart
    @Comment({
        "RandomTweaker",
        "If true, when entering a world for the first time, it will generate a value of OriginalSanity randomly. [default : true]"
    })
    public static boolean OriginalSanity = true;

    @RequiresMcRestart
    @Comment({
        "RandomTweaker",
        "If true, the sanity function will be enabled. [default : false]"
    })
    public static boolean PlayerSanity = false;

    @RequiresMcRestart
    @Comment({
        "RandomTweaker",
        "If true, Allow CrT to manipulate the file \"randomtweaker.prop\". [default: false]"
    })
    public static boolean Prop = false;

    @RequiresMcRestart
    @Comment({
        "Thaumcraft",
        "If true, The original DreamJournal will be no longer available. [default: false]"
    })
    public static boolean DreamJournal = false;

    @RequiresMcRestart
    @Comment({
        "Botania",
        "If true, the hydroangeas will not be modified. [default: true]"
    })
    public static boolean HydroangeasModified = true;

    @RequiresMcRestart
    @Comment({
        "Botania",
        "If true, the hydroangeas won't decay. [Valid only for modified results | default: false]"
    })
    public static boolean HydroangeasDecay = false;

    @RequiresMcRestart
    @Comment({
        "Botania",
        "How much mana is max of hydroangeas? [Valid only for modified results | default: 18000]"
    })
    public static int HydroangeasMaxMana = 18000;

    @RequiresMcRestart
    @Comment({
        "The Twilight Forest",
        "Modify the liquid of Twilight forest portal. [Corresponding Mod Needed | default: water]"
    })
    public static String TFPortalLiquid = "water";
}

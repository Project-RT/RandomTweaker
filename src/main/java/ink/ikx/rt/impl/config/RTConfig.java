package ink.ikx.rt.impl.config;

import static net.minecraftforge.common.config.Config.Comment;

import ink.ikx.rt.RandomTweaker;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = RandomTweaker.MODID)
public class RTConfig {

    public static RandomTweakerC RandomTweaker = new RandomTweakerC();

    public static Botania Botania = new Botania();

    public static Thaumcraft Thaumcraft = new Thaumcraft();

    public static TwilightForest TwilightForest = new TwilightForest();

    public static FTBUltimine FTBUltimine = new FTBUltimine();

    public static ToughAsNails ToughAsNails = new ToughAsNails();

    public static class RandomTweakerC {

        @Comment({
            "This option decide the position of Sanity hud, the first parameter is the width, The second parameter is the height.",
            "The specific position is width and height of the game window divided by this number.",
            "[If the unit of measurement is px, then it refer to a fixed coordinate. e.g. 102px]",
            "[default : <6.0, 1.152>"
        })
        public String[] SanityPos = {"6.0", "1.152"};

        @RequiresMcRestart
        @Comment("If true, when entering a world for the first time, it will generate a value of OriginalSanity randomly. Otherwise, it is based on 100. [default : true]")
        public boolean OriginalSanity = true;

        @RequiresMcRestart
        @Comment("If true, the sanity function will be enabled. [default : false]")
        public boolean PlayerSanity = false;

        @RequiresMcRestart
        @Comment("If true, Allow CrT to manipulate the file \"randomtweaker.prop\". [default: false]")
        public boolean Prop = false;

    }

    public static class FTBUltimine {

        @RequiresMcRestart
        @Comment("If true, Allow Crt to Control the FTBUltimine enable")
        public boolean AllowCrTControl = false;
    }

    public static class TwilightForest {

        @Comment("Modify the liquid of Twilight forest portal. [Corresponding Mod Needed | default: water]")
        public String TFPortalLiquid = "water";
    }

    public static class Thaumcraft {

        @RequiresMcRestart
        @Comment("If true, The original DreamJournal will be no longer available. [default: false]")
        public boolean DreamJournal = false;
    }

    public static class Botania {

        @RequiresMcRestart
        @Comment("If true, the hydroangeas will be modified. [default: false]")
        public boolean HydroangeasModified = false;

        @RequiresMcRestart
        @Comment("If true, the hydroangeas won't decay. [Valid only for modified results | default: false]")
        public boolean HydroangeasDecay = false;

        @RequiresMcRestart
        @Comment("How much mana is max of hydroangeas? [Valid only for modified results | default: 18000]")
        public int HydroangeasMaxMana = 18000;

        @RequiresMcRestart
        @Comment("If true, the Orechid will be modified. [default: false]")
        public boolean OrechidModified = false;

        @RequiresMcRestart
        @Comment("How much the interval of each work of Orechid.[Valid only for modified results | default: 20]")
        public int OrechidCost = 20;

        @RequiresMcRestart
        @Comment("How much mana is consumed per work of Orechid.[Valid only for modified results | default: 700]")
        public int OrechidDelay = 700;

        @RequiresMcRestart
        @Comment("How much mana is max of Orechid? [Valid only for modified results | default: 18000]")
        public int OrechidMaxMana = 18000;

        @RequiresMcRestart
        @Comment("If true, the Orechid will keep the Botania recipes. [Valid only for modified results | default: true]")
        public boolean OrechidHasDefault = true;


    }

    public static class ToughAsNails {

        @Comment("If true, cancel Thirst when the player transforms into a android. [default: true]")
        public boolean AndroidThirst = true;

        @Comment("If true, enable 'B: SelectedStatThirst'. [default: true]")
        public boolean SelectedStatsThirst = false;

        @Comment("If 'B: AndroidThirst' false, Select the skill you need to unlock to cancel your Thirst. [default: 6 [0-21]]")
        public int SelectedStatThirst = 6;

        @Comment("If true, cancel Temperature when the player transforms into a android. [default: true]")
        public boolean AndroidTemperature = true;

        @Comment("If true, enable 'B: SelectedStatTemperature'. [default: true]")
        public boolean SelectedStatsTemperature = false;

        @Comment("If 'B: AndroidThirst' false, Select the skill you need to unlock to cancel your Temperature. [default: 14 [0-21]]")
        public int SelectedStatTemperature = 14;
    }
}
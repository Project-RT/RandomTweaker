package com.ikexing.randomtweaker.api.file;

import com.ikexing.randomtweaker.RandomTweaker;
import crafttweaker.CraftTweakerAPI;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ikexing
 */
@ZenClass("mods.randomtweaker.Prop")
public class Prop {
    private static final boolean ISWINDOWS = System.getProperties().getProperty("os.name").startsWith("Windows");
    private static final String MARK = ISWINDOWS ? "\\" : "/";
    private static final String FILE = getPath(System.getProperty("user.dir"), RandomTweaker.MODID + ".prop");

    @ZenMethod
    public static String read(String key) {
        Properties prop = new Properties();
        try {
            FileReader fr = new FileReader(FILE);
            prop.load(fr);
            fr.close();
            return prop.getProperty(key);
        } catch (IOException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return null;
    }

    @ZenMethod
    public static boolean write(String key, String value) {
        Properties prop = new Properties();
        try {
            prop.setProperty(key, value);
            FileWriter fw = new FileWriter(FILE);
            prop.store(fw, null);

            fw.close();
            return true;
        } catch (IOException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return false;
    }

    public static void createOrDelete(boolean flag) throws IOException {
        File file = new File(FILE);
        if (flag) {
            if (!file.exists()) {
                file.createNewFile();
            }
        } else {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String getPath(String... path) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : path) {
            sb.append(sb.toString().endsWith(MARK) ? s1 : (MARK + s1));
        }
        return sb.toString();
    }
}
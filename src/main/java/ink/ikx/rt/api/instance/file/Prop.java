package ink.ikx.rt.api.instance.file;

import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.RandomTweaker;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.randomtweaker.Prop")
public class Prop {

    private static final boolean ISWINDOWS = System.getProperties().getProperty("os.name").startsWith("Windows");
    private static final String MARK = ISWINDOWS ? "\\" : "/";
    private static final String FILE = getPath(System.getProperty("user.dir"),
        RandomTweaker.MODID + ".prop");

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
            InputStream in = new BufferedInputStream(new FileInputStream(FILE));
            prop.load(in);
            in.close();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(FILE, true));
            prop.setProperty(key, value);
            prop.store(out, "The New properties file");

            out.close();
            return true;
        } catch (IOException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return false;
    }

    @ZenMethod
    public static String[] getAllKeys() {
        List<String> keys = Lists.newArrayList();
        Properties prop = new Properties();
        try {
            FileReader fr = new FileReader(FILE);
            prop.load(fr);

            prop.keySet().forEach(s -> keys.add((String) s));
            fr.close();
        } catch (IOException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }
        return keys.toArray(new String[0]);
    }

    public static boolean createOrDelete(boolean flag) throws IOException {
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
        return flag;
    }

    public static String getPath(String... path) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : path) {
            sb.append(sb.toString().endsWith(MARK) ? s1 : (MARK + s1));
        }
        return sb.toString();
    }
}